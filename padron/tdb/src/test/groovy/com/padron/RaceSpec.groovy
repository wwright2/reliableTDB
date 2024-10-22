package com.padron

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class RaceSpec extends Specification implements DomainUnitTest<Race> {

     void "test domain constraints"() {
        when:
        Race domain = new Race()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
