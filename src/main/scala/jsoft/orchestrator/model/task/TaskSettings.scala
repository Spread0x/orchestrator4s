package jsoft.orchestrator.model.task

import jsoft.orchestrator.model.ACAux
import jsoft.orchestrator.model.event.EventDefinition
import jsoft.orchestrator.model.solver.SolverSettings

final case class TaskSettings[L, B](
                                     spec: SolverSettings[L],
                                     acp: ACAux[L, Task, B],
                                     dispatchesLocal: Array[EventDefinition[_]],
                                     maxRetryOnFail: Int = 1
                                   ) {

  assert(maxRetryOnFail > 0, "Must be non zero value")

  def dispatch(eventsDef: EventDefinition[_]*): TaskSettings[L, B] = TaskSettings(spec, acp, Array(eventsDef: _*))

  def receptor(in: B): Procedure = {

    val impl: L => Task = acp(in)

    new Procedure {
      override type Repr = L
      val identifier: String = spec.metadata.name
      val dispatchers: Array[EventDefinition[_]] = dispatchesLocal
      val solverSettings: SolverSettings[L] = spec
      val routine: L => Task = impl
    }
  }
}
