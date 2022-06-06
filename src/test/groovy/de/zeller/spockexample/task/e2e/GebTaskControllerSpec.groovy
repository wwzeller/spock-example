package de.zeller.spockexample.task.e2e

import de.zeller.spockexample.task.e2e.pages.MainPage

class GebTaskControllerSpec extends BaseGebSpec {

    def "basic test to check if mainpage is loaded"() {
        when:
        to MainPage

        then:
        submitButtonValue == "Erstellen"
    }
}