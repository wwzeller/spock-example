package de.zeller.todoapp.task.e2e


import de.zeller.todoapp.task.repository.TaskRepository
import geb.spock.GebReportingSpec
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class BaseGebSpec extends GebReportingSpec {

    @Autowired
    private TaskRepository taskRepository

    void setup() {
        taskRepository.deleteAll()
    }
}