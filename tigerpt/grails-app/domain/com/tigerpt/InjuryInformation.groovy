package com.tigerpt

import java.time.LocalDate
import java.time.LocalTime
import com.tigerpt.domain.Patient

class InjuryInformation {

    LocalDate injuryIncidentDate
    LocalTime injuryIncidentTime
    Boolean workRelated
    String occupationalIndustry
    String occupation
    
    // ICD-10 Codes
    String primaryExternalCauseCode
    String placeOfOccurrenceCode
    String additionalExternalCauseCode
    
    // Incident Location
    String incidentLocationZipPostalCode
    String incidentCountry
    String incidentState
    String incidentCounty
    String incidentCity
    
    // Safety Information
    String protectiveDevices
    String childSpecificRestraint
    String airbagDeployment
    
    static belongsTo = [patient: Patient]
    
    static constraints = {
        injuryIncidentDate nullable: true
        injuryIncidentTime nullable: true
        workRelated nullable: true
        occupationalIndustry nullable: true, maxSize: 255
        occupation nullable: true, maxSize: 255
        primaryExternalCauseCode nullable: true, maxSize: 20
        placeOfOccurrenceCode nullable: true, maxSize: 20
        additionalExternalCauseCode nullable: true, maxSize: 20
        incidentLocationZipPostalCode nullable: true, maxSize: 20
        incidentCountry nullable: true, maxSize: 100
        incidentState nullable: true, maxSize: 100
        incidentCounty nullable: true, maxSize: 100
        incidentCity nullable: true, maxSize: 100
        protectiveDevices nullable: true, maxSize: 255
        childSpecificRestraint nullable: true, maxSize: 255
        airbagDeployment nullable: true, maxSize: 100
    }
    
    static mapping = {
        table 'injury_information'
        version false
    }
    
    String toString() {
        return "Injury on ${injuryIncidentDate}"
    }
}
