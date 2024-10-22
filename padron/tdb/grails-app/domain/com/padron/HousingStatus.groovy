package com.padron

class HousingStatus {

    static constraints = { value nullable : true
    }

    Integer value

    static enum residentStatus {Homeless, UndocumentedCitizen, MigrantWorker}


    /* Additional Information
        • Only reported when Patient's Home ZIP/Postal Code is “Not Applicable.”
        • Report all that apply.
        • Homeless is defined as a person who lacks housing and includes a person living in
        transitional housing or a supervised public or private facility providing temporary living
        quarters.
        • Undocumented Citizen is defined as a national of another country who has entered or stayed
        in another country without permission.
        • Migrant Worker is defined as a person who temporarily leaves his/her principal place of
        residence within a country to accept seasonal employment in the same or different country.
     */

    /* Data Source Hierarchy Guide
        1. Face Sheet
        2. Billing Sheet
        3. Admission Form

     Associated Edit Checks
        Rule ID Level Message
        ---------------------
        0501 1 Value is not a valid menu option
        0502 2 Element cannot be blank
        0503 2 Element cannot be “Not Applicable” or “Not Known/Not Recorded” along
        with any other value
        0540 1 Multiple Entry Max exceeded
    */

}