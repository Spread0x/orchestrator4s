package jsoft.orchestrator.lib

trait Extractor[F[x], OUTPUT] {
  def apply(m: Mapper[_, OUTPUT, F]*): F[OUTPUT]
}