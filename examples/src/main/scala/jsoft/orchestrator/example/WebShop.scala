package jsoft.orchestrator.example

import jsoft.orchestrator.model.Directives
import jsoft.orchestrator.model.event.EventDefinition
import jsoft.orchestrator.model.task.Procedure

import java.util.UUID
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.util.Try

case object WebShop extends App with Directives {

  /** model */
  case class WebItem(itemId: String, quantity: Int)
  case class WebOrder(customerId: String, items: Seq[WebItem])

  case class Customer(id: String, name: String, age: Int, directions: Seq[String])

  case class Item(id: String, price: Float)
  case class Order(id: String, customer: Customer, items: Seq[Item])

  case class TrackableOrder(id: String)

  case object ValidOrder
  case class InvalidOrder(reasons: String*)

  sealed trait Result
  case object OK extends Result
  case object Error extends Result

  /** events */
  private val EventOrderPlaced: EventDefinition[WebOrder] = Event[WebOrder]("order_placed").withDescription("Order placed from web service")
  private val EventCustomerInfo: EventDefinition[Customer] = Event[Customer]("find_customer_info")
  private val EventOrderBuilt: EventDefinition[Order] = Event[Order]("generate_order")
  private val EventOrderInvalid: EventDefinition[InvalidOrder] = Event[InvalidOrder]("invalid_order")
  private val EventOrderValid: EventDefinition[ValidOrder.type] = Event[ValidOrder.type]("valid_order")
  private val EventTrackableOrder: EventDefinition[TrackableOrder] = Event[TrackableOrder]("trackable_order")
  private val EventGenerateOrderTrackID: EventDefinition[String] = Event[String]("event_generate_order_track_id")

  /** processors */
  private val WebShowDefinition: Seq[Procedure] = Seq(
    Process("find-customer")
      .triggers(EventOrderPlaced)
      .dispatch(EventCustomerInfo)
      .receptor { webOrder =>
        EventCustomerInfo(Customer(webOrder.customerId, "Tom", 25, Seq("Some where")))
      },

    Process("validate-order")
      .triggers(EventOrderPlaced)
      .dispatch(EventOrderInvalid, EventOrderValid)
      .receptor { webOrder =>
        if (webOrder.items.isEmpty) {
          EventOrderInvalid(InvalidOrder("Empty items"))
        } else {
          EventOrderValid(ValidOrder)
        }
      },

    Process("build-id")
      .triggers(AutoTrigger)
      .dispatch(EventGenerateOrderTrackID)
      .receptor { () =>
        EventGenerateOrderTrackID(UUID.randomUUID().toString)
      },

    Process("build-order")
      .triggers(EventOrderValid + EventGenerateOrderTrackID + EventCustomerInfo + EventOrderPlaced)
      .dispatch(EventOrderBuilt)
      .maxRetries(10)
      .recoverWith(throwable => EventOrderInvalid(InvalidOrder("Some was wrong")))
      .receptor { (_, id, customer, webOrder) =>
        throw new RuntimeException("pepe")
        EventOrderBuilt {
          Order(id, customer, webOrder.items.map(x => Item(x.itemId, (x.quantity * 2).toFloat)))
        }
      },

    Process("complete-with-trackable")
      .triggers(EventOrderBuilt)
      .receptor { order =>
        EventTrackableOrder(TrackableOrder(order.id))
      }
  )

  private val webShowOrchestrator = Orchestrate("web-shop", WebShowDefinition: _*)
  //  private val orderInstance: WebOrder = WebOrder("joaco", Nil)
  private val orderInstance: WebOrder = WebOrder("joaco", Seq(WebItem("pc", 1)))
  Try {

    val call: Future[Result] = webShowOrchestrator.dispatchAndExtract[Result](EventOrderPlaced(orderInstance))(
      EventTrackableOrder(_ => OK),
      EventOrderInvalid { x =>
        println(x)
        Error
      }
    )
    Await.result(call, Duration.Inf)
  }.fold(e => e.printStackTrace(), println)
}


