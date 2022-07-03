package de.zeller.todoapp.task.e2e.pages

import geb.Module

class TaskListModule extends Module {
    static content = {
        tasks {
            $(".task-panel").collect {
                it.module(TaskModule)
            }
        }
    }
}
