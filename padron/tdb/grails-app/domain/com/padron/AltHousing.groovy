package com.padron

enum AltHousing {

    Homeless(1), UndocumentedCitizen(2), MigrantWorker(3)

    final int value

    AltHousing(int value) {
        this.value = value
    }

    static AltHousing getDefault() {
        return Homeless
    }
}