package com.tigerpt

import grails.gorm.transactions.Transactional

@Transactional
class PatientDataService {

    def search(Map searchParams, Map paginationParams) {
        def criteria = Patient.createCriteria()
        
        def results = criteria.list(max: paginationParams.max ?: 10, offset: paginationParams.offset ?: 0) {
            if (searchParams.homeState) {
                eq('homeState', searchParams.homeState)
            }
            if (searchParams.sex) {
                eq('sex', searchParams.sex)
            }
            if (searchParams.race) {
                eq('race', searchParams.race)
            }
            if (searchParams.ageFrom) {
                ge('age', searchParams.ageFrom as Integer)
            }
            if (searchParams.ageTo) {
                le('age', searchParams.ageTo as Integer)
            }
            
            order('id', 'desc')
        }
        
        return results
    }
    
    def getStatistics() {
        def stats = [:]
        stats.totalPatients = Patient.count()
        stats.patientsByGender = Patient.createCriteria().list {
            projections {
                groupProperty('sex')
                count('id')
            }
        }
        stats.averageAge = Patient.createCriteria().get {
            projections {
                avg('age')
            }
        }
        return stats
    }
}
