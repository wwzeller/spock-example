package de.zeller.spockexample.task.service

import de.zeller.spockexample.task.repository.TaskRepository
import groovy.transform.TupleConstructor

@TupleConstructor
class FixturesDelegate {
    final TaskRepository taskRepository

    void saveTask(String title, String description){
        taskRepository.save(title, description)
    }
}
