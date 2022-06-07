package de.zeller.spockexample.task.e2e.pages

import geb.Module

class TaskModule extends Module {
    static content = {
        titleButtonText { $(".accordion").text() }
    }
}
