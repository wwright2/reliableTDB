package com.vogella.grails.guestbook

class Telephone {
    String  number  // digits
    Integer defaultNum // true, false
    String  usage   //mobile,home,office,

    static constraints = {
    }
    static mapping = {
        table 'telephone'
    }
}
