package com.padron

class Address {
    static belongsTo = [person: Person, country: Country, state: State]
    String city
    String county
    String zipCode
    // other address attributes


/*
    Description CITY
            The patient’s city (or township, or village) of residence.
    Element Values
        • Relevant value for data element (five-digit numeric FIPS code)
        Additional Information
        • Only reported when Patient's Home ZIP/Postal Code is “Not Known/Not Recorded” and
        country is the US.
        • Used to calculate the FIPS code.
        • The null value “Not Applicable” is reported if Patient’s Home ZIP/Postal Code is reported.
        • The null value “Not Applicable” is reported for non-US hospitals.


    patient’s COUNTY (or parish) of residence.
    Element Values
        • Relevant value for data element (three-digit numeric FIPS code)   Additional Information
        • Only reported when Patient's Home ZIP/Postal Code is “Not Known/Not Recorded” and the country is the US.
        • Used to calculate the FIPS code.
        • The null value “Not Applicable” is reported if Patient’s Home ZIP/Postal Code is reported.
        • The null value “Not Applicable” is reported for non-US hospitals.


    Description STATE
            The state (territory, province, or District of Columbia) where the patient resides.
    Element Values
    • Relevant value for data element (two-digit numeric FIPS code)
    Additional Information
    • Only reported when Patient's Home ZIP/Postal Code is “Not Known/Not Recorded” and
    country is US.
    • Used to calculate FIPS code.
    • The null value “Not Applicable” is reported if Patient’s Home ZIP/Postal Code is reported.
    • The null value “Not Applicable” is reported for non-US hospitals.


    Description COUNTRY
            The country where the patient resides.
            Element Values
    • Relevant value for data element (two-digit alpha country code)
    Additional Information
    • Values are two-character FIPS codes representing the country (e.g., US).
    • If Patient’s Home Country is not US, then the null value “Not Applicable” is reported for
    Patient’s Home State, Patient’s Home County, and Patient’s Home City.

    Description ZIP
    The patient’s home ZIP/postal code of primary residence.
    Element Values
    • Relevant value for data element Additional Information
    • Can be stored as a 5 or 9-digit code (XXXXX-XXXX) for US or can be stored in the postal code
    format of the applicable country.
    • May require adherence to HIPAA regulations.
    • If Patient’s Home ZIP/Postal Code is “Not Applicable,” report data element Alternate Home
    Residence.
    • If Patient’s Home ZIP/Postal Code is “Not Known/Not Recorded,” report: Patient’s Home
    Country, Patient’s Home State (US only), Patient’s Home County (US only), and Patient’s
    Home City (US only).
    • If Patient’s Home ZIP/Postal Code is reported, must also report Patient’s Home Country.

 */
}