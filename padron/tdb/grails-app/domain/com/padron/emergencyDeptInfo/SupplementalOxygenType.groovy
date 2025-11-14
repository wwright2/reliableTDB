package com.padron.emergencyDeptInfo

enum SupplementalOxygenType {

    NotApplicable(0),
    NoSupplementalOxygen(1),
    SupplementalOxygen(2)

    final int value

    SupplementalOxygenType(int value) {
        this.value = value
    }
}