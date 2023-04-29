package toastytdb

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CaseProcedureServiceSpec extends Specification {

    CaseProcedureService caseProcedureService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new CaseProcedure(...).save(flush: true, failOnError: true)
        //new CaseProcedure(...).save(flush: true, failOnError: true)
        //CaseProcedure caseProcedure = new CaseProcedure(...).save(flush: true, failOnError: true)
        //new CaseProcedure(...).save(flush: true, failOnError: true)
        //new CaseProcedure(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //caseProcedure.id
    }

    void "test get"() {
        setupData()

        expect:
        caseProcedureService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<CaseProcedure> caseProcedureList = caseProcedureService.list(max: 2, offset: 2)

        then:
        caseProcedureList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        caseProcedureService.count() == 5
    }

    void "test delete"() {
        Long caseProcedureId = setupData()

        expect:
        caseProcedureService.count() == 5

        when:
        caseProcedureService.delete(caseProcedureId)
        sessionFactory.currentSession.flush()

        then:
        caseProcedureService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        CaseProcedure caseProcedure = new CaseProcedure()
        caseProcedureService.save(caseProcedure)

        then:
        caseProcedure.id != null
    }
}
