package com.padron

enum EmbolizationSiteType {

    Liver(1),
    Spleen(2),
    Kidneys(3),
    Pelvic(4),  // Pelvic (iliac, gluteal, obturator)
    Retroperitoneum(5),  // Retroperitoneum (lumbar, sacral)
    PeripheralVascular(6),  // Peripheral vascular (neck, extremities)
    Other(8)

    final int value

    EmbolizationSiteType(int value) {
        this.value = value
    }
}