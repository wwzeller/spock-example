package de.zeller.spockexample.task.unit

import de.zeller.spockexample.task.repository.TaskRepository
import spock.lang.Shared
import spock.lang.Specification

import java.time.LocalDate

class TaskRepositoryFinderMethodSpec extends Specification {
    @Shared
    def taskRepository = new TaskRepository()

    void setupSpec() {
        taskRepository.createNewTask("Aufgabe 1", "Das ist eine Testaufgabe", LocalDate.now())
        taskRepository.createNewTask("Aufgabe 2", "Das ist die zweite Testaufgabe", LocalDate.now())
    }

    void cleanupSpec() {
        taskRepository.deleteAll()
    }

    def "das TaskRepo hat zwei Tasks"() {
        when:
        def result = taskRepository.findAll()

        then:
        result.size() == 2
    }

    def "Task bei ID finden"() {
        when:
        def result = taskRepository.findById(2)

        then:
        result.isPresent()
    }

    def "Task existiert nicht"() {
        when:
        def result = taskRepository.findById(3)

        then:
        !result.isPresent()
    }
}