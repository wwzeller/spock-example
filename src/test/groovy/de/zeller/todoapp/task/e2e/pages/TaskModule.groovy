package de.zeller.todoapp.task.e2e.pages

import geb.Module

class TaskModule extends Module {
    static content = {
        taskButton { $(".task_form > .task") }
        taskTitle { $(".task_form > .task > .title_span").text() }
        descriptionText { $(".task_form > .task > .description_span").text() }
        dueDateText { $(".task_form > .task > .due_date_span").text() }
        doneText { $(".task_form > .task > .done_span").text() }
    }
}
