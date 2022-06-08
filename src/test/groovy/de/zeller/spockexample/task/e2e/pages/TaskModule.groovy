package de.zeller.spockexample.task.e2e.pages

import geb.Module

class TaskModule extends Module {
    static content = {
        titleButton { $(".accordion") }
        titleButtonText { $(".accordion").text() }
        descriptionText { $(".description > p").text() }
    }
}
