package de.zeller.spockexample.task.e2e

import de.zeller.spockexample.task.e2e.pages.MainPage

class GebTaskControllerSpec extends BaseGebSpec {

    def "basic test to check if mainpage is loaded"() {
        when:
        to MainPage

        then:
        title == "To-Do App"
    }

    def "create first task"() {
        when:
        to MainPage

        and:
        createTask("Test title 1", "test description")

        then:
        taskList.tasks[0].titleButtonText == "1 - Test title 1"
        taskList.tasks[0].dueDate.text() == ""
    }

    def "create first task and click on title"() {
        when:
        to MainPage

        and:
        createTask("Test title 1", "test description")
        taskList.tasks[0].titleButton.click()

        then:
        taskList.tasks[0].titleButtonText == "1 - Test title 1"
        taskList.tasks[0].descriptionText == "test description"
    }
}