package de.zeller.todoapp.task.unit

import de.zeller.todoapp.task.repository.TaskRepository
import spock.lang.Shared
import spock.lang.Specification

import java.time.LocalDate

class TaskRepositoryFinderMethodSpec extends Specification {
    @Shared
    def taskRepository = new TaskRepository()

    void setupSpec() {
        taskRepository.save("Aufgabe 1", "Das ist eine Testaufgabe", LocalDate.now())
        taskRepository.save("Aufgabe 2", "Das ist die zweite Testaufgabe", LocalDate.now())
    }

    void cleanupSpec() {
        taskRepository.deleteAll()
    }

    def "TaskRepo hat zwei Tasks"() {
        when:
        def result = taskRepository.findAll()

        then:
        result.size() == 2
    }

    def "ein Test mit einer Hilfsmethode"() {
        expect:
        verifyTaskCount(2)
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

    def verifyTaskCount(int count){
         taskRepository.findAll().size() == count
    }
}