package jsoft.orchestrator.model.dependency

trait ApplyConverter[L, R] {
  type In

  def apply(in: In): L => R
}

