package de.zeller.todoapp.task.e2e

import de.zeller.todoapp.task.e2e.pages.MainPage
import geb.spock.GebReportingSpec
import org.springframework.boot.test.context.SpringBootTest

import java.time.LocalDate

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class TaskControllerSpec extends GebReportingSpec {
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
}