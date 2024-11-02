package com.padron

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AltHousingServiceSpec extends Specification {

    AltHousingService altHousingService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new AltHousing(...).save(flush: true, failOnError: true)
        //new AltHousing(...).save(flush: true, failOnError: true)
        //AltHousing altHousing = new AltHousing(...).save(flush: true, failOnError: true)
        //new AltHousing(...).save(flush: true, failOnError: true)
        //new AltHousing(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //altHousing.id
    }

    void "test get"() {
        setupData()

        expect:
        altHousingService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<AltHousing> altHousingList = altHousingService.list(max: 2, offset: 2)

        then:
        altHousingList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        altHousingService.count() == 5
    }

    void "test delete"() {
        Long altHousingId = setupData()

        expect:
        altHousingService.count() == 5

        when:
        altHousingService.delete(altHousingId)
        sessionFactory.currentSession.flush()

        then:
        altHousingService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        AltHousing altHousing = new AltHousing()
        altHousingService.save(altHousing)

        then:
        altHousing.id != null
    }
}
