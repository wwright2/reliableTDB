package com.padron

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class HomelessSpec extends Specification implements DomainUnitTest<Homeless> {

     void "test domain constraints"() {
        when:
        Homeless domain = new Homeless()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
