package de.zeller.spockexample.user

import spock.lang.Specification

class UserRepositorySpec extends Specification {
    def userRepository = new UserRepository()

    def "user is created with data pipe"() {
        when:
        userRepository.createUser(name)

        and:
        def result = userRepository.getAll().get(0)

        then:
        result.name == name

        where:
        name << ["Petronella", "Max"]
    }

    def "user is created with assignment"() {
        when:
        names.each {
            userRepository.createUser(it)
        }

        and:
        def result = userRepository.getAll()

        then:
        result*.name == names

        where:
        names = ["Petronella", "Max"]
    }
}
