package toastytdb

class Person {

    static constraints = {
        identifiers unique: true, nullable:true
    }
    static mappedby = [addresses : "none", phones: "none", identifiers:"none" ]
    static hasOne = [identifiers:Identification]
    static hasMany = [addresses: Address, phones: Phone]

    String  lastname
    String  firstname
    String  middlename
    Boolean active

}
