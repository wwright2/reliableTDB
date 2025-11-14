package com.padron

enum PrimaryPaymentType {

    Medicaid(1),
    NotBilled(2),  // Not Billed (for any reason)
    SelfPay(3),  // Self-Pay
    PrivateCommercialInsurance(4),  // Private/Commercial Insurance
    Medicare(6),
    OtherGovernment(7),  // Other Government
    Other(10)

    final int value

    PrimaryPaymentType(int value) {
        this.value = value
    }
}
