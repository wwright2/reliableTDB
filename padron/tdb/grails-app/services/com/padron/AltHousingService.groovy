package com.padron

import grails.gorm.services.Service

@Service(AltHousing)
interface AltHousingService {

    AltHousing get(Serializable id)

    List<AltHousing> list(Map args)

    Long count()

    void delete(Serializable id)

    AltHousing save(AltHousing altHousing)

}