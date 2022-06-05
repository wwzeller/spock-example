package de.zeller.spockexample.task.unit

import de.zeller.spockexample.task.repository.TaskRepository
import de.zeller.spockexample.task.service.TaskService
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

import static org.hamcrest.Matchers.equalTo

class TaskServiceInvocationSpec extends Specification {
    def taskRepository = Mock(TaskRepository)
    @Subject
    def taskService = new TaskService(taskRepository)

    def "task is saved in repo"() {
        when:
        taskService.createTask("Task title", "Task description")

        then:
        1 * taskRepository.save(_, _)
    }

    def "task with title is null not saved in repo"() {
        when:
        taskService.createTask(null, "Task description")

        then:
        thrown(IllegalArgumentException)
        0 * taskRepository.save(_, _)
    }

    def "capture with mock"() {
        when:
        taskService.createTask("Title", "Description")

        then:
        1 * taskRepository.save("Title", "Description")
    }

    def "using a closure"() {
        when:
        taskService.createTask("Title", "Description")

        then:
        1 * taskRepository.save("Title", {
            it == "Description"
        })
    }

    def "using a hamcrest matcher"() {
        when:
        taskService.createTask("Title", "Description")

        then:
        1 * taskRepository.save("Title", equalTo("Description"))
    }

    def "verifying mock with with"() {
        when:
        taskService.createTask("Title", "Description")

        then:
        with(taskRepository) {
            1 * save(_, _)
        }
    }

    @Unroll
    def "maximum of #a and #b is #c"() {
        expect:
        Math.max(a, b) == c

        where:
        a | b || c
        1 | 3 || 3
        7 | 4 || 7
        0 | 0 || 0
        1 | 3 || 3
    }
}
