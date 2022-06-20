package de.zeller.spockexample.task.unit

import de.zeller.spockexample.task.repository.TaskRepository
import de.zeller.spockexample.task.service.TaskService
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

import java.time.LocalDate

import static de.zeller.spockexample.task.TestData.task
import static org.hamcrest.Matchers.equalTo

class TaskServiceInvocationSpec extends Specification {
    def taskRepository = Mock(TaskRepository)
    @Subject
    def taskService = new TaskService(taskRepository)

    def "mock"() {
        given:
        taskRepository.findAll() >> [task(1)]

        when:
        def all = taskService.getAll()

        then:
        !all.get(0).isCompleted()
    }

    def "ein Task wird in dem Repository gespeichert"() {
        when: "task service"
        taskService.createTask("Titel der Aufgabe", "Aufgabenbeschreibung...", LocalDate.now())

        then: "die Methode 'save' wird 1x aufgerufen"
        1 * taskRepository.save(_, _, _)
    }

    def "task with title is null not saved in repo"() {
        when:
        taskService.createTask(null, "Task description", LocalDate.now())

        then:
        thrown(IllegalArgumentException)
        0 * taskRepository.save(_, _)
    }

    def "capture with mock"() {
        given:
        def now = LocalDate.now()

        when:
        taskService.createTask("Title", "Description", now)

        then:
        1 * taskRepository.save("Title", "Description", now)
    }

    def "using a closure"() {
        given:
        def now = LocalDate.now()

        when:
        taskService.createTask("Title", "Description", now)

        then:
        1 * taskRepository.save(
                "Title",
                {
                    it == "Description"
                },
                now)
    }

    def "using a hamcrest matcher"() {
        given:
        def now = LocalDate.now()

        when:
        taskService.createTask("Title", "Description", now)

        then:
        1 * taskRepository.save("Title", equalTo("Description"), now)
    }

    def "verifying mock with with"() {
        when:
        taskService.createTask("Title", "Description", LocalDate.now())

        then:
        with(taskRepository) {
            1 * save(_, _, _)
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
