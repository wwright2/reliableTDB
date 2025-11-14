package com.padron

import com.padron.emergecyDeptInfo.HospitalDischargeType

import java.sql.Time

class OutcomeInformation {

    static hasMany = [totalIcuStayLOS: TotalIcuStay, totalVentilatorDays: TotalVentilatorDay ]

    HospitalDischargeType hospitalDischarge

    Time    dischargeTime



}
