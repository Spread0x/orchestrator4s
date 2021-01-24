package jsoft.orchestrator.example

import jsoft.orchestrator.model.event.EventDefinition
import jsoft.orchestrator.model.task.Procedure
import jsoft.orchestrator.model.{Directives, Context}
import jsoft.orchestrator.service.OrchestratorService

import java.util.UUID
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

object Third extends Directives {

  final case class Client(directions: Seq[String], accounts: Set[UUID])

  def main(args: Array[String]): Unit = {

    val EventGetClient: EventDefinition[String] = Event[String]("EventGetClient")
    val EventDirections: EventDefinition[Seq[String]] = Event[Seq[String]]("EventDirections")
    val EventAccounts: EventDefinition[Set[UUID]] = Event[Set[UUID]]("EventAccounts")
    val EventComplete: EventDefinition[Client] = Event("EventComplete")

    val obtainDirections: Procedure = Process("get client directions")
      .triggers(EventGetClient)
      .dispatch(EventDirections)
      .receptor { clientId =>
        EventDirections(List(s"$clientId-dir1", s"$clientId-dir2"))
      }

    val obtainAccounts: Procedure = Process("get client accounts")
      .triggers(EventGetClient)
      .dispatch(EventAccounts)
      .receptor { clientId =>
        EventAccounts(Set(UUID.randomUUID()))
      }

    val collectAll: Procedure = Process("collect all")
      .triggers(EventDirections + EventAccounts)
      .receptor { (a, b) =>
        println(a)
        println(b)
        EventComplete(Client(a, b))
      }

    val createProdService: OrchestratorService = Orchestrate("createProduct", obtainDirections, obtainAccounts, collectAll)
    val bind: Future[Context] = createProdService.dispatch(EventGetClient("Joaco"))

    val result: Context = Await.result(bind, Duration.Inf)

    println(result.getEvents(EventComplete).flatMap(_.as[Client]))
  }
}
