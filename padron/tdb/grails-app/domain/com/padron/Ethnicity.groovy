package com.padron

enum Ethnicity {

    HispanicOrLatino(1), NotHispanicOrLatino(2)

    final int value

    Ethnicity(int value) {
        this.value = value
    }

    static Ethnicity getDefault() {
        return NotHispanicOrLatino
    }
}