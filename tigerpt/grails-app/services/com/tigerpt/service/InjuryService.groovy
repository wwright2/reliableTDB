package com.tigerpt.service

import com.tigerpt.domain.Injury
import grails.gorm.services.Service

@Service(Injury)
interface InjuryService {

    Injury get(Serializable id)

    List<Injury> list(Map args)

    Long count()

    Injury delete(Serializable id)

    Injury save(Injury injury)
    
}
