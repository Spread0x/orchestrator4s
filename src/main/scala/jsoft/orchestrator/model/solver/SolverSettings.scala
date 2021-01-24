package jsoft.orchestrator.model.solver

import jsoft.orchestrator.model.dependency.Dependency

final case class SolverSettings[L](metadata: SolverMetadata, dependency: Dependency[L])
