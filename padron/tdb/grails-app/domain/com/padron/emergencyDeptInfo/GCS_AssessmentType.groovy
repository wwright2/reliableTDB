package com.padron.emergencyDeptInfo

enum GCS_AssessmentType {

    NotKnown(0),        //The null value “Not Known/Not Recorded” is reported if the Initial ED/Hospital GCS
                              // Assessment Qualifiers are not documented within 30 minutes of ED/hospital arrival.
    ChemicallySedatedOrParalyzed(1),
    ObstructionToEye(2),
    PatientIntubated(3),
    ValidGCS(4)

    final int value

    GCS_AssessmentType(int value) {
        this.value = value
    }
}