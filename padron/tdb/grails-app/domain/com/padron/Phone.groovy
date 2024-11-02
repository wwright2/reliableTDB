package com.padron


class Phone {
    static belongsTo = [person: Person]
    String number
    String type // e.g., "mobile", "home", "work"
    // other phone attributes
}