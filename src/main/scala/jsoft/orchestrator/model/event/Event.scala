package jsoft.orchestrator.model.event

trait Event {

  type Repr

  def name: String

  def id: String

  protected def value: Repr

  override def toString: String = name

  def as[T:Manifest]: Option[T] = {
    value match {
      case t: T => Option(t)
      case _ => None
    }
  }

}
