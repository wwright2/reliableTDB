package com.padron

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class StateSpec extends Specification implements DomainUnitTest<State> {

     void "test domain constraints"() {
        when:
        State domain = new State()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
