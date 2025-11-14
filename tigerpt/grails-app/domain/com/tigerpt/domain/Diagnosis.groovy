package com.tigerpt.domain

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes = 'id')
@ToString(includes = 'id,icd10InjuryDiagnosis,aisCode', includeNames = true, includePackage = false)
class Diagnosis {
    
    Injury injury
    
    // Diagnosis Information
    String icd10InjuryDiagnosis
    String aisCode
    String aisVersion
    String bodyRegion
    Integer aisSeverity
    
    static belongsTo = [injury: Injury]
    
    static constraints = {
        icd10InjuryDiagnosis nullable: true, maxSize: 20
        aisCode nullable: true, maxSize: 20
        aisVersion nullable: true, maxSize: 20
        bodyRegion nullable: true, maxSize: 100
        aisSeverity nullable: true, min: 1, max: 6
    }
    
    static mapping = {
        table 'diagnoses'
        version false
    }
}
