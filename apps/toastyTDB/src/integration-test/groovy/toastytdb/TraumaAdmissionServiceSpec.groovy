package toastytdb

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TraumaAdmissionServiceSpec extends Specification {

    TraumaAdmissionService traumaAdmissionService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new TraumaAdmission(...).save(flush: true, failOnError: true)
        //new TraumaAdmission(...).save(flush: true, failOnError: true)
        //TraumaAdmission traumaAdmission = new TraumaAdmission(...).save(flush: true, failOnError: true)
        //new TraumaAdmission(...).save(flush: true, failOnError: true)
        //new TraumaAdmission(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //traumaAdmission.id
    }

    void "test get"() {
        setupData()

        expect:
        traumaAdmissionService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<TraumaAdmission> traumaAdmissionList = traumaAdmissionService.list(max: 2, offset: 2)

        then:
        traumaAdmissionList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        traumaAdmissionService.count() == 5
    }

    void "test delete"() {
        Long traumaAdmissionId = setupData()

        expect:
        traumaAdmissionService.count() == 5

        when:
        traumaAdmissionService.delete(traumaAdmissionId)
        sessionFactory.currentSession.flush()

        then:
        traumaAdmissionService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        TraumaAdmission traumaAdmission = new TraumaAdmission()
        traumaAdmissionService.save(traumaAdmission)

        then:
        traumaAdmission.id != null
    }
}
