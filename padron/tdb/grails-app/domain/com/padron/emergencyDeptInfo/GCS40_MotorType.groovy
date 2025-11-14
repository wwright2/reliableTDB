package com.padron.emergencyDeptInfo

enum GCS40_MotorType {

    // Pediatric (< 5 years)
    NotTestablePediatric(0),
    NonePediatric(1),
    ExtensionToPainPediatric(2),
    FlexionToPainPediatric(3),
    LocalizesPainPediatric(4),
    ObeysCommandsPediatric(5),

    // Adult
    NotTestableAdult(6),
    NoneAdult(7),
    ExtensionAdult(8),
    AbnormalFlexionAdult(9),
    NormalFlexionAdult(10),
    LocalizingAdult(11),
    ObeysCommandsAdult(12)

    final int value

    GCS40_MotorType(int value) {
        this.value = value
    }
}