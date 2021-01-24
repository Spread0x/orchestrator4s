package jsoft.orchestrator.model.event

import scala.reflect.runtime.universe.typeOf

trait Event {

  type Repr

  def name: String

  protected val id: String
  protected val value: Repr

  override def toString: String = name

  def as[T: Manifest]: Option[T] = {
    if (typeOf[T].dealias.toString == id) Option(value.asInstanceOf[T]) else None
  }

}
