package com.tigerpt.domain

import grails.gorm.services.Service

@Service(Outcome)
interface OutcomeService {

    Outcome get(Serializable id)

    List<Outcome> list(Map args)

    Long count()

    void delete(Serializable id)

    Outcome save(Outcome outcome)

}