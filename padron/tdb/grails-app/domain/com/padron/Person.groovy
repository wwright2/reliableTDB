package com.padron

class Person {
    static hasMany = [addresses: Address, phoneNumbers: Phone, myRaces: Race]

    String firstname
    String lastname
    String middlename

    HousingStatus status
    Date    dateOfBirth
    Date    patientAgeAtInjuryDate
    Integer ageUnits   // 1. Hours    2. Days    3. Months    4. Years    5. Minutes    6. Weeks
    Integer ethnicity  // 1. Hispanic/Latino   2. Not ( Hispanic/Latino ) nonblank, single
    Integer sex        //The patient’s sex. Element Values ( 1. Male , 2. Female, 3. Non-binary)
                        // 1101 1 Value is not a valid menu option
                        // 1102 2 Element cannot be blank
                        // 1103 2 Element cannot be “Not Applicable”
                        // 1140 1 Single Entry Max exceeded

    /*
    Description DOB
        The patient’s date of birth.
        • Reported as YYYY-MM-DD.
        • If Date of Birth is “Not Known/Not Recorded,” report Age and Age Units.
        • If Date of Birth is the same as the Injury Incident Date, then the Age and Age Units data
        elements must be reported.

    Description InjuryDate
        The patient’s age at the time of injury (best approximation).
        element value
        • Relevant value for data element
        additional in formation
        • Must also report Age Units.
        • Report Age and Age Units if Date of Birth is reported as “Not Known/Not Recorded."
        • Report Age and Age Units if Date of Birth is reported the same as the ED/Hospital
        Arrival Date.
        • The null value “Not Applicable” is reported if Date of Birth is reported.
        data source

    patientAgeAtInjuryDate : additional in formation
    • Must also report Age Units.
    • Report Age and Age Units if DOB is “Not Known/Not Recorded."
    • Report Age and Age Units if DOB Date same as the ED/Hospital Arrival Date.
    • The null value “Not Applicable” is reported if Date of Birth is reported. data source

    ageUnits
    • Must also report Age.
    • Report Age Units and Age if Date of Birth is “Not Known/Not Recorded."
    • Report Age Units and Age if Date of Birth is the same as the ED/Hospital Arrival Date.
    • The null value “Not Applicable” is reported if Date of Birth is reported.

     */
}
