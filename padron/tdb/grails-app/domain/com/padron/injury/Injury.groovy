package com.padron.injury

import com.padron.*
import com.padron.Occupation
import com.padron.OccupationIndustry

import java.sql.Time

class Injury {

    static constraints = {

    }
    static belongsTo = [patient: Patient]
    static hasOne = [incidentAddress: Address]
    static hasMany = [protectionTypes: ProtectiveDeviceType]

    Address incidentAddress
    Time injuryDateTime

    Affirmation workRelated
    OccupationIndustry occupationIndustry
    Occupation occupation

    String icd10PrimaryExternalCauseCode    // E-Code is not a valid ICD-10-CM code (ICD-10-CM only)
    String icd10PlaceOccuranceCode      //Place of Injury code must be Y92.X/Y92.XX/Y92.XXX (where X is A-Z [excluding I,O] or 0-9) (ICD-10-CM only)
    List<String> icdAdditionalCode      // list max 2 len=3-8

    List<ProtectiveDeviceType> protectionType  // multi=yes max=10

    ChildRestraintType  childRestraint  //
    AirbagDeployType    airbagDeploy    // 1. Deployed 2. Not Deployed 3. Not Applicable 4. Deployed, Unknown if Deployed in Front or Side 5. Deployed, Unknown if Deployed in Front, Side, or Other

}