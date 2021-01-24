package jsoft.orchestrator.model.dependency

trait Join[L, R] {
  type OUT

  def apply(a: L, b: R): OUT
}
