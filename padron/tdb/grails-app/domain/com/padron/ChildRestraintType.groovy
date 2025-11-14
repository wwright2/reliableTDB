package com.padron

enum ChildRestraintType {

    ChildCarSeat(1),
    InfantCarSeat(2),
    ChildBoosterSeat(3)

    final int value

    ChildRestraintType(int value) {
        this.value = value
    }
}