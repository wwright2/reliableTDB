package com.tigerpt.controller

import com.tigerpt.domain.Patient
import com.tigerpt.domain.Injury
import com.tigerpt.domain.Diagnosis
import com.tigerpt.domain.HospitalProcedure
import com.tigerpt.domain.HospitalEvent
import com.tigerpt.domain.PreExistingCondition
import com.tigerpt.domain.Outcome

class HomeController {

    def index() {
        // Get counts for all domains
        def patientCount = Patient.count()
        def injuryCount = Injury.count()
        def diagnosisCount = Diagnosis.count()
        def procedureCount = HospitalProcedure.count()
        def eventCount = HospitalEvent.count()
        def conditionCount = PreExistingCondition.count()
        def outcomeCount = Outcome.count()

        // Get recent records
        def recentPatients = Patient.list(max: 5, sort: 'id', order: 'desc')
        def recentInjuries = Injury.list(max: 5, sort: 'id', order: 'desc')

        [
                patientCount: patientCount,
                injuryCount: injuryCount,
                diagnosisCount: diagnosisCount,
                procedureCount: procedureCount,
                eventCount: eventCount,
                conditionCount: conditionCount,
                outcomeCount: outcomeCount,
                recentPatients: recentPatients,
                recentInjuries: recentInjuries
        ]
    }
}