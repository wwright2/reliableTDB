package com.padron.injury

import grails.gorm.services.Service

@Service(Injury)
interface InjuryService {

    Injury get(Serializable id)

    List<Injury> list(Map args)

    Long count()

    void delete(Serializable id)

    Injury save(Injury injury)

}