package toastytdb

class Address {

    static constraints = {
        address2 nullable :true
        city nullable: true
        state nullable: true
    }
    Person person

    String address1
    String address2
    String city
    String state
    String postalcode
    String country
}
