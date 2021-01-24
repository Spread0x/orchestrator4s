package jsoft.orchestrator.runtime

import io.timeandspace.smoothie.SmoothieMap
import jsoft.orchestrator.model.Context
import jsoft.orchestrator.model.event.{Event, EventDefinition}
import jsoft.orchestrator.model.state.{Finished, Idle, Running, State}
import jsoft.orchestrator.model.task.{Procedure, Task}

import scala.concurrent.{ExecutionContext, Future, Promise}
import scala.util.{Failure, Success, Try}

final case class RuntimeContext(pid: String, leafNodes: Int, procedures: Array[Procedure])(implicit ec: ExecutionContext) {

  private val size: Int = procedures.length
  private val eventsStore: SmoothieMap[String, Event] = SmoothieMap.newBuilder[String, Event]().expectedSize(size).build()
  private val executed: Array[(State, Int)] = Array.fill[State](size)(Idle).zipWithIndex

  private val promise: Promise[Context] = Promise()
  private val maybeResult: Future[Context] = promise.future

  def binding(): Future[Context] = maybeResult

  def hasEvent(eventName: String): Boolean = {
    eventsStore.containsKey(eventName)
  }

  def getEvents(eventSpec: EventDefinition[_]*): Seq[Event] = eventSpec.flatMap(x => getEvent(x.eventName))

  def getEvent(eventName: String): Option[Event] = Option(eventsStore.get(eventName))

  def push(tasks: Task*): Unit = synchronized {

    if (!promise.isCompleted) {
      val maybeWorks: Try[Boolean] = Try {
        tasks.exists { eventExtractor =>
          val event: Event = eventExtractor()

          eventsStore.putIfAbsent(event.name, event)
          hasDependents(event)
        }
      }

      maybeWorks match {
        case Failure(exception) => promise.failure(exception)
        case Success(hasDependents) =>
          if (hasDependents) {
            ec.execute(() => checkForDependencies())
          } else {
            completeCall()
          }
      }
    }
  }

  private def checkForDependencies(): Unit = {
    val me: Context = this

    executed
      .filter(_._1.isIdle)
      .foreach { case (_, idx) =>

        val proc: Procedure = procedures(idx)

        if (proc.isReady(me)) {
          updateState(idx, Running)
          tryExecute(proc.execute(me)) {
            updateState(idx, Finished)

            val promiseAvailable: Boolean = !promise.isCompleted
            val isLeaf: Boolean = proc.dispatchersSize == 0
            val shouldStop: Boolean = promiseAvailable && isLeaf

            if (shouldStop) {
              completeCall()
            }
          }
        }
      }
  }

  private def tryExecute(block: => Unit)(onComplete: => Unit): Unit = {

    ec.execute { () =>
      Try(block) match {
        case Failure(exception) =>
          if (!promise.isCompleted) {
            promise.failure(exception)
          }
        case _ =>
      }
      onComplete
    }
  }

  private def updateState(idx: Int, state: State): Unit = {
    executed(idx) = (state, idx)
  }

  private def hasDependents(event: Event): Boolean = {
    val eventName: String = event.name
    procedures.exists(_.dependsOf(eventName))
  }

  private def completeCall(): Unit = {
    if (!promise.isCompleted) promise.success(this)
  }
}
