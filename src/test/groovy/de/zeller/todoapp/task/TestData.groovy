package de.zeller.todoapp.task

import de.zeller.todoapp.task.service.Task

import java.time.LocalDate

class TestData {
    static def task(Integer id) {
        new Task(id, "Testaufgabe", "Eine Beschreibung",
                false, LocalDate.now())
    }
}
