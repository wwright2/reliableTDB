package com.padron

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SexTypeServiceSpec extends Specification {

    SexTypeService sexTypeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SexType(...).save(flush: true, failOnError: true)
        //new SexType(...).save(flush: true, failOnError: true)
        //SexType sexType = new SexType(...).save(flush: true, failOnError: true)
        //new SexType(...).save(flush: true, failOnError: true)
        //new SexType(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sexType.id
    }

    void "test get"() {
        setupData()

        expect:
        sexTypeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SexType> sexTypeList = sexTypeService.list(max: 2, offset: 2)

        then:
        sexTypeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sexTypeService.count() == 5
    }

    void "test delete"() {
        Long sexTypeId = setupData()

        expect:
        sexTypeService.count() == 5

        when:
        sexTypeService.delete(sexTypeId)
        sessionFactory.currentSession.flush()

        then:
        sexTypeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SexType sexType = new SexType()
        sexTypeService.save(sexType)

        then:
        sexType.id != null
    }
}
