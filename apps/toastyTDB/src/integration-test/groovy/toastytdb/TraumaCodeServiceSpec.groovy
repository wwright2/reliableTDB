package toastytdb

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TraumaCodeServiceSpec extends Specification {

    TraumaCodeService traumaCodeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new TraumaCode(...).save(flush: true, failOnError: true)
        //new TraumaCode(...).save(flush: true, failOnError: true)
        //TraumaCode traumaCode = new TraumaCode(...).save(flush: true, failOnError: true)
        //new TraumaCode(...).save(flush: true, failOnError: true)
        //new TraumaCode(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //traumaCode.id
    }

    void "test get"() {
        setupData()

        expect:
        traumaCodeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<TraumaCode> traumaCodeList = traumaCodeService.list(max: 2, offset: 2)

        then:
        traumaCodeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        traumaCodeService.count() == 5
    }

    void "test delete"() {
        Long traumaCodeId = setupData()

        expect:
        traumaCodeService.count() == 5

        when:
        traumaCodeService.delete(traumaCodeId)
        sessionFactory.currentSession.flush()

        then:
        traumaCodeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        TraumaCode traumaCode = new TraumaCode()
        traumaCodeService.save(traumaCode)

        then:
        traumaCode.id != null
    }
}
