package de.zeller.spockexample.task.e2e.pages

import geb.Page

class MainPage extends Page {
    static url = "/"
    static atCheckWaiting = true

    static at = {
        $(".head > h2:nth-child(1)").text() == "To-Do App"
    }

    static content = {
        titleField { $("#title") }
        dueDateField { $("#due_date") }
        submitButton { $("#submit_button") }
        taskList {
            $(".main > div:nth-child(2)").module(TaskListModule)
        }
    }

    void createTask(String title, String description) {
        titleField.value(title)
        dueDateField.value(description)
        submitButton.click()
    }
}