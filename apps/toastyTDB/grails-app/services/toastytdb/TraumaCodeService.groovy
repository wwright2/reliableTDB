package toastytdb

import grails.gorm.services.Service

@Service(TraumaCode)
interface TraumaCodeService {

    TraumaCode get(Serializable id)

    List<TraumaCode> list(Map args)

    Long count()

    void delete(Serializable id)

    TraumaCode save(TraumaCode traumaCode)

}