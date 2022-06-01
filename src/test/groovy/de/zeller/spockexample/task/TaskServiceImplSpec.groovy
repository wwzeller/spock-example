package de.zeller.spockexample.task

import spock.lang.Specification

class TaskServiceImplSpec extends Specification {
    def taskService = new TaskServiceImpl()

    def "all tasks get the same status when created"() {
        given:
        taskService.addTask("Task Nr.1", "Task 1 description")
        taskService.addTask("Test Nr.2", "Test 2 description")

        expect: "assertion by using every"
        taskService.getAll().size() == 2
        taskService.getAll().status.every {
            it == Status.NOT_ASSIGNED
        }
    }
}
