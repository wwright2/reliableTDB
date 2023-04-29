package toastytdb

import grails.gorm.services.Service

@Service(CaseProcedure)
interface CaseProcedureService {

    CaseProcedure get(Serializable id)

    List<CaseProcedure> list(Map args)

    Long count()

    void delete(Serializable id)

    CaseProcedure save(CaseProcedure caseProcedure)

}