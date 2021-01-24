package jsoft.orchestrator.model

package object state {

  trait State {
    def isIdle: Boolean

    def isRunning: Boolean

    def isCompleted: Boolean
  }

  case object Idle extends State {
    val isIdle = true
    val isRunning = false
    val isCompleted = false
  }

  case object Running extends State {
    val isIdle = false
    val isRunning = true
    val isCompleted = false
  }

  case object Finished extends State {
    val isIdle = false
    val isRunning = false
    val isCompleted = true
  }
}
