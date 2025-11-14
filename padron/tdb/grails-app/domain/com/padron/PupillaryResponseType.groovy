package com.padron

enum PupillaryResponseType {

    BothReactive(1),
    OneReactive(2),
    NeitherReactive(3)

    final int value

    PupillaryResponseType(int value) {
        this.value = value
    }
}