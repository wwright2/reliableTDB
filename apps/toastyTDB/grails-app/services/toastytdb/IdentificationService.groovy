package toastytdb

import grails.gorm.services.Service

@Service(Identification)
interface IdentificationService {

    Identification get(Serializable id)

    List<Identification> list(Map args)

    Long count()

    void delete(Serializable id)

    Identification save(Identification identification)

}