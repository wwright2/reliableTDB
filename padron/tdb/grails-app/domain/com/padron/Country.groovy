package com.padron

class Country {
    static hasMany = [states: State, addresses: Address, phoneNumbers: Phone]
    String name
    String code
    // other country attributes
}
