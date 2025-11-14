package com.tigerpt

class ImportController {

    def index() { }

    def uploadXml() {
        def file = request.getFile('xmlFile')
        
        if (file?.empty) {
            flash.error = "Please select an XML file to upload"
            redirect action: 'index'
            return
        }
        
        try {
            def xml = new XmlSlurper().parseText(file.inputStream.text)
            def recordsImported = 0
            
            xml.ITRRecord.each { record ->
                // Create or update patient
                def patient = Patient.findByPatientId(record.PatientId.text()) ?: new Patient()
                
                patient.patientId = record.PatientId.text()
                patient.facilityId = record.FacilityId.text()
                patient.patientLastName = record.PatientLastName.text()
                patient.patientFirstName = record.PatientFirstName.text()
                patient.patientMiddleName = record.PatientMiddleName.text()
                patient.socialSecurityNumber = record.SocialSecurityNumber.text()
                patient.homeZip = record.HomeZip.text()
                patient.homeCountry = record.HomeCountry.text()
                patient.homeState = record.HomeState.text()
                patient.homeCounty = record.HomeCounty.text()
                patient.homeCity = record.HomeCity.text()
                patient.dateOfBirth = Date.parse('yyyy-MM-dd', record.DateOfBirth.text())
                patient.age = record.Age.text() as Integer
                patient.ageUnits = record.AgeUnits.text()
                patient.race = record.Races?.item?.Race?.text()
                patient.ethnicity = record.Ethnicity.text()
                patient.sex = record.Sex.text()
                patient.medicalRecordNumber = record.MedicalRecordNumber.text()
                
                patient.save(flush: true)
                
                // Create injury record
                def injury = new Injury()
                injury.patient = patient
                injury.incidentDate = Date.parse('yyyy-MM-dd', record.IncidentDate.text())
                injury.incidentTime = record.IncidentTime.text()
                injury.workRelated = record.WorkRelated.text()
                injury.primaryECodeIcd10 = record.PrimaryECodeIcd10.text()
                injury.placeOfInjuryCode = record.PlaceOfInjuryCode.text()
                injury.injuryZip = record.InjuryZip.text()
                injury.incidentCountry = record.IncidentCountry.text()
                injury.traumaType = record.TraumaType.text()
                injury.emsAgencyId = record.EMSAgencyID.text()
                injury.emsAgencyName = record.EMSAgencyName.text()
                injury.transportMode = record.TransportMode.text()
                injury.interFacilityTransfer = record.InterFacilityTransfer.text()
                injury.hospitalArrivalDate = Date.parse('yyyy-MM-dd', record.HospitalArrivalDate.text())
                injury.hospitalArrivalTime = record.HospitalArrivalTime.text()
                injury.sbp = record.Sbp.text() as Integer
                injury.dbp = record.Dbp.text() as Integer
                injury.pulseRate = record.PulseRate.text() as Integer
                injury.temperature = record.Temperature.text() as BigDecimal
                injury.respiratoryRate = record.RespiratoryRate.text() as Integer
                injury.pulseOximetry = record.PulseOximetry.text() as Integer
                injury.gcsEye = record.GcsEye.text() as Integer
                injury.gcsVerbal = record.GcsVerbal.text() as Integer
                injury.gcsMotor = record.GcsMotor.text() as Integer
                injury.totalGcs = record.TotalGcs.text() as Integer
                injury.weight = record.Weight.text() as BigDecimal
                injury.height = record.Height.text() as BigDecimal
                injury.edDischargeDisposition = record.EdDischargeDisposition.text()
                injury.revisedTraumaScore = record.RevisedTraumaScore.text() as BigDecimal
                injury.hospitalDischargeDisposition = record.HospitalDischargeDisposition.text()
                injury.issLocal = record.IssLocal.text() as Integer
                injury.totalIcuLos = record.TotalIcuLos.text() as Integer
                injury.totalVentDays = record.TotalVentDays.text() as Integer
                
                injury.save(flush: true)
                
                // Import procedures
                record.HospitalProcedures?.item?.each { procItem ->
                    def procedure = new Procedure()
                    procedure.injury = injury
                    procedure.hospitalProcedureIcd10 = procItem.HospitalProcedureIcd10.text()
                    procedure.procedureStartDate = Date.parse('yyyy-MM-dd', procItem.HospitalProcedureStartDate.text())
                    procedure.procedureStartTime = procItem.HospitalProcedureStartTime.text()
                    procedure.save(flush: true)
                }
                
                // Import diagnoses
                record.DiagnosesIcd10?.item?.each { diagItem ->
                    def diagnosis = new Diagnosis()
                    diagnosis.injury = injury
                    diagnosis.diagnosisIcd10 = diagItem.DiagnosisIcd10.text()
                    diagnosis.save(flush: true)
                }
                
                recordsImported++
            }
            
            flash.message = "Successfully imported ${recordsImported} records"
            
        } catch (Exception e) {
            flash.error = "Error importing XML: ${e.message}"
            log.error("XML Import Error", e)
        }
        
        redirect action: 'index'
    }
}
