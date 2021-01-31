package jsoft.orchestrator.model

import jsoft.orchestrator.model.dependency.impl.TaskApplyConverter
import jsoft.orchestrator.model.dependency.{Dependency, JoinInstances}
import jsoft.orchestrator.model.event.{Event, EventDefinition}
import jsoft.orchestrator.model.solver.SolverMetadata
import jsoft.orchestrator.model.task.Procedure
import jsoft.orchestrator.service.{OrchestratorService, OrchestratorServiceImpl}

import scala.concurrent.{ExecutionContext, Future}
import scala.language.implicitConversions
import scala.util.{Failure, Success}

trait OrchestratorDirectives extends TaskApplyConverter with JoinInstances {

  final val AutoTrigger = new Dependency[Unit] {
    val scope: Set[String] = Set.empty

    override def extract(context: Context): Option[Unit] = Some({})

    override def isReady(context: Context): Boolean = true

  }

  final def Orchestrate(name: String, procedures: Procedure*)(implicit ec: ExecutionContext): OrchestratorService = OrchestratorServiceImpl(name, Array(procedures: _*))

  final def Event[T: Manifest](eventName: String): EventDefinition[T] = EventDefinition(eventName, None)

  final def Process(name: String): SolverMetadata = SolverMetadata(name, None)

  final implicit def futureAsTask(future: Future[Event])(implicit ec: ExecutionContext): Task = { ctx =>
    future.onComplete {
      case Failure(exception) => exception.printStackTrace()
      case Success(event) => ctx.push(event)
    }
  }

  final implicit def eventAsTask(event: Event): Task = { ctx =>
    ctx.push(event)
  }
}

object OrchestratorDirectives extends OrchestratorDirectives {
}