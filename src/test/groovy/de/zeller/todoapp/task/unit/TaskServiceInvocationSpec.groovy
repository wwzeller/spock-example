package de.zeller.todoapp.task.unit

import de.zeller.todoapp.task.repository.TaskRepository
import de.zeller.todoapp.task.service.Task
import de.zeller.todoapp.task.service.TaskService
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

import java.time.LocalDate

import static org.hamcrest.Matchers.equalTo

class TaskServiceInvocationSpec extends Specification {
    def taskRepository = Mock(TaskRepository)
    @Subject
    def taskService = new TaskService(taskRepository)

    def "die Methode getCompletedTasks liefert nur abgeschlossene Tasks"() {
        given:
        def taskA = new Task(1, "TitelA", "BeschreibungA", false, LocalDate.now())
        def taskB = new Task(2, "TitelB", "BeschreibungB", true, LocalDate.now())

        and:
        taskRepository.findAll() >> [taskA, taskB]

        when:
        def result = taskService.getCompletedTasks()

        then:
        result.size() == 1
        result.get(0).id == taskB.id
    }

    def "Aufgabenname darf nicht null sein"() {
        when:
        taskService.createTask(null, "Beschreibung", LocalDate.now())

        then:
        thrown(IllegalArgumentException)
    }

    def "ein Task wird in dem Repository gespeichert"() {
        when:
        taskService.createTask("Titel der Aufgabe", "Aufgabenbeschreibung...", LocalDate.now())

        then: "die Methode 'createNewTask' wird 1x aufgerufen"
        1 * taskRepository.save(_, _, _)
    }

    def "task with title is null not saved in repo"() {
        when:
        taskService.createTask(null, "Task description", LocalDate.now())

        then:
        thrown(IllegalArgumentException)
        0 * taskRepository.save(_, _, _)
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

    def "test mit data pipe"() {
        when:
        taskService.createTask("TestTitel", description, LocalDate.now())

        then:
        noExceptionThrown()

        where:
        description << [null, "Beschreibung", ""]
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
