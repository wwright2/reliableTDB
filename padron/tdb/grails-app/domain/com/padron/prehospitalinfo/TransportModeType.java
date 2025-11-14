package com.padron.prehospitalinfo;

public enum TransportModeType {

    GroundAmbulance(1),
    HelicopterAmbulance(2),
    FixedWingAmbulance(3),
    PrivatePublicVehicleWalkIn(4),
    Police(5),
    Other(6);

    private final int value;

    TransportModeType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
