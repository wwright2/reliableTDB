package com.tigerpt.domain

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PreExistingConditionServiceSpec extends Specification {

    PreExistingConditionService preExistingConditionService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new PreExistingCondition(...).save(flush: true, failOnError: true)
        //new PreExistingCondition(...).save(flush: true, failOnError: true)
        //PreExistingCondition preExistingCondition = new PreExistingCondition(...).save(flush: true, failOnError: true)
        //new PreExistingCondition(...).save(flush: true, failOnError: true)
        //new PreExistingCondition(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //preExistingCondition.id
    }

    void "test get"() {
        setupData()

        expect:
        preExistingConditionService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<PreExistingCondition> preExistingConditionList = preExistingConditionService.list(max: 2, offset: 2)

        then:
        preExistingConditionList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        preExistingConditionService.count() == 5
    }

    void "test delete"() {
        Long preExistingConditionId = setupData()

        expect:
        preExistingConditionService.count() == 5

        when:
        preExistingConditionService.delete(preExistingConditionId)
        sessionFactory.currentSession.flush()

        then:
        preExistingConditionService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        PreExistingCondition preExistingCondition = new PreExistingCondition()
        preExistingConditionService.save(preExistingCondition)

        then:
        preExistingCondition.id != null
    }
}
