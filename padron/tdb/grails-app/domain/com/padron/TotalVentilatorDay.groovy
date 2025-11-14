package com.padron

import java.sql.Time

class TotalVentilatorDay {
    static belongsTo = [outcomeInformation: OutcomeInformation]

    Time    treatStart
    Time    treatStop
    Integer los  //Length of stay in Days.
}
