package tdb

import com.padron.RaceService
import com.padron.*


class BootStrap {

    RaceService raceService

    def initRace = {servletContext ->


    }

    def init = { servletContext ->

        def sx = new SexType(label:"Male",val:1).save()
        sx = new SexType(label:"Female",val:2).save()
        sx = new SexType(label:"Non-binary",val:3).save()

        def r = new Race(label:"Asian",val:1).save()
        r = new Race(label:"Native Hawaiian or Other Pacific Islander", val:2).save()
        r = new Race(label:"Other Race", val:3).save()
        r = new Race(label:"American Indian",val:4).save()
        r = new Race(label:"Black or African American", val:5).save()
        r = new  Race(label:"White",val:6).save()

        /* State
        AL 01 Alabama
        AK 02 Alaska
         */
        def s = new State(code:"AL",fips:1,name:"Alabama").save()
        s = new State(code:"AK",fips:2,name:"Alaska").save()

        /* Country

         */
        def c = new Country(code:"US", name:"United States").save()
        c = new Country(code:"GB", name:"United Kingdom").save()
        c = new Country(code:"AF", name:"Afghanistan").save()
        c = new Country(code:"AL", name:"Albania").save()
        c = new Country(code:"DZ", name:"Algeria").save()
        c = new Country(code:"AS", name:"American Samoa").save()

        c = new Country(code:"IE", name:"Ireland").save()

        /*  County
        01001        Autauga County
        01003        Baldwin County
        01005        Barbour County
        */
        def d = new County(fips: "001", name:"Autauga").save()
        d = new County(fips: "002", name:"Baldwin").save()
        d = new County(fips: "003", name:"Barbour").save()

        /* Housing       1. Homeless 2. Undocumented Citizen 3. Migrant Worker */
        def altHousing = new AltHousing(label:"Homeless",housing:1).save()
        altHousing = new AltHousing(label:"Undocumented Citizen",housing:2).save()
        altHousing = new AltHousing(label:"Migrant Worker",housing:3).save()
    }


    def destroy = {
    }
}