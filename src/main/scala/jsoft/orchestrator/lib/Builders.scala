package jsoft.orchestrator.lib

import jsoft.orchestrator.model.event.Event

object Builders {
  final def eventBuilder[A](eventName: String, eventID: String, eventInstance: A): Event {type Repr = A} = new Event {
    override type Repr = A

    val name: String = eventName
    val id: String = eventID
    val value: Repr = eventInstance
  }

}
