package com.padron

class SexType {

    static constraints = {
        label unique : true
        val unique : true
    }
    String  label       //male,female,non-binary
    Integer val   //The patient’s sex. Element Values ( 1. Male , 2. Female, 3. Non-binary)
                            // 1101 1 Value is not a valid menu option
                            // 1102 2 Element cannot be blank
                            // 1103 2 Element cannot be “Not Applicable”
                            // 1140 1 Single Entry Max exceeded
}