package com.padron

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class CountySpec extends Specification implements DomainUnitTest<County> {

     void "test domain constraints"() {
        when:
        County domain = new County()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
