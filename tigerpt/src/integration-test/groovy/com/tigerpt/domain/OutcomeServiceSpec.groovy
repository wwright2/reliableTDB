package com.tigerpt.domain

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class OutcomeServiceSpec extends Specification {

    OutcomeService outcomeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Outcome(...).save(flush: true, failOnError: true)
        //new Outcome(...).save(flush: true, failOnError: true)
        //Outcome outcome = new Outcome(...).save(flush: true, failOnError: true)
        //new Outcome(...).save(flush: true, failOnError: true)
        //new Outcome(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //outcome.id
    }

    void "test get"() {
        setupData()

        expect:
        outcomeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Outcome> outcomeList = outcomeService.list(max: 2, offset: 2)

        then:
        outcomeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        outcomeService.count() == 5
    }

    void "test delete"() {
        Long outcomeId = setupData()

        expect:
        outcomeService.count() == 5

        when:
        outcomeService.delete(outcomeId)
        sessionFactory.currentSession.flush()

        then:
        outcomeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Outcome outcome = new Outcome()
        outcomeService.save(outcome)

        then:
        outcome.id != null
    }
}
