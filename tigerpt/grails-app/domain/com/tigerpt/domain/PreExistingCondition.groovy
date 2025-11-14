package com.tigerpt.domain

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes = 'id')
@ToString(includes = 'id,patient', includeNames = true, includePackage = false)
class PreExistingCondition {
    
    Patient patient
    
    // Pre-existing Conditions (as per NTDS)
    Boolean advanceDirectiveLimitingCare
    Boolean alcoholUseDisorder
    Boolean anticoagulantTherapy
    Boolean attentionDeficitDisorder
    Boolean bipolarDisorder
    Boolean bleedingDisorder
    Boolean cerebralVascularAccident
    Boolean chronicObstructivePulmonaryDisease
    Boolean chronicRenalFailure
    Boolean cirrhosis
    Boolean congenitalAnomalies
    Boolean congestiveHeartFailure
    Boolean currentSmoker
    Boolean currentlyReceivingChemotherapy
    Boolean dementia
    Boolean diabetesMellitus
    Boolean disseminatedCancer
    Boolean functionallyDependentHealthStatus
    Boolean hypertension
    Boolean majorDepressiveDisorder
    Boolean myocardialInfarction
    Boolean otherMentalPersonalityDisorders
    Boolean peripheralArterialDisease
    Boolean postTraumaticStressDisorder
    Boolean pregnancy
    Boolean prematurity
    Boolean schizoaffectiveDisorder
    Boolean schizophrenia
    Boolean steroidUse
    Boolean substanceUseDisorder
    
    static belongsTo = [patient: Patient]
    
    static constraints = {
        advanceDirectiveLimitingCare nullable: true
        alcoholUseDisorder nullable: true
        anticoagulantTherapy nullable: true
        attentionDeficitDisorder nullable: true
        bipolarDisorder nullable: true
        bleedingDisorder nullable: true
        cerebralVascularAccident nullable: true
        chronicObstructivePulmonaryDisease nullable: true
        chronicRenalFailure nullable: true
        cirrhosis nullable: true
        congenitalAnomalies nullable: true
        congestiveHeartFailure nullable: true
        currentSmoker nullable: true
        currentlyReceivingChemotherapy nullable: true
        dementia nullable: true
        diabetesMellitus nullable: true
        disseminatedCancer nullable: true
        functionallyDependentHealthStatus nullable: true
        hypertension nullable: true
        majorDepressiveDisorder nullable: true
        myocardialInfarction nullable: true
        otherMentalPersonalityDisorders nullable: true
        peripheralArterialDisease nullable: true
        postTraumaticStressDisorder nullable: true
        pregnancy nullable: true
        prematurity nullable: true
        schizoaffectiveDisorder nullable: true
        schizophrenia nullable: true
        steroidUse nullable: true
        substanceUseDisorder nullable: true
    }
    
    static mapping = {
        table 'pre_existing_conditions'
        version false
    }
}
