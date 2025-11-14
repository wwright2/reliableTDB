package com.padron.emergencyDeptInfo

enum DrugScreenType {

    AMP(1),  // Amphetamine
    BAR(2),  // Barbiturate
    BZO(3),  // Benzodiazepines
    COC(4),  // Cocaine
    mAMP(5), // Methamphetamine
    MDMA(6), // Ecstasy
    MTD(7),  // Methadone
    OPI(8),  // Opioid
    OXY(9),  // Oxycodone
    PCP(10), // Phencyclidine
    TCA(11), // Tricyclic Antidepressant
    THC(12), // Cannabinoid
    Other(13),
    None(14),
    NotTested(15)

    final int value

    DrugScreenType(int value) {
        this.value = value
    }
}
