package de.zeller.todoapp.task.e2e


import de.zeller.todoapp.task.e2e.pages.MainPage

import java.time.LocalDate

class GebTaskControllerSpec extends BaseGebSpec {

    def "basic geb test"() {
        when:
        to MainPage

        then:
        submitButton.value() == "Erstellen"
    }

    def "create first task"() {
        when:
        to MainPage

        and:
        createTask("Test title", "test description")

        then:
        taskList.tasks[0].taskTitle == "1. Test title"
        taskList.tasks[0].descriptionText == "test description"
        taskList.tasks[0].dueDateText == "fällig am " + LocalDate.now().toString()
    }

    def "Erster Task"() {
        when:
        to MainPage

        and:
        createTask("Test title", "test description")

        then:
        taskList.tasks.size() == 1
    }

    def "create first task and click on title"() {
        when:
        to MainPage

        and:
        createTask("Test title", "test description")
        taskList.tasks[0].taskButton.click()

        then:
        taskList.tasks[0].taskTitle == "1. Test title"
        taskList.tasks[0].descriptionText == "test description"
        taskList.tasks[0].doneText == "Done!"
    }
}