package toastytdb

import grails.gorm.services.Service

@Service(TraumaAdmission)
interface TraumaAdmissionService {

    TraumaAdmission get(Serializable id)

    List<TraumaAdmission> list(Map args)

    Long count()

    void delete(Serializable id)

    TraumaAdmission save(TraumaAdmission traumaAdmission)

}