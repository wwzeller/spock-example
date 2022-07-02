package de.zeller.spockexample.task

import de.zeller.spockexample.task.repository.TaskRepository
import groovy.transform.TupleConstructor

import java.time.LocalDate

@TupleConstructor
class FixturesDelegate {
    final TaskRepository taskRepository

    void saveTask(String title, String description, LocalDate dueDate) {
        taskRepository.createNewTask(title, description, dueDate)
    }
}
