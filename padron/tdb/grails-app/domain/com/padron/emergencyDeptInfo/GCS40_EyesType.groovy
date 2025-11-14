package com.padron.emergencyDeptInfo

enum GCS40_EyesType {

    // Pediatric (< 5 years)
    NotTestablePediatric(0),
    NonePediatric(1),
    ToPainPediatric(2),
    ToSoundPediatric(3),
    SpontaneousPediatric(4),

    // Adult
    NotTestableAdult(10),
    NoneAdult(11),
    ToPressureAdult(12),
    ToSoundAdult(13),
    SpontaneousAdult(14)

    final int value

    GCS40_EyesType(int value) {
        this.value = value
    }
}