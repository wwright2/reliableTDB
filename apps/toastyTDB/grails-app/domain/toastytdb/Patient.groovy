package toastytdb

class Patient extends Person {

    static constraints = {
    }

    TraumaAdmission admit
    Date    admissionDate
    Date    releaseDate

    String releaseInfo
}
