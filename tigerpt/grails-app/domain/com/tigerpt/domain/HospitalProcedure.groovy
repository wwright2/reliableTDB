package com.tigerpt.domain

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes = 'id')
@ToString(includes = 'id,icd10ProcedureCode', includeNames = true, includePackage = false)
class HospitalProcedure {
    
    Patient patient
    
    String icd10ProcedureCode
    String procedureDescription
    Date procedureStartDate
    Date procedureStartTime
    String procedureType
    String surgeon
    String nationalProviderIdentifier
    
    static belongsTo = [patient: Patient]
    
    static constraints = {
        icd10ProcedureCode nullable: true, maxSize: 20
        procedureDescription nullable: true, maxSize: 500
        procedureStartDate nullable: true
        procedureStartTime nullable: true
        procedureType nullable: true, maxSize: 100
        surgeon nullable: true, maxSize: 200
        nationalProviderIdentifier nullable: true, maxSize: 20
    }
    
    static mapping = {
        table 'hospital_procedures'
        version false
    }
}
