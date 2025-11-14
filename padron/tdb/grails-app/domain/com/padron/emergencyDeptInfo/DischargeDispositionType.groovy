package com.padron.emergencyDeptInfo

enum DischargeDispositionType {
    FloorBed(1),  // Floor bed (general admission, non-specialty unit bed)
    ObservationUnit(2),  // Observation unit
    TelemetryStepDownUnit(3),  // Telemetry/step-down unit (less acuity than ICU)
    HomeWithServices(4),  // Home with services
    DeceasedExpired(5),  // Deceased/expired
    Other(6),  // Other (jail, institutional care, mental health, etc.)
    OperatingRoom(7),  // Operating Room
    IntensiveCareUnit(8),  // Intensive Care Unit (ICU)
    HomeWithoutServices(9),  // Home without services
    LeftAgainstMedicalAdvice(10),  // Left against medical advice
    TransferredToAnotherHospital(11)  // Transferred to another hospital

    final int value

    DischargeDispositionType(int value) {
        this.value = value
    }
}