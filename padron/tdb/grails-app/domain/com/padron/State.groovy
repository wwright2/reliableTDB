package com.padron

class State {
    static belongsTo = [country: Country]
    static hasMany = [addresses: Address]
    String name
    String code
    // other state attributes
}