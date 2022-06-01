package de.zeller.spockexample.task

import de.zeller.spockexample.task.repository.TaskRepository
import de.zeller.spockexample.task.service.Status
import spock.lang.Specification

class TaskRepositorySpec extends Specification {
    def taskRepository = new TaskRepository()

    //  assertion by using every
    def "all tasks get the same status when created"() {
        given:
        taskRepository.save("Task Nr.1", "Task 1 description")
        taskRepository.save("Task Nr.2", "Task 2 description")

        expect:
        taskRepository.findAll().size() == 2
        taskRepository.findAll().status.every {
            it == Status.NOT_ASSIGNED
        }
    }

    // assertion by using spread operator
    def "title is set correctly"() {
        given:
        taskRepository.save("Task Nr.1", "Task 1 description")
        taskRepository.save("Task Nr.2", "Task 2 description")

        expect:
        taskRepository.findAll()*.title == ["Task Nr.1", "Task Nr.2"]

    }

    def "description is set correctly"() {
        given:
        taskRepository.save("Task Nr.1", "Task 1 description")
        taskRepository.save("Task Nr.2", "Task 2 description")

        expect:
        taskRepository.findAll()*.description == ["Task 1 description", "Task 2 description"]
    }

    def "ids will be set correctly"() {
        given:
        taskRepository.save("Task Nr.1", "Task 1 description")
        taskRepository.save("Task Nr.2", "Task 2 description")

        expect:
        taskRepository.findAll()*.id == [1, 2]
    }

    def "task not found"() {
        expect:
        taskRepository.findById(1).isEmpty()
    }

    def "find existing task"() {
        given:
        taskRepository.save("Task Nr.1", "Task 1 description")

        expect:
        taskRepository.findById(1).isPresent()
    }

    def "delete existing task"(){
        given:
        taskRepository.save("Task Nr.1", "Task 1 description")

        expect:
        taskRepository.findById(1).isPresent()

        when:
        taskRepository.delete(1)

        then:
        taskRepository.findById(1).isEmpty()
    }

    def "delete no existing task"(){
        expect:
        taskRepository.findAll().size() == 0

        when:
        taskRepository.delete(1)

        then:
        noExceptionThrown()
    }
}