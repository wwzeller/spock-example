package de.zeller.spockexample.task

import spock.lang.Specification

class TaskServiceImplSpec extends Specification {
    def taskService = new TaskServiceImpl()

    //  assertion by using every
    def "all tasks get the same status when created"() {
        given:
        taskService.addTask("Task Nr.1", "Task 1 description")
        taskService.addTask("Task Nr.2", "Task 2 description")

        expect:
        taskService.getAll().size() == 2
        taskService.getAll().status.every {
            it == Status.NOT_ASSIGNED
        }
    }

    // assertion by using spread operator
    def "title is set correctly"() {
        given:
        taskService.addTask("Task Nr.1", "Task 1 description")
        taskService.addTask("Task Nr.2", "Task 2 description")

        expect:
        taskService.getAll()*.title == ["Task Nr.1", "Task Nr.2"]

    }

    def "description is set correctly"() {
        given:
        taskService.addTask("Task Nr.1", "Task 1 description")
        taskService.addTask("Task Nr.2", "Task 2 description")

        expect:
        taskService.getAll()*.description == ["Task 1 description", "Task 2 description"]
    }

    def "ids will be set correctly"() {
        given:
        taskService.addTask("Task Nr.1", "Task 1 description")
        taskService.addTask("Task Nr.2", "Task 2 description")

        expect:
        taskService.getAll()*.id == [1, 2]
    }
}
