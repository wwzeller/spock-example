package de.zeller.todoapp.task.it

import de.zeller.todoapp.task.repository.TaskRepository
import de.zeller.todoapp.task.service.TaskService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Rollup
import spock.lang.Specification

import java.time.LocalDate

@SpringBootTest
class TaskServiceITSpec extends Specification {
    @Autowired
    private TaskService taskService
    @Autowired
    private TaskRepository taskRepository

    @Rollup
    def "ein Task wird ueber taskService im Repo gespeichert"() {
        given:
        def title = "Neue Aufgabe"
        def description = "Beschreibung"
        def dueDate = LocalDate.now()

        and:
        taskService.createTask(title, description, dueDate)

        when:
        def result = taskRepository.findAll().get(0)

        then:
        verifyAll {
            result.id == 1
            !result.completed
            result.title == title
            result.description == description
            result.dueDate == dueDate
        }
    }
}
