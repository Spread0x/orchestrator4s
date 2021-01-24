package jsoft.orchestrator.model

import jsoft.orchestrator.model.dependency.impl.EventApplyConverter
import jsoft.orchestrator.model.dependency.{Dependency, JoinInstances}
import jsoft.orchestrator.model.event.{Event, EventDefinition}
import jsoft.orchestrator.model.solver.SolverMetadata
import jsoft.orchestrator.model.task.Procedure
import jsoft.orchestrator.service.{OrchestratorService, OrchestratorServiceImpl}

import scala.concurrent.ExecutionContext
import scala.language.implicitConversions
import scala.reflect.runtime.universe.typeOf

trait Directives extends EventApplyConverter with JoinInstances {

  final val AutoTrigger = new Dependency[Unit] {
    val scope: Set[String] = Set.empty

    override def extract(context: Context): Option[Unit] = Some({})

    override def isReady(context: Context): Boolean = true

  }

//  final implicit def asEvent[A: Manifest](item: (String, A)): Event {type Repr = A} = Directives.eventBuilder(item)

  final def Orchestrate(name: String, procedures: Procedure*)(implicit ec: ExecutionContext): OrchestratorService = OrchestratorServiceImpl(name, Array(procedures: _*))

  final def Event[T: Manifest](eventName: String): EventDefinition[T] = EventDefinition(eventName, None)

  final def Process(name: String): SolverMetadata = SolverMetadata(name, None)
}

object Directives {
  final def eventBuilder[A: Manifest](item: (String, A)): Event {type Repr = A} = new Event {
    override type Repr = A

    val name: String = item._1
    val id: String = typeOf[A].dealias.toString
    val value: Repr = item._2
  }
}