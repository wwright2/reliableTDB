package com.padron.emergencyDeptInfo

enum PrimaryTraumaServiceType {

    Adult(1),
    Pediatric(2)

    final int value

    PrimaryTraumaServiceType(int value) {
        this.value = value
    }
}