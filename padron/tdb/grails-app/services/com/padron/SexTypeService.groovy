package com.padron

import grails.gorm.services.Service

@Service(SexType)
interface SexTypeService {

    SexType get(Serializable id)

    List<SexType> list(Map args)

    Long count()

    void delete(Serializable id)

    SexType save(SexType sexType)

}