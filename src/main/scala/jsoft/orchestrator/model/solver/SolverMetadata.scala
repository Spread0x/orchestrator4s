package jsoft.orchestrator.model.solver

import jsoft.orchestrator.model.dependency.{ApplyConverter, Dependency}
import jsoft.orchestrator.model.task
import jsoft.orchestrator.model.task.{Task, TaskSettings}

final case class SolverMetadata(name: String, description: Option[String]) {
  def withDescription(desc: String): SolverMetadata = SolverMetadata(name, Option(desc))

  def triggers[L](deps: Dependency[L])(implicit acp: ApplyConverter[L, Task]): TaskSettings[L, acp.In] = {
    val me: SolverMetadata = this
    val dep: SolverSettings[L] = SolverSettings(me, deps)
    task.TaskSettings(dep, acp, Array.empty)
  }
}