package com.tigerpt.domain

import grails.gorm.services.Service

@Service(PreExistingCondition)
interface PreExistingConditionService {

    PreExistingCondition get(Serializable id)

    List<PreExistingCondition> list(Map args)

    Long count()

    void delete(Serializable id)

    PreExistingCondition save(PreExistingCondition preExistingCondition)

}