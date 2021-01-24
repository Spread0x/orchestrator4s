package jsoft.orchestrator.service

import jsoft.orchestrator.lib.Extractor
import jsoft.orchestrator.model.Context
import jsoft.orchestrator.model.event.Event
import jsoft.orchestrator.model.task.Procedure

import scala.concurrent.Future

trait OrchestratorService {
  def name: String

  def procedures: Array[Procedure]

  def dispatch(events: Event*): Future[Context]

  def dispatchAndExtract[T](events: Event*): Extractor[Future, T]
}
