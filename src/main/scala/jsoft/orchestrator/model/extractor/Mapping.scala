package jsoft.orchestrator.model.extractor
import scala.language.higherKinds

trait Mapping[A, F[x]] {

  def get[B](datum: A): F[B]

}
