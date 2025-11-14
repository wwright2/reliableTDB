package com.padron

enum AngiographyType {

    None(1),
    AngiogramOnly(2),  // Angiogram only
    AngiogramWithEmbolization(3),  // Angiogram with embolization
    AngiogramWithStenting(4)  // Angiogram with stenting

    final int value

    AngiographyType(int value) {
        this.value = value
    }
}