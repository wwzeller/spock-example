package de.zeller.spockexample.task.e2e.pages

import geb.Page

class MainPage extends Page {
    static url = "/"
    static atCheckWaiting = true

    static at = {
        $(".head > h2:nth-child(1)").text() == "To-Do App"
    }

    static content = {
        submitButtonValue { $("#submit_button").value() }
    }
}