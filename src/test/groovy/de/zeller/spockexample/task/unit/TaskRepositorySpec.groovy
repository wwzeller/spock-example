package de.zeller.spockexample.task.unit

import de.zeller.spockexample.task.repository.TaskRepository
import spock.lang.Specification

import java.time.LocalDate

class TaskRepositorySpec extends Specification {
    def taskRepository = new TaskRepository()

    //  assertion by using every
    def "all tasks get the same status when created"() {
        given:
        def now = LocalDate.now()

        and:
        taskRepository.createNewTask("Task Nr.1", "Task 1 description", now)
        taskRepository.createNewTask("Task Nr.2", "Task 2 description", now)

        expect:
        taskRepository.findAll().size() == 2
        taskRepository.findAll().dueDate.every {
            it == now
        }
    }

    // assertion by using spread operator
    def "title is set correctly"() {
        given:
        taskRepository.createNewTask("Task Nr.1", "Task 1 description", LocalDate.now())
        taskRepository.createNewTask("Task Nr.2", "Task 2 description", LocalDate.now())

        expect:
        taskRepository.findAll()*.title == ["Task Nr.1", "Task Nr.2"]

    }

    def "description is set correctly"() {
        given:
        taskRepository.createNewTask("Task Nr.1", "Task 1 description", LocalDate.now())
        taskRepository.createNewTask("Task Nr.2", "Task 2 description", LocalDate.now())

        expect:
        taskRepository.findAll()*.description == ["Task 1 description", "Task 2 description"]
    }

    def "ids will be set correctly"() {
        given:
        taskRepository.createNewTask("Task Nr.1", "Task 1 description", LocalDate.now())
        taskRepository.createNewTask("Task Nr.2", "Task 2 description", LocalDate.now())

        expect:
        taskRepository.findAll()*.id == [1, 2]
    }

    def "task not found"() {
        expect:
        taskRepository.findById(1).isEmpty()
    }

    def "find existing task"() {
        given:
        taskRepository.createNewTask("Task Nr.1", "Task 1 description", LocalDate.now())

        expect:
        taskRepository.findById(1).isPresent()
    }

    def "delete existing task"() {
        given:
        taskRepository.createNewTask("Task Nr.1", "Task 1 description", LocalDate.now())

        expect:
        taskRepository.findById(1).isPresent()

        when:
        taskRepository.delete(1)

        then:
        taskRepository.findById(1).isEmpty()
    }

    def "delete no existing task"() {
        expect:
        taskRepository.findAll().size() == 0

        when:
        taskRepository.delete(1)

        then:
        noExceptionThrown()
    }
}