package com.padron

enum VenousThrombProphyType {

    None(5),
    LMWH(6),  // LMWH (Dalteparin, Enoxaparin, etc.)
    DirectThrombinInhibitor(7),  // Direct Thrombin Inhibitor (Dabigatran, etc.)
    XaInhibitor(8),  // Xa Inhibitor (Rivaroxaban, etc.)
    Other(10),
    UnfractionatedHeparin(11)  // Unfractionated Heparin (UH)

    final int value

    VenousThrombProphyType(int value) {
        this.value = value
    }
}