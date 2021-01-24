package jsoft.orchestrator.example

import jsoft.orchestrator.model.dependency.JoinInstances
import jsoft.orchestrator.model.dependency.impl.EventApplyConverter
import jsoft.orchestrator.model.event.EventDefinition
import jsoft.orchestrator.model.task.Procedure
import jsoft.orchestrator.model.{Context, Directives}
import jsoft.orchestrator.service.OrchestratorService

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

object Second extends EventApplyConverter with Directives with JoinInstances {

  final case class Collector(val1: Int, val2: Int)

  def main(args: Array[String]): Unit = {

    val EventValue1: EventDefinition[Int] = Event[Int]("EventValue1")
    val EventValue2: EventDefinition[Int] = Event[Int]("EventValue2")
    val EventCollector: EventDefinition[Collector] = Event[Collector]("EventCollector")
    val EventSum: EventDefinition[Int] = Event[Int]("EventSum")
    val EventSum2: EventDefinition[Int] = Event[Int]("EventSum2")

    val processOrderRoutine: Procedure = Process("process_order")
      .withDescription("Solve input order")
      .triggers(EventValue1 + EventValue2)
      .dispatch(EventCollector)
      .receptor { (a, b) =>
        println(a)
        println(b)

        EventCollector(Collector(a, b))
      }

    val sumRoutine: Procedure = Process("sum_values")
      .withDescription("Creates a sum value")
      .triggers(EventCollector)
      .dispatch(EventSum)
      .receptor { collector =>
        println(collector)
        EventSum(collector.val1 + collector.val2)
      }

    val total: Procedure = Process("EventSum")
      .withDescription("Creates a sum value")
      .triggers(EventSum)
      .receptor { result =>
        println(result)
        ???
      }

    val total2: Procedure = Process("EventSum")
      .withDescription("Creates a EventSum value")
      .triggers(EventSum2)
      .receptor { result =>
        println(result * 2)
        ???
      }

    val createProdService: OrchestratorService = Orchestrate("createProduct", processOrderRoutine, sumRoutine, total, total2)
    val bind: Future[Context] = createProdService.dispatch(EventValue1(10), EventValue2(2))

    Await.result(bind, Duration.Inf)

  }
}
