package com.padron

import grails.gorm.services.Service

@Service(State)
interface StateService {

    State get(Serializable id)

    List<State> list(Map args)

    Long count()

    void delete(Serializable id)

    State save(State state)

}