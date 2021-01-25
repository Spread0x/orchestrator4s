package jsoft.orchestrator

import jsoft.orchestrator.model.dependency.ApplyConverter
import jsoft.orchestrator.runtime.RuntimeContext

package object model {
  type Context = RuntimeContext
  type ACAux[A, B, C] = ApplyConverter[A, B] {type In = C}
  type Task = Context => Unit
}
