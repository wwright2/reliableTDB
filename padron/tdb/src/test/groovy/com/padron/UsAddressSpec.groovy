package com.padron

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class UsAddressSpec extends Specification implements DomainUnitTest<UsAddress> {

     void "test domain constraints"() {
        when:
        UsAddress domain = new UsAddress()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
