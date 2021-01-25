package jsoft.orchestrator.lib

import jsoft.orchestrator.model.event.Event

import scala.reflect.runtime.universe.typeOf

object Builders {
  final def eventBuilder[A: Manifest](item: (String, A)): Event {type Repr = A} = new Event {
    override type Repr = A

    val name: String = item._1
    val id: String = typeOf[A].dealias.toString
    val value: Repr = item._2
  }

}
