package com.padron.hospitalProcInfo

enum Icd10CodeType {

    PCS(1),
    CA(2)

    final int value

    Icd10CodeType(int value) {
        this.value = value
    }
}