package toastytdb

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PhoneableServiceSpec extends Specification {

    PhoneableService phoneableService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Phoneable(...).save(flush: true, failOnError: true)
        //new Phoneable(...).save(flush: true, failOnError: true)
        //Phoneable phoneable = new Phoneable(...).save(flush: true, failOnError: true)
        //new Phoneable(...).save(flush: true, failOnError: true)
        //new Phoneable(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //phoneable.id
    }

    void "test get"() {
        setupData()

        expect:
        phoneableService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Phoneable> phoneableList = phoneableService.list(max: 2, offset: 2)

        then:
        phoneableList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        phoneableService.count() == 5
    }

    void "test delete"() {
        Long phoneableId = setupData()

        expect:
        phoneableService.count() == 5

        when:
        phoneableService.delete(phoneableId)
        sessionFactory.currentSession.flush()

        then:
        phoneableService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Phoneable phoneable = new Phoneable()
        phoneableService.save(phoneable)

        then:
        phoneable.id != null
    }
}
