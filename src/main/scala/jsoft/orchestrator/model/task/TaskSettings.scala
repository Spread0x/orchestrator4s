package jsoft.orchestrator.model.task

import jsoft.orchestrator.model.ACAux
import jsoft.orchestrator.model.event.{Event, EventDefinition}
import jsoft.orchestrator.model.solver.SolverSettings

final case class TaskSettings[L, B](
                                     spec: SolverSettings[L],
                                     acp: ACAux[L, Event, B],
                                     dispatchesLocal: Array[EventDefinition[_]],
                                     maxRetriesOnFail: Int = 1
                                   ) {

  def dispatch(eventsDef: EventDefinition[_]*): TaskSettings[L, B] = TaskSettings(spec, acp, Array(eventsDef: _*))

  def maxRetries(retries: Int): TaskSettings[L, B] = {
    assert(maxRetriesOnFail > 0, "Must be non zero value")
    TaskSettings(spec, acp, dispatchesLocal, retries)
  }

  def receptor(in: B): Procedure = {

    val impl: L => Event = acp(in)

    new Procedure {
      override type Repr = L
      val maxRetries: Int = maxRetriesOnFail
      val identifier: String = spec.metadata.name
      val dispatchers: Array[EventDefinition[_]] = dispatchesLocal
      val solverSettings: SolverSettings[L] = spec
      val routine: L => Event = impl
    }
  }
}
