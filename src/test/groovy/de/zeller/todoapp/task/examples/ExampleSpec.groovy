package de.zeller.todoapp.task.examples


import spock.lang.Ignore
import spock.lang.Specification

class ExampleSpec extends Specification {

    def "zwei plus zwei ist gleich vier"() {
        expect:
        2 + 2 == 4
    }

    @Ignore("Fixture-Methode mit einer HIlfsmethode ohne assert")
    def "drei plus vier ist gleich sieben"() {
        when:
        def result = 3 + 4

        then:
        verify(result)
    }

    def verify(int result) {
        result == 8
    }

    def "string joiner test"() {
        given: "string joiner mit dem Trennzeichen initialisieren"
        StringJoiner sj = new StringJoiner(" ")

        and: "und die Testwerte setzten"
        sj.add("Hello")
        sj.add("World!")

        when: "zu prüfende Methode ausführen"
        def result = sj.toString()

        then: "die Werte sind konkateniert und durch Trennzeichen getrennt"
        result == "Hello World!"
    }
}