package de.zeller.todoapp.task.examples


import spock.lang.Specification
import spock.lang.Unroll

class StringBuilderSpec extends Specification {

    @Unroll("remove from '#source' the substring begins at #start and up to #end.")
    def "remove the substring"() {
        given:
        def sb = new StringBuilder(source)

        when:
        sb.delete(start, end)

        then:
        sb.toString() == expected

        where:
        source                                       | start | end               || expected
        "It’s really easy to get started with Spock" | 0     | 37                || "Spock"
//        "It’s really easy to get started with Spock" | 0     | 38                || "Spock"
        "It’s really easy to get started with Spock" | 0     | Integer.MAX_VALUE || ""
    }

    def "parse as number"() {
        given:
        def sb = new StringBuilder(source)

        expect:
        sb.isNumber()

        where:
        source << ["2", "3.14", "08"]
    }

    def "replace the characters in a substring with characters in the specified String"() {
        given:
        def sb = new StringBuilder(source)

        when:
        sb.replace(start, end, replacement)

        then:
        sb.toString() == expected

        where:
        [source, start, end, replacement, expected] << readTestdata()
    }

    def readTestdata() {
        [
                ["Groovy will feel very familiar to you.", 37, 38, "!", "Groovy will feel very familiar to you!"],
                ["Groovy will feel very familiar to you.", 0, 6, "Java", "Java will feel very familiar to you."]
        ]
    }
}