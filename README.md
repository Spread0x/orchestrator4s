# Orchestrator4s

Orchestrator4s is a simple library to orchestrate yours applications easily.  
It provides a set of directives to declare how your applications works and which events are requires for dispatching
logic. In background a graph of dependencies is declared.

## Quick example

Let's see a classic web shop example.

Generally a web shop receives an order and generates a sequence of events inside the business logic. Here we have a set
of **Events**. Each functionality depends on events and dispatches new events to trigger others.

Let's see our model:

```scala
// Order from web site
case class WebItem(itemId: String, quantity: Int)
case class WebOrder(customerId: String, items: Seq[WebItem])

// Internal model
// Gives detailed information about a customer 
case class Customer(id: String, name: String, age: Int, directions: Seq[String])

// Internal and detailed order based on other entities
case class Item(id: String, price: Float)
case class Order(id: String, customer: Customer, items: Seq[Item])

// Id to track a customer order
case class TrackableOrder(id: String)

// Validation results
case object ValidOrder
case class InvalidOrder(reasons: String*)

// Final result  
sealed trait Result
case object OK extends Result
case object Error extends Result
```

Next we need declare which events are needed to dispatch our business logic.

```scala
import jsoft.orchestrator.model.event.EventDefinition
import jsoft.orchestrator.model.Directives._

val EventOrderPlaced: EventDefinition[WebOrder] = Event("order_placed")
  .withDescription("Order placed from web service")

val EventCustomerInfo: EventDefinition[Customer] = Event("find_customer_info")
  .withDescription("Gets detailed information about a customer")

val EventOrderInvalid: EventDefinition[InvalidOrder] = Event("invalid_order")
  .withDescription("Validates an order from web. Returns a set of issues detailing errors.")

val EventOrderValid: EventDefinition[ValidOrder.type] = Event("valid_order")
  .withDescription("Represent a validation successful")

val EventTrackableOrder: EventDefinition[TrackableOrder] = Event("trackable_order")
  .withDescription("Gives a id for tracking an order")

val EventGenerateOrderTrackID: EventDefinition[String] = Event("event_generate_order_track_id")
  .withDescription("Generate an identifier")

val EventOrderBuilt: EventDefinition[Order] = Event("generate_order")
  .withDescription("Builds a internal order")
```

Now is time to declare our logic:

```scala
import jsoft.orchestrator.model.Directives._

val WebShowDefinition: Seq[Procedure] = Seq(

  Process("find-customer")
    // which events dispatch receptor logic
    .triggers(EventOrderPlaced)
    // which events this process dispatch
    .dispatch(EventCustomerInfo)
    // business logic
    .receptor { webOrder =>
      // EventDefinitions can build events and send it. 
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
    // this process run without dependecies
    .triggers(AutoTrigger)
    .dispatch(EventGenerateOrderTrackID, EventOrderInvalid)
    // when something fails, we can catch errors and follow execution
    .recoverWith(throwable => EventOrderInvalid(InvalidOrder("Some was wrong")))
    .receptor { () =>
      EventGenerateOrderTrackID(UUID.randomUUID().toString)
    },

  Process("build-order")
    .triggers(EventOrderValid + EventGenerateOrderTrackID + EventCustomerInfo + EventOrderPlaced)
    .dispatch(EventOrderBuilt)
    // max retries when receptor logic fails
    .maxRetries(10)
    .receptor { (_, id, customer, webOrder) =>
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
```

Finally, we need join all to declare our orchestrator.

```scala
import jsoft.orchestrator.model.Directives._

val webShowOrchestrator = Orchestrate("web-shop", WebShowDefinition: _*)
```

We can call it using two ways.

1. Simple dispatch

```scala
webShowOrchestrator.dispatch(EventOrderPlaced(orderInstance)).onComplete {
  case Failure(exception) =>
  case Success(context) =>
    val trackableOrder: Option[TrackableOrder] = context.getEvent(EventTrackableOrder)
  // do something
}
```

2. Dispatch and extract

```scala
// Here EventDefinition is used as Event extractor from call
// Each extraction must returns same type
val result: Future[Result] = webShowOrchestrator.dispatchAndExtract[Result](EventOrderPlaced(orderInstance))(
  EventTrackableOrder(_ => OK),
  EventOrderInvalid(x => Error)
)
```

That is. To see full example go to example source code in this repository.

## Background

When process are declared, triggers and dispatchers defines a dependency graph. This graph must be acyclic, determinist
and must have almost one final state. When an event starts an execution, this can stop if an error occurred, a process
doesn't dispatch events or for a event dispatched no exists a process which depends on it.

The task can run in parallel when dependency declaration allows it.

## Missing features

This project is a simple idea developed. Many features can be implemented, specially related with failing.

* If JVM crash, no persisted state of execution is stored.
* Missing clustering support.
* Missing transaction support.
* Missing diagram exporting.

## Need something else? 
Send to me an issue!! :)
