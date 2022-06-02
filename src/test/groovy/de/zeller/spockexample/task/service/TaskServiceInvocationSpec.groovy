package de.zeller.spockexample.task.service

import de.zeller.spockexample.task.repository.TaskRepository
import spock.lang.Specification
import spock.lang.Subject

class TaskServiceInvocationSpec extends Specification {
    def taskRepository = Mock(TaskRepository)
    @Subject taskService = new TaskService(taskRepository)

    def "task is saved in repo"() {
        when:
        taskService.createTask("Task title", "Task description")

        then:
        1 * taskRepository.save(_,_)
    }

    def "task with title is null noti saved in repo"() {
        when:
        taskService.createTask(null, "Task description")

        then:
        thrown(IllegalArgumentException)
        0 * taskRepository.save(_,_)
    }
}
