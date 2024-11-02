package com.padron

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SexIdServiceSpec extends Specification {

    SexIdService sexIdService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SexId(...).save(flush: true, failOnError: true)
        //new SexId(...).save(flush: true, failOnError: true)
        //SexId sexId = new SexId(...).save(flush: true, failOnError: true)
        //new SexId(...).save(flush: true, failOnError: true)
        //new SexId(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sexId.id
    }

    void "test get"() {
        setupData()

        expect:
        sexIdService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SexId> sexIdList = sexIdService.list(max: 2, offset: 2)

        then:
        sexIdList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sexIdService.count() == 5
    }

    void "test delete"() {
        Long sexIdId = setupData()

        expect:
        sexIdService.count() == 5

        when:
        sexIdService.delete(sexIdId)
        sessionFactory.currentSession.flush()

        then:
        sexIdService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SexId sexId = new SexId()
        sexIdService.save(sexId)

        then:
        sexId.id != null
    }
}
