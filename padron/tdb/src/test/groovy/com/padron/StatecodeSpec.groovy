package com.padron

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class StatecodeSpec extends Specification implements DomainUnitTest<Statecode> {

     void "test domain constraints"() {
        when:
        Statecode domain = new Statecode()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
