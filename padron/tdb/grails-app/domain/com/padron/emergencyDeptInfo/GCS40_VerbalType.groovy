package com.padron.emergencyDeptInfo

enum GCS40_VerbalType {

    // Pediatric (< 5 years)
    NotTestablePediatric(0),
    NonePediatric(1),
    CriesPediatric(2),
    VocalSoundsPediatric(3),
    WordsPediatric(4),
    TalksNormallyPediatric(5),

    // Adult
    NotTestableAdult(6),
    NoneAdult(7),
    SoundsAdult(8),
    WordsAdult(9),
    ConfusedAdult(10),
    OrientedAdult(11)

    final int value

    GCS40_VerbalType(int value) {
        this.value = value
    }
}