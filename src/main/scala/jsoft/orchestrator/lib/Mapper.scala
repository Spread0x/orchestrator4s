package jsoft.orchestrator.lib

import jsoft.orchestrator.model.Context

trait Mapper[A, B, F[x]]  {
  def execute(context: Context): Option[F[B]]
}
