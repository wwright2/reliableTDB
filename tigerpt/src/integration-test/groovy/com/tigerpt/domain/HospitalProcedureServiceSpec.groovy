package com.tigerpt.domain

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class HospitalProcedureServiceSpec extends Specification {

    HospitalProcedureService hospitalProcedureService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new HospitalProcedure(...).save(flush: true, failOnError: true)
        //new HospitalProcedure(...).save(flush: true, failOnError: true)
        //HospitalProcedure hospitalProcedure = new HospitalProcedure(...).save(flush: true, failOnError: true)
        //new HospitalProcedure(...).save(flush: true, failOnError: true)
        //new HospitalProcedure(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //hospitalProcedure.id
    }

    void "test get"() {
        setupData()

        expect:
        hospitalProcedureService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<HospitalProcedure> hospitalProcedureList = hospitalProcedureService.list(max: 2, offset: 2)

        then:
        hospitalProcedureList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        hospitalProcedureService.count() == 5
    }

    void "test delete"() {
        Long hospitalProcedureId = setupData()

        expect:
        hospitalProcedureService.count() == 5

        when:
        hospitalProcedureService.delete(hospitalProcedureId)
        sessionFactory.currentSession.flush()

        then:
        hospitalProcedureService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        HospitalProcedure hospitalProcedure = new HospitalProcedure()
        hospitalProcedureService.save(hospitalProcedure)

        then:
        hospitalProcedure.id != null
    }
}
