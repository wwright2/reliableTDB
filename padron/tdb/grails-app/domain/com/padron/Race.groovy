package com.padron

class Race {

    static constraints = {
    }
    static belongsTo = [person: Person]

    Integer race

    enum Race {1. Asian, 2. NativeHawaiianOtherPacificIslander,   3. OtherRace,   4. AmericanIndian,   5. BlackAfricanAmerican,
        6. White}

    /*
    The patient’s race.
        Element Values
        1. Asian
        2. Native Hawaiian or Other Pacific Islander
        3. Other Race
        4. American Indian
        5. Black or African American
        6. White
    Additional Information
        • Report all that apply.
        • Patient race should be based upon self-report or identified by a family member.
        • Based on the 2010 US Census Bureau.

    Data Source Hierarch y Guide
        1. Face Sheet
        2. Billing Sheet
        3. Admission Form
        4. Triage/Trauma Flow Sheet
        5. EMS Run Report
        6. History and Physical

    Associated Edit Checks
        Rule ID Level Message
        0901 1 Value is not a valid menu option
        0902 2 Element cannot be blank
        0903 2 Element cannot be “Not Applicable” (excluding Canadian hospitals)
        0905 2 Element cannot be “Not Applicable” or “Not Known/Not Recorded” along
        with any other value
        0950 1 Multiple Entry Max exceeded
     */
}