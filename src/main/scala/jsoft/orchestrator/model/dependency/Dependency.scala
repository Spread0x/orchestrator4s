package jsoft.orchestrator.model.dependency

import jsoft.orchestrator.model.Context

trait Dependency[L] {
  me =>

  def scope: Set[String]

  def extract(context: Context): Option[L]

  def isReady(context: Context): Boolean

  def +[R](other: Dependency[R])(implicit join: Join[L, R]): Dependency[join.OUT] = {

    new Dependency[join.OUT] {

      val scope: Set[String] = me.scope ++ other.scope

      override def isReady(context: Context): Boolean = me.isReady(context) && other.isReady(context)

      override def extract(v1: Context): Option[join.OUT] = {
        for (a1 <- me.extract(v1); a2 <- other.extract(v1)) yield join(a1, a2)
      }

    }
  }
}
