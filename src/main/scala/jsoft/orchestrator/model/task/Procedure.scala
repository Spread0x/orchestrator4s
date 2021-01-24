package jsoft.orchestrator.model.task

import jsoft.orchestrator.model.Context
import jsoft.orchestrator.model.dependency.Dependency
import jsoft.orchestrator.model.event.EventDefinition
import jsoft.orchestrator.model.solver.SolverSettings

trait Procedure {
  type Repr

  def scope: Set[String] = solverSettings.dependency.scope

  def identifier: String

  def solverSettings: SolverSettings[Repr]

  def dispatchersSize: Int = dispatchers.length

  def dispatchers: Array[EventDefinition[_]]

  def dependsOf(depsName: String): Boolean = scope.contains(depsName)

  def routine: Repr => Task

  def isReady(context: Context): Boolean = {
    solverSettings.dependency.isReady(context)
  }

  def execute(context: Context): Unit = {
    val dependency: Dependency[Repr] = solverSettings.dependency

    dependency.extract(context) match {
      case Some(data) => context.push(routine(data))
      case None => println(s"Cant extract data from Context in procedure '$identifier'")
    }
  }
}