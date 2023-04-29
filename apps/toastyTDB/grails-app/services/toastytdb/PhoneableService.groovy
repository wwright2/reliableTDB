package toastytdb

import grails.gorm.services.Service

@Service(Phoneable)
interface PhoneableService {

    Phoneable get(Serializable id)

    List<Phoneable> list(Map args)

    Long count()

    void delete(Serializable id)

    Phoneable save(Phoneable phoneable)

}