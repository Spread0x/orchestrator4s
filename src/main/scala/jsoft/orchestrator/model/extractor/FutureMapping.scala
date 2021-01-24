package jsoft.orchestrator.model.extractor

import scala.concurrent.Future

trait FutureMapping[A] extends Mapping[A, Future] {
  def get[B](datum: A): Future[B]
}
