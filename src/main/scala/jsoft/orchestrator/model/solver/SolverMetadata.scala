package jsoft.orchestrator.model.solver

import jsoft.orchestrator.model.OrchestratorDirectives.AutoTrigger
import jsoft.orchestrator.model.Task
import jsoft.orchestrator.model.dependency.{ApplyConverter, Dependency}
import jsoft.orchestrator.model.task.TaskSettings

final case class SolverMetadata(name: String, description: Option[String]) {
  def withDescription(desc: String): SolverMetadata = SolverMetadata(name, Option(desc))

  def triggers()(implicit acp: ApplyConverter[Unit, Task]): TaskSettings[Unit, acp.In] = {
    val me: SolverMetadata = this
    val dep: SolverSettings[Unit] = SolverSettings(me, AutoTrigger)
    TaskSettings(dep, acp, Array.empty)
  }

  def triggers[L](deps: Dependency[L])(implicit acp: ApplyConverter[L, Task]): TaskSettings[L, acp.In] = {
    val me: SolverMetadata = this
    val dep: SolverSettings[L] = SolverSettings(me, deps)
    TaskSettings(dep, acp, Array.empty)
  }
}
