package com.padron

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class PhoneSpec extends Specification implements DomainUnitTest<Phone> {

     void "test domain constraints"() {
        when:
        Phone domain = new Phone()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
