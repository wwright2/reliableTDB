package com.tigerpt.domain

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes = 'id')
@ToString(includes = 'id,injuryIncidentDate,icd10PrimaryExternalCause', includeNames = true, includePackage = false)
class Injury {
    
    Patient patient
    
    // Injury Information
    Date injuryIncidentDate
    Date injuryIncidentTime
    Boolean workRelated
    String occupationalIndustry
    String occupation
    String icd10PrimaryExternalCause
    String icd10PlaceOfOccurrence
    String icd10AdditionalExternalCause
    String incidentLocationZipCode
    String incidentCountry
    String incidentState
    String incidentCounty
    String incidentCity
    String protectiveDevices
    String childSpecificRestraint
    String airbagDeployment
    
    // Pre-hospital Information
    String transportMode
    String otherTransportMode
    String emsPatientCareReportUuid
    Boolean interFacilityTransfer
    Boolean preHospitalCardiacArrest
    
    // Emergency Department Information
    String highestActivation
    Date traumaSurgeonArrivalDate
    Date traumaSurgeonArrivalTime
    Date edHospitalArrivalDate
    Date edHospitalArrivalTime
    Integer initialEdSystolicBP
    Integer initialEdPulseRate
    BigDecimal initialEdTemperature
    Integer initialEdRespiratoryRate
    String initialEdRespiratoryAssistance
    Integer initialEdOxygenSaturation
    String initialEdSupplementalOxygen
    Integer initialEdGcsEyes
    Integer initialEdGcsVerbal
    Integer initialEdGcsMotor
    Integer initialEdGcsTotal
    String initialEdGcsAssessmentQualifiers
    Integer initialEdGcs40Eyes
    Integer initialEdGcs40Verbal
    Integer initialEdGcs40Motor
    BigDecimal initialEdHeight
    BigDecimal initialEdWeight
    String drugScreen
    String alcoholScreen
    BigDecimal alcoholScreenResults
    String edDischargeDisposition
    Date edDischargeDate
    Date edDischargeTime
    String primaryTraumaServiceType
    
    static belongsTo = [patient: Patient]
    
    static hasMany = [diagnoses: Diagnosis]
    
    static constraints = {
        injuryIncidentDate nullable: true
        injuryIncidentTime nullable: true
        workRelated nullable: true
        occupationalIndustry nullable: true, maxSize: 200
        occupation nullable: true, maxSize: 200
        icd10PrimaryExternalCause nullable: true, maxSize: 20
        icd10PlaceOfOccurrence nullable: true, maxSize: 20
        icd10AdditionalExternalCause nullable: true, maxSize: 20
        incidentLocationZipCode nullable: true, maxSize: 20
        incidentCountry nullable: true, maxSize: 50
        incidentState nullable: true, maxSize: 50
        incidentCounty nullable: true, maxSize: 100
        incidentCity nullable: true, maxSize: 100
        protectiveDevices nullable: true, maxSize: 200
        childSpecificRestraint nullable: true, maxSize: 200
        airbagDeployment nullable: true, maxSize: 50
        transportMode nullable: true, maxSize: 100
        otherTransportMode nullable: true, maxSize: 200
        emsPatientCareReportUuid nullable: true, maxSize: 100
        interFacilityTransfer nullable: true
        preHospitalCardiacArrest nullable: true
        highestActivation nullable: true, maxSize: 50
        traumaSurgeonArrivalDate nullable: true
        traumaSurgeonArrivalTime nullable: true
        edHospitalArrivalDate nullable: true
        edHospitalArrivalTime nullable: true
        initialEdSystolicBP nullable: true
        initialEdPulseRate nullable: true
        initialEdTemperature nullable: true, scale: 2
        initialEdRespiratoryRate nullable: true
        initialEdRespiratoryAssistance nullable: true, maxSize: 100
        initialEdOxygenSaturation nullable: true
        initialEdSupplementalOxygen nullable: true, maxSize: 100
        initialEdGcsEyes nullable: true
        initialEdGcsVerbal nullable: true
        initialEdGcsMotor nullable: true
        initialEdGcsTotal nullable: true
        initialEdGcsAssessmentQualifiers nullable: true, maxSize: 200
        initialEdGcs40Eyes nullable: true
        initialEdGcs40Verbal nullable: true
        initialEdGcs40Motor nullable: true
        initialEdHeight nullable: true, scale: 2
        initialEdWeight nullable: true, scale: 2
        drugScreen nullable: true, maxSize: 100
        alcoholScreen nullable: true, maxSize: 100
        alcoholScreenResults nullable: true, scale: 3
        edDischargeDisposition nullable: true, maxSize: 100
        edDischargeDate nullable: true
        edDischargeTime nullable: true
        primaryTraumaServiceType nullable: true, maxSize: 100
    }
    
    static mapping = {
        table 'injuries'
        version false
        diagnoses cascade: 'all-delete-orphan'
    }
}
