package com.padron.emergecyDeptInfo

enum HospitalDischargeType {

    DischargedToShortTermHospital(1),  // Discharged/Transferred to a short-term general hospital for inpatient care
    DischargedToIntermediateCareFacility(2),  // Discharged/Transferred to an Intermediate Care Facility (ICF)
    DischargedToHomeWithHomeHealthService(3),  // Discharged/Transferred to home under care of organized home health service
    LeftAgainstMedicalAdvice(4),  // Left against medical advice or discontinued care
    DeceasedExpired(5),  // Deceased/Expired
    DischargedToHome(6),  // Discharged to home or self-care (routine discharge)
    DischargedToSkilledNursingFacility(7),  // Discharged/Transferred to Skilled Nursing Facility (SNF)
    DischargedToHospiceCare(8),  // Discharged/Transferred to hospice care
    DischargedToCourtLawEnforcement(10),  // Discharged/Transferred to court/law enforcement
    DischargedToInpatientRehab(11),  // Discharged/Transferred to inpatient rehab or designated unit
    DischargedToLongTermCareHospital(12),  // Discharged/Transferred to Long Term Care Hospital (LTCH)
    DischargedToPsychiatricHospital(13),  // Discharged/Transferred to a psychiatric hospital or psychiatric distinct part unit of a hospital
    DischargedToOtherInstitution(14)  // Discharged/Transferred to another type of institution not defined elsewhere

    final int value

    HospitalDischargeType(int value) {
        this.value = value
    }
}