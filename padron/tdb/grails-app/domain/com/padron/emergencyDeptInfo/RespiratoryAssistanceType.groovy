package com.padron.emergencyDeptInfo

enum RespiratoryAssistanceType {

    NotApplicable(0),
    Unassisted(1),
    Assisted(2)

    final int value

    RespiratoryAssistanceType(int value) {
        this.value = value
    }
}