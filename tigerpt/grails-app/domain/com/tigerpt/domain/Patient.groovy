package com.tigerpt.domain

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes = 'id')
@ToString(includes = 'id,lastName,firstName,dateOfBirth', includeNames = true, includePackage = false)
class Patient {
    
    // Demographic Information
    String homeZipCode
    String homeCountry
    String homeState
    String homeCounty
    String homeCity
    String alternateHomeResidence
    Date dateOfBirth
    Integer age
    String ageUnits
    String race
    String ethnicity
    String sex
    
    // Additional patient info
    String firstName
    String lastName
    String middleName
    String medicalRecordNumber
    
    static hasMany = [
        injuries: Injury,
        preExistingConditions: PreExistingCondition,
        hospitalEvents: HospitalEvent,
        procedures: HospitalProcedure
    ]
    
    static constraints = {
        homeZipCode nullable: true, maxSize: 20
        homeCountry nullable: true, maxSize: 50
        homeState nullable: true, maxSize: 50
        homeCounty nullable: true, maxSize: 100
        homeCity nullable: true, maxSize: 100
        alternateHomeResidence nullable: true, maxSize: 200
        dateOfBirth nullable: true
        age nullable: true
        ageUnits nullable: true, maxSize: 20
        race nullable: true, maxSize: 50
        ethnicity nullable: true, maxSize: 50
        sex nullable: true, maxSize: 10, inList: ['Male', 'Female', 'Unknown', 'Other']
        firstName nullable: true, maxSize: 100
        lastName nullable: true, maxSize: 100
        middleName nullable: true, maxSize: 100
        medicalRecordNumber nullable: true, maxSize: 50, unique: true
    }
    
    static mapping = {
        table 'patients'
        version false
        injuries cascade: 'all-delete-orphan'
        preExistingConditions cascade: 'all-delete-orphan'
        hospitalEvents cascade: 'all-delete-orphan'
        procedures cascade: 'all-delete-orphan'
    }
}
