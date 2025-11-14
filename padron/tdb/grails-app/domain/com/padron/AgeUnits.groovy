
package com.padron

enum AgeUnits {

    Hours(1), Days(2), Months(3), Years(4), Minutes(5), Weeks(6)

    final int value

    AgeUnits(int value) {
        this.value = value
    }

    static AgeUnits getDefault() {
        return Years
    }
}