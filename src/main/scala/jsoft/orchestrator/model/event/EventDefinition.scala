package jsoft.orchestrator.model.event

import jsoft.orchestrator.lib.{Builders, Mapper}
import jsoft.orchestrator.model.Context
import jsoft.orchestrator.model.dependency.Dependency

import scala.concurrent.Future
import scala.util.Try

final case class EventDefinition[T: Manifest](eventName: String, description: Option[String]) extends Dependency[Tuple1[T]] {

  val scope: Set[String] = Set(eventName)

  def apply(instance: T): Event = Builders.eventBuilder(eventName, instance)

  def apply[B](f: T => B): Mapper[T, B, Future] = {
    val me: EventDefinition[T] = this
    (context: Context) => {
      context.getEvents(me).headOption.flatMap(_.as[T]).map(value => Future.fromTry(Try(f(value))))
    }
  }

  def withDescription(des: String): EventDefinition[T] = EventDefinition(eventName, Option(des))

  override def extract(context: Context): Option[Tuple1[T]] = {
    context.getEvent(eventName).flatMap(_.as[T]).map(Tuple1(_))
  }

  override def isReady(context: Context): Boolean = {
    context.hasEvent(eventName)
  }

}
