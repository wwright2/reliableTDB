package com.tigerpt.domain

import grails.gorm.services.Service

@Service(HospitalEvent)
interface HospitalEventService {

    HospitalEvent get(Serializable id)

    List<HospitalEvent> list(Map args)

    Long count()

    void delete(Serializable id)

    HospitalEvent save(HospitalEvent hospitalEvent)

}