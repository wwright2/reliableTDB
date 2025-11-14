package com.padron.emergencyDeptInfo

enum GCS_MotorType {

    // Pediatric (≤2 years)
    NoMotorResponsePediatric(1),
    ExtensionToPainPediatric(2),
    FlexionToPainPediatric(3),
    WithdrawalFromPainPediatric(4),
    LocalizingPainPediatric(5),
    AppropriateResponseToStimulation(6),

    // Adult
    NoMotorResponseAdult(10),
    ExtensionToPainAdult(11),
    FlexionToPainAdult(12),
    WithdrawalFromPainAdult(13),
    LocalizingPainAdult(14),
    ObeysCommands(15)

    final int value

    GCS_MotorType(int value) {
        this.value = value
    }
}