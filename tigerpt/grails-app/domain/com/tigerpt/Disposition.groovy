package com.tigerpt

import java.time.LocalDate
import java.time.LocalTime
import com.tigerpt.domain.Patient

class Disposition {

    String edDischargeDisposition
    LocalDate edDischargeDate
    LocalTime edDischargeTime
    
    static belongsTo = [patient: Patient]
    
    static constraints = {
        edDischargeDisposition nullable: true, maxSize: 255
        edDischargeDate nullable: true
        edDischargeTime nullable: true
    }
    
    static mapping = {
        table 'disposition'
        version false
    }
    
    String toString() {
        return "Disposition: ${edDischargeDisposition}"
    }
}
