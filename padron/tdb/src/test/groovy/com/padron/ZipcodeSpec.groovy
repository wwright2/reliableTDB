package com.padron

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ZipcodeSpec extends Specification implements DomainUnitTest<Zipcode> {

     void "test domain constraints"() {
        when:
        Zipcode domain = new Zipcode()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
