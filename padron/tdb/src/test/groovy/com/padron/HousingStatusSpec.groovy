package com.padron

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class HousingStatusSpec extends Specification implements DomainUnitTest<HousingStatus> {

     void "test domain constraints"() {
        when:
        HousingStatus domain = new HousingStatus()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
