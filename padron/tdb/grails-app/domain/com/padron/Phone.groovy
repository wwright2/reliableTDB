package com.padron


class Phone {
    static belongsTo = [person: Person, country: Country]
    String number
    String type // e.g., "mobile", "home", "work"
    // other phone attributes
}