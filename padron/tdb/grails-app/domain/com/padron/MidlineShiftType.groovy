package com.padron

enum MidlineShiftType {

    Yes(1),
    No(2),
    NotImaged(3)  // Not Imaged (e.g. CT Scan, MRI)

    final int value

    MidlineShiftType(int value) {
        this.value = value
    }
}