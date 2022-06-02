package de.zeller.spockexample.task.service

import de.zeller.spockexample.task.repository.TaskRepository
import spock.lang.Specification
import spock.lang.Subject

class TaskServiceDelegationSpec extends Specification {
    def taskRepository = new TaskRepository()
    @Subject
    def taskService = new TaskService(taskRepository)

    @Delegate
    FixturesDelegate fixturesDelegate

    void setup() {
        fixturesDelegate = new FixturesDelegate(taskRepository)
    }

    def "task is saved in repo"() {
        when:
        saveTask("Task title", "Task description")

        then:
        taskService.getAll().size() == 1
    }
}
