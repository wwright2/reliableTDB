package com.padron

enum SurgeryHemorrhageControlType {

    None(1),
    Laparotomy(2),
    Thoracotomy(3),
    Sternotomy(4),
    Extremity(5),
    Neck(6),
    MangledExtremity(7),  // Mangled extremity/traumatic amputation
    OtherSkinSoftTissue(8),  // Other skin/soft tissue (e.g. scalp laceration)
    ExtraperitonealPelvicPacking(9)  // Extraperitoneal Pelvic Packing

    final int value

    SurgeryHemorrhageControlType(int value) {
        this.value = value
    }
}