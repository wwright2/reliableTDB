package toastytdb

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class IdentificationServiceSpec extends Specification {

    IdentificationService identificationService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Identification(...).save(flush: true, failOnError: true)
        //new Identification(...).save(flush: true, failOnError: true)
        //Identification identification = new Identification(...).save(flush: true, failOnError: true)
        //new Identification(...).save(flush: true, failOnError: true)
        //new Identification(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //identification.id
    }

    void "test get"() {
        setupData()

        expect:
        identificationService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Identification> identificationList = identificationService.list(max: 2, offset: 2)

        then:
        identificationList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        identificationService.count() == 5
    }

    void "test delete"() {
        Long identificationId = setupData()

        expect:
        identificationService.count() == 5

        when:
        identificationService.delete(identificationId)
        sessionFactory.currentSession.flush()

        then:
        identificationService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Identification identification = new Identification()
        identificationService.save(identification)

        then:
        identification.id != null
    }
}
