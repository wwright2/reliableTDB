package com.tigerpt.domain

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class HospitalEventServiceSpec extends Specification {

    HospitalEventService hospitalEventService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new HospitalEvent(...).save(flush: true, failOnError: true)
        //new HospitalEvent(...).save(flush: true, failOnError: true)
        //HospitalEvent hospitalEvent = new HospitalEvent(...).save(flush: true, failOnError: true)
        //new HospitalEvent(...).save(flush: true, failOnError: true)
        //new HospitalEvent(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //hospitalEvent.id
    }

    void "test get"() {
        setupData()

        expect:
        hospitalEventService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<HospitalEvent> hospitalEventList = hospitalEventService.list(max: 2, offset: 2)

        then:
        hospitalEventList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        hospitalEventService.count() == 5
    }

    void "test delete"() {
        Long hospitalEventId = setupData()

        expect:
        hospitalEventService.count() == 5

        when:
        hospitalEventService.delete(hospitalEventId)
        sessionFactory.currentSession.flush()

        then:
        hospitalEventService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        HospitalEvent hospitalEvent = new HospitalEvent()
        hospitalEventService.save(hospitalEvent)

        then:
        hospitalEvent.id != null
    }
}
