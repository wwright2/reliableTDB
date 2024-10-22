package com.padron

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class UsPhoneSpec extends Specification implements DomainUnitTest<UsPhone> {

     void "test domain constraints"() {
        when:
        UsPhone domain = new UsPhone()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
