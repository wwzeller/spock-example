package de.zeller.todoapp.task.e2e.pages

import geb.Page

class MainPage extends Page {
    static url = "/"
    static atCheckWaiting = true

    static at = {
        $(".head > h2:nth-child(1)").text() == "To-Do App"
    }

    static content = {
        titleField { $("#title") }
        descriptionField { $("#description") }
        dueDateField { $("#due_date") }
        submitButton { $("#submit_button") }
        taskList {
            $(".main > #task_list").module(TaskListModule)
        }
    }

    void createTask(String title, String description) {
        titleField.value(title)
        descriptionField.value(description)
        submitButton.click()
    }
}