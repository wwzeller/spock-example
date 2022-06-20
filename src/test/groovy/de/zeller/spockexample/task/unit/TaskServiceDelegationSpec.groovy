package de.zeller.spockexample.task.unit

import de.zeller.spockexample.task.FixturesDelegate
import de.zeller.spockexample.task.repository.TaskRepository
import de.zeller.spockexample.task.service.TaskService
import spock.lang.Specification
import spock.lang.Subject

import java.time.LocalDate

class TaskServiceDelegationSpec extends Specification {
    def static final taskRepository = new TaskRepository()
    @Subject
    def static final taskService = new TaskService(taskRepository)

    @Delegate
    FixturesDelegate fixturesDelegate

    void setup() {
        fixturesDelegate = new FixturesDelegate(taskRepository)
    }

    def "task is saved in repo"() {
        when:
        saveTask("Task title", "Task description", LocalDate.now())

        then:
        taskService.getAll().size() == 1
    }
}
