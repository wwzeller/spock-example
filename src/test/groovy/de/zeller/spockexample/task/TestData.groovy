package de.zeller.spockexample.task

import de.zeller.spockexample.task.service.Task

import java.time.LocalDateTime

class TestData {
    static def task(Integer id) {
        new Task(id, "Testaufgabe", "Eine Beschreibung", false, LocalDateTime.now())
    }
}
