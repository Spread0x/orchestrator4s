package jsoft.orchestrator.model.task

import jsoft.orchestrator.model.event.Event

trait Task extends (() => Event)
