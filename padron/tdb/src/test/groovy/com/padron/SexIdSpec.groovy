package com.padron

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class SexIdSpec extends Specification implements DomainUnitTest<SexId> {

     void "test domain constraints"() {
        when:
        SexId domain = new SexId()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
