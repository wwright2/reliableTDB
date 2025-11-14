package com.tigerpt.domain

import grails.gorm.services.Service

@Service(HospitalProcedure)
interface HospitalProcedureService {

    HospitalProcedure get(Serializable id)

    List<HospitalProcedure> list(Map args)

    Long count()

    void delete(Serializable id)

    HospitalProcedure save(HospitalProcedure hospitalProcedure)

}