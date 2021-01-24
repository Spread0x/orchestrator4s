package jsoft.orchestrator

import jsoft.orchestrator.model.dependency.ApplyConverter
import jsoft.orchestrator.runtime.RuntimeContext

import scala.concurrent.{CanAwait, ExecutionContext, Future}
import scala.concurrent.duration.Duration
import scala.util.Try

package object model {
  type Context = RuntimeContext
  type ACAux[A, B , C] = ApplyConverter[A, B]{type In  = C}
}
