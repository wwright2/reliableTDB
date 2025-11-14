package com.tigerpt.domain

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DiagnosisServiceSpec extends Specification {

    DiagnosisService diagnosisService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Diagnosis(...).save(flush: true, failOnError: true)
        //new Diagnosis(...).save(flush: true, failOnError: true)
        //Diagnosis diagnosis = new Diagnosis(...).save(flush: true, failOnError: true)
        //new Diagnosis(...).save(flush: true, failOnError: true)
        //new Diagnosis(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //diagnosis.id
    }

    void "test get"() {
        setupData()

        expect:
        diagnosisService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Diagnosis> diagnosisList = diagnosisService.list(max: 2, offset: 2)

        then:
        diagnosisList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        diagnosisService.count() == 5
    }

    void "test delete"() {
        Long diagnosisId = setupData()

        expect:
        diagnosisService.count() == 5

        when:
        diagnosisService.delete(diagnosisId)
        sessionFactory.currentSession.flush()

        then:
        diagnosisService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Diagnosis diagnosis = new Diagnosis()
        diagnosisService.save(diagnosis)

        then:
        diagnosis.id != null
    }
}
