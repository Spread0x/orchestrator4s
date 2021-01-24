package jsoft.orchestrator.service

import jsoft.orchestrator.lib.Extractor
import jsoft.orchestrator.model.Context
import jsoft.orchestrator.model.task.{Procedure, Task}

import scala.concurrent.Future

trait OrchestratorService {
  def name: String

  def procedures: Array[Procedure]

  def dispatch(tasks: Task*): Future[Context]

  def dispatchAndExtract[T](tasks: Task*): Extractor[Future, T]
}
