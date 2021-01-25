package jsoft.orchestrator.model.task

import jsoft.orchestrator.model.{ACAux, Recovery, Task}
import jsoft.orchestrator.model.event.{Event, EventDefinition}
import jsoft.orchestrator.model.solver.SolverSettings

final case class TaskSettings[L, B](
                                     spec: SolverSettings[L],
                                     acp: ACAux[L, Task, B],
                                     dispatchesLocal: Array[EventDefinition[_]],
                                     maxRetriesOnFail: Int = 1,
                                     recoverFunc: Option[Recovery] = None
                                   ) {

  def dispatch(eventsDef: EventDefinition[_]*): TaskSettings[L, B] = TaskSettings(spec, acp, Array(eventsDef: _*), maxRetriesOnFail, recoverFunc)

  def maxRetries(retries: Int): TaskSettings[L, B] = {
    assert(maxRetriesOnFail > 0, "Must be non zero value")
    TaskSettings(spec, acp, dispatchesLocal, retries, recoverFunc)
  }

  def recoverWith(f: Throwable => Task): TaskSettings[L, B] = TaskSettings(spec, acp, dispatchesLocal, maxRetriesOnFail, Option(f))

  def receptor(in: B): Procedure = {

    val impl: L => Task = acp(in)

    new Procedure {
      override type Repr = L
      val maxRetries: Int = maxRetriesOnFail
      val identifier: String = spec.metadata.name
      val dispatchers: Array[EventDefinition[_]] = dispatchesLocal
      val solverSettings: SolverSettings[L] = spec
      val routine: L => Task = impl
      val recover: Option[Recovery] = recoverFunc
    }
  }
}
