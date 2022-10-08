package de.zeller.todoapp.task.examples

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.commons.lang3.tuple.MutableTriple
import org.spockframework.spring.SpringBean
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class JacksonSpec extends Specification {

    @SpringBean
    private ObjectMapper objectMapper = Spy()

    def "write object as string"() {
        given:
        def triple = new MutableTriple(1, 2, 3)

        expect:
        objectMapper.writeValueAsString(triple) == '{"left":1,"middle":2,"right":3}'
    }
}