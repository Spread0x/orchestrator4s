package jsoft.orchestrator.service

import jsoft.orchestrator.lib.{Extractor, Mapper}
import jsoft.orchestrator.model.Context
import jsoft.orchestrator.model.event.Event
import jsoft.orchestrator.model.task.Procedure
import jsoft.orchestrator.runtime.RuntimeContext

import java.util.UUID
import scala.concurrent.{ExecutionContext, Future}
import scala.util.Try

final case class OrchestratorServiceImpl(name: String, procedures: Array[Procedure])(implicit ec: ExecutionContext) extends OrchestratorService {

  private val leafNodes: Int = procedures.map(_.dispatchersSize).sum

  assert(leafNodes > 0, "At least one Procedure must no dispatch events.")

  //noinspection ConvertExpressionToSAM
  def dispatchAndExtract[T](events: Event*): Extractor[Future, T] = {
    assert(events.nonEmpty, "Events must be not empty")

    new Extractor[Future, T] {
      val runtimeContext: Context = RuntimeContext(UUID.randomUUID().toString, leafNodes, procedures)
      val binding: Future[Context] = runtimeContext.binding()

      runtimeContext.pushFromSeq(events)

      override def apply(mappers: Mapper[_, T, Future]*): Future[T] = {
        binding.flatMap { context =>
          var isRunning = true
          var itemFounded: Option[Future[T]] = None
          val it: Iterator[Mapper[_, T, Future]] = mappers.iterator

          while (isRunning && it.hasNext) {
            val item: Mapper[_, T, Future] = it.next()
            val maybeResult: Option[Future[T]] = Try(item.execute(context)).toOption.flatten
            if (maybeResult.isDefined) {
              itemFounded = maybeResult
              isRunning = false
            }
          }

          itemFounded.fold[Future[T]](Future.failed(new RuntimeException("Can't match any mapper")))(identity)
        }
      }
    }
  }

  override def dispatch(events: Event*): Future[Context] = {
    val runtimeContext: Context = RuntimeContext(UUID.randomUUID().toString, leafNodes, procedures)
    val binding: Future[Context] = runtimeContext.binding()
    runtimeContext.pushFromSeq(events)
    binding
  }
}
