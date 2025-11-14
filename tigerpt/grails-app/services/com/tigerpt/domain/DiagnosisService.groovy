package com.tigerpt.domain

import grails.gorm.services.Service

@Service(Diagnosis)
interface DiagnosisService {

    Diagnosis get(Serializable id)

    List<Diagnosis> list(Map args)

    Long count()

    void delete(Serializable id)

    Diagnosis save(Diagnosis diagnosis)

}