package com.padron

enum ProtectiveDeviceType {

    None(1),
    LapBelt(2),
    PersonalFloatationDevice(3),
    ProtectiveNonClothingGear(4),
    EyeProtection(5),
    ChildRestraint(6),
    Helmet(7),
    AirbagPresent(8),
    ProtectiveClothing(9),
    ShoulderBelt(10),
    Other(11)

    final int value

    ProtectiveDeviceType(int value) {
        this.value = value
    }
}