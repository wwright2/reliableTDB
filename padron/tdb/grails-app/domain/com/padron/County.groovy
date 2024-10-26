package com.padron

class County {
    belongsTo = [ state: State ]
    String name
    String fips//Relevant value for data element (three-digit numeric FIPS code)
}