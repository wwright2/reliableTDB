package com.vogella.grails.guestbook

import grails.gorm.services.Service

@Service(Telephone)
interface TelephoneService {

    Telephone get(Serializable id)

    List<Telephone> list(Map args)

    Long count()

    void delete(Serializable id)

    Telephone save(Telephone phone)

}