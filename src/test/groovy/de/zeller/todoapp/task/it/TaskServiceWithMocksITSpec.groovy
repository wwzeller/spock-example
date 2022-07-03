package de.zeller.todoapp.task.it

import de.zeller.todoapp.task.repository.TaskRepository
import de.zeller.todoapp.task.service.Task
import de.zeller.todoapp.task.service.TaskService
import org.spockframework.spring.SpringSpy
import org.spockframework.spring.StubBeans
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

import java.time.LocalDate

@StubBeans(TaskService)
@SpringBootTest
class TaskServiceWithMocksITSpec extends Specification {

    @SpringSpy
    private TaskRepository taskRepository

    def "ein Task wird ueber taskService im Repo gespeichert"() {
        given:
        def taskA = new Task(1, "TitelA", "BeschreibungA", false, LocalDate.now())

        and:
        taskRepository.save("TitelA", "BeschreibungA", LocalDate.now())

        expect:
        taskRepository.findAll().size() == 1
    }
}
