package de.zeller.todoapp.task

import de.zeller.todoapp.task.repository.TaskRepository
import groovy.transform.TupleConstructor

import java.time.LocalDate

@TupleConstructor
class FixturesDelegate {
    final TaskRepository taskRepository

    void saveTask(String title, String description, LocalDate dueDate) {
        taskRepository.save(title, description, dueDate)
    }
}
