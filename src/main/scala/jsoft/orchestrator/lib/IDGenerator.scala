package jsoft.orchestrator.lib

import java.util.UUID

object IDGenerator {
  def apply(): String = UUID.randomUUID().toString
}
