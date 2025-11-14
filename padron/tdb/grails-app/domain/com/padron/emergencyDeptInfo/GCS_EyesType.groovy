package com.padron.emergencyDeptInfo

enum GCS_EyesType {

    NotKnown(0),
    NoEyeMovement(1),
    OpensEyesToPain(2),
    OpensEyesToVerbal(3),
    OpensEyesSpontaneously(4)

    final int value

    GCS_EyesType(int value) {
        this.value = value
    }
}