package com.padron

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class CountrycodeSpec extends Specification implements DomainUnitTest<Countrycode> {

     void "test domain constraints"() {
        when:
        Countrycode domain = new Countrycode()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
