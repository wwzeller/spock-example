package de.zeller.spockexample.task

class GebTaskControllerSpec extends BaseGebSpec {

    def "Name"() {
        when:
        go "/"

        then:
        waitFor {
            title == "To-Do App"
        }
        title.startsWithAny("To-Do App")
    }
}