package com.padron

import com.padron.emergencyDeptInfo.GCS40_MotorType
import com.padron.emergencyDeptInfo.GCS_AssessmentType
import com.padron.emergencyDeptInfo.GCS_MotorType

import java.sql.Time

class TraumaQualityImprovement {

    static hasMany = [highestGcsAssessment: GCS_AssessmentType, cerebralMonitor: CerebralMonitorType]

    Integer highestGcsTotal
    GCS_MotorType highestGcsMotor
    List<GCS_AssessmentType> highestGcsAssessment

    GCS40_MotorType highestGcs40Motor

    PupillaryResponseType pupilResponse
    MidlineShiftType midlineShift

    List<CerebralMonitorType> cerebralMonitor
    List<Time> cerebralMonitorTime

    List<VenousThrombProphyType> venousThrombProphy
    List<Time> venousThrombProphyTime

    Integer packedRedBloodCells // CCs [mLs] within 4hours of arrival 0-40000
    Integer wholeBlood // CCs [mLs] within 4hours of arrival 0-40000
    Integer plasma // CCs [mLs] within 4hours of arrival 0-40000
    Integer platelets // CCs [mLs] within 4hours of arrival 0-40000

    Integer cryoprecipitate // CCs [mLs] within 4hours of arrival 0-40000

    AngiographyType angiography
    Time angiographyTime

    List<EmbolizationSiteType> embolizationSite
    List<Time> embolizationTime

    SurgeryHemorrhageControlType    surgeryHemorrhageControl
    Time surgeryHemorrhageControlTime

    Affirmation withdrawLifeSupport
    Time withdrawLifeSupportTime

    Affirmation antiboticTherapy
    Time antiboticTherapyTime


}
