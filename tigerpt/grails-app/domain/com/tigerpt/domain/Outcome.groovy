package com.tigerpt.domain

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes = 'id')
@ToString(includes = 'id,patient,hospitalDischargeDisposition', includeNames = true, includePackage = false)
class Outcome {
    
    Patient patient
    
    // Outcome Information
    Integer totalIcuLengthOfStay
    Integer totalVentilatorDays
    String hospitalDischargeDisposition
    Date hospitalDischargeDate
    Date hospitalDischargeTime
    
    // Financial Information
    String primaryMethodOfPayment
    
    // TQIP Measures
    Integer highestGcsTotal
    Integer highestGcsMotor
    String gcsAssessmentQualifier
    Integer highestGcs40Motor
    String initialEdPupillaryResponse
    Boolean midlineShift
    Boolean cerebralMonitor
    Date cerebralMonitorDate
    Date cerebralMonitorTime
    String venousThromboembolismProphylaxisType
    Date venousThromboembolismProphylaxisDate
    Date venousThromboembolismProphylaxisTime
    Integer packedRedBloodCells
    Integer wholeBlood
    Integer plasma
    Integer platelets
    Integer cryoprecipitate
    Boolean angiography
    String embolizationSite
    Date angiographyDate
    Date angiographyTime
    String surgeryForHemorrhageControlType
    Date surgeryForHemorrhageControlDate
    Date surgeryForHemorrhageControlTime
    Boolean withdrawalOfLifeSupportingTreatment
    Date withdrawalOfLifeSupportingTreatmentDate
    Date withdrawalOfLifeSupportingTreatmentTime
    Boolean antibioticTherapy
    Date antibioticTherapyDate
    Date antibioticTherapyTime
    
    static belongsTo = [patient: Patient]
    
    static constraints = {
        totalIcuLengthOfStay nullable: true
        totalVentilatorDays nullable: true
        hospitalDischargeDisposition nullable: true, maxSize: 100
        hospitalDischargeDate nullable: true
        hospitalDischargeTime nullable: true
        primaryMethodOfPayment nullable: true, maxSize: 100
        highestGcsTotal nullable: true
        highestGcsMotor nullable: true
        gcsAssessmentQualifier nullable: true, maxSize: 200
        highestGcs40Motor nullable: true
        initialEdPupillaryResponse nullable: true, maxSize: 100
        midlineShift nullable: true
        cerebralMonitor nullable: true
        cerebralMonitorDate nullable: true
        cerebralMonitorTime nullable: true
        venousThromboembolismProphylaxisType nullable: true, maxSize: 100
        venousThromboembolismProphylaxisDate nullable: true
        venousThromboembolismProphylaxisTime nullable: true
        packedRedBloodCells nullable: true
        wholeBlood nullable: true
        plasma nullable: true
        platelets nullable: true
        cryoprecipitate nullable: true
        angiography nullable: true
        embolizationSite nullable: true, maxSize: 200
        angiographyDate nullable: true
        angiographyTime nullable: true
        surgeryForHemorrhageControlType nullable: true, maxSize: 200
        surgeryForHemorrhageControlDate nullable: true
        surgeryForHemorrhageControlTime nullable: true
        withdrawalOfLifeSupportingTreatment nullable: true
        withdrawalOfLifeSupportingTreatmentDate nullable: true
        withdrawalOfLifeSupportingTreatmentTime nullable: true
        antibioticTherapy nullable: true
        antibioticTherapyDate nullable: true
        antibioticTherapyTime nullable: true
    }
    
    static mapping = {
        table 'outcomes'
        version false
    }
}
