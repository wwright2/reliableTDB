package com.tigerpt

import com.tigerpt.domain.*

class BootStrap {

    def init = { servletContext ->
        // Create some sample data if database is empty
        if (Patient.count() == 0) {
            log.info "Loading sample trauma data..."
            
            Patient.withTransaction {
                // Sample Patient 1
                def patient1 = new Patient(
                    firstName: "John",
                    lastName: "Doe",
                    medicalRecordNumber: "MRN001",
                    dateOfBirth: new Date(System.currentTimeMillis() - 365L * 45 * 24 * 60 * 60 * 1000), // 45 years ago
                    age: 45,
                    ageUnits: "Years",
                    sex: "Male",
                    race: "White",
                    ethnicity: "Not Hispanic or Latino",
                    homeZipCode: "90210",
                    homeState: "California",
                    homeCity: "Los Angeles",
                    homeCountry: "United States"
                )
                patient1.save(failOnError: true)
                
                // Sample Injury for Patient 1
                def injury1 = new Injury(
                    patient: patient1,
                    injuryIncidentDate: new Date(System.currentTimeMillis() - 7L * 24 * 60 * 60 * 1000), // 7 days ago
                    icd10PrimaryExternalCause: "V89.2",
                    transportMode: "Ground Ambulance",
                    edHospitalArrivalDate: new Date(System.currentTimeMillis() - 7L * 24 * 60 * 60 * 1000),
                    initialEdSystolicBP: 110,
                    initialEdPulseRate: 88,
                    initialEdTemperature: 98.6,
                    initialEdRespiratoryRate: 16,
                    initialEdOxygenSaturation: 98,
                    initialEdGcsTotal: 15,
                    initialEdGcsEyes: 4,
                    initialEdGcsVerbal: 5,
                    initialEdGcsMotor: 6,
                    primaryTraumaServiceType: "Trauma Surgery"
                )
                injury1.save(failOnError: true)
                
                // Sample Diagnosis
                def diagnosis1 = new Diagnosis(
                    injury: injury1,
                    icd10InjuryDiagnosis: "S06.0",
                    aisCode: "140602.3",
                    aisVersion: "2015",
                    bodyRegion: "Head",
                    aisSeverity: 3
                )
                diagnosis1.save(failOnError: true)
                
                // Sample Pre-existing Conditions
                def preExisting1 = new PreExistingCondition(
                    patient: patient1,
                    hypertension: true,
                    diabetesMellitus: true,
                    currentSmoker: false
                )
                preExisting1.save(failOnError: true)
                
                // Sample Outcome
                def outcome1 = new Outcome(
                    patient: patient1,
                    totalIcuLengthOfStay: 3,
                    totalVentilatorDays: 0,
                    hospitalDischargeDisposition: "Home",
                    hospitalDischargeDate: new Date(System.currentTimeMillis() - 2L * 24 * 60 * 60 * 1000), // 2 days ago
                    primaryMethodOfPayment: "Private Insurance"
                )
                outcome1.save(failOnError: true)
                
                log.info "Sample trauma data loaded successfully"
            }
        }
    }
    
    def destroy = {
    }
}
