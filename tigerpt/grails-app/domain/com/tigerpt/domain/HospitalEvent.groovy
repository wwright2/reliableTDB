package com.tigerpt.domain

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes = 'id')
@ToString(includes = 'id,patient,eventType', includeNames = true, includePackage = false)
class HospitalEvent {
    
    Patient patient
    
    String eventType
    Date eventDate
    Date eventTime
    String severity
    String notes
    
    // Hospital Events (as per NTDS)
    Boolean acuteKidneyInjury
    Boolean acuteRespiratoryDistressSyndrome
    Boolean alcoholWithdrawalSyndrome
    Boolean cardiacArrestWithCpr
    Boolean catheterAssociatedUrinaryTractInfection
    Boolean centralLineAssociatedBloodstreamInfection
    Boolean deepSurgicalSiteInfection
    Boolean deepVeinThrombosis
    Boolean delirium
    Boolean myocardialInfarction
    Boolean organSpaceSurgicalSiteInfection
    Boolean osteomyelitis
    Boolean pressureUlcer
    Boolean pulmonaryEmbolism
    Boolean severeSepsis
    Boolean strokeCva
    Boolean superficialIncisionalSurgicalSiteInfection
    Boolean unplannedAdmissionToIcu
    Boolean unplannedIntubation
    Boolean unplannedVisitToOperatingRoom
    Boolean ventilatorAssociatedPneumonia
    
    static belongsTo = [patient: Patient]
    
    static constraints = {
        eventType nullable: true, maxSize: 100
        eventDate nullable: true
        eventTime nullable: true
        severity nullable: true, maxSize: 50
        notes nullable: true, maxSize: 2000
        acuteKidneyInjury nullable: true
        acuteRespiratoryDistressSyndrome nullable: true
        alcoholWithdrawalSyndrome nullable: true
        cardiacArrestWithCpr nullable: true
        catheterAssociatedUrinaryTractInfection nullable: true
        centralLineAssociatedBloodstreamInfection nullable: true
        deepSurgicalSiteInfection nullable: true
        deepVeinThrombosis nullable: true
        delirium nullable: true
        myocardialInfarction nullable: true
        organSpaceSurgicalSiteInfection nullable: true
        osteomyelitis nullable: true
        pressureUlcer nullable: true
        pulmonaryEmbolism nullable: true
        severeSepsis nullable: true
        strokeCva nullable: true
        superficialIncisionalSurgicalSiteInfection nullable: true
        unplannedAdmissionToIcu nullable: true
        unplannedIntubation nullable: true
        unplannedVisitToOperatingRoom nullable: true
        ventilatorAssociatedPneumonia nullable: true
    }
    
    static mapping = {
        table 'hospital_events'
        version false
    }
}
