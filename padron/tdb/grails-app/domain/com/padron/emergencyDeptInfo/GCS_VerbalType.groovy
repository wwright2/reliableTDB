package com.padron.emergencyDeptInfo

enum GCS_VerbalType {

    // Pediatric (≤2 years)
    NoVocalResponsePediatric(1),
    InconsolableAgitated(2),
    InconsistentlyConsolableMoaning(3),
    CriesButConsolable(4),
    SmilesOriented(5),

    // Adult
    NoVerbalResponseAdult(11),
    IncomprehensibleSounds(12),
    InappropriateWords(13),
    Confused(14),
    Oriented(15)

    final int value

    GCS_VerbalType(int value) {
        this.value = value
    }
}