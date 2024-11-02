package com.padron

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class AltHousingSpec extends Specification implements DomainUnitTest<AltHousing> {

     void "test domain constraints"() {
        when:
        AltHousing domain = new AltHousing()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
