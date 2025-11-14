package com.padron

import java.sql.Time

class TotalIcuStay {
    static belongsTo = [outcomeInformation: OutcomeInformation]

    Time    icuStart
    Time    icuStop
    Integer los  //Length of stay in Days.
}
