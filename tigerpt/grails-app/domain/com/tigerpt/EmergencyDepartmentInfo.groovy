package com.tigerpt

import java.time.LocalDate
import java.time.LocalTime
import com.tigerpt.domain.Patient

class EmergencyDepartmentInfo {

    // Activation and Arrival
    String highestActivation
    LocalDate traumaSurgeonArrivalDate
    LocalTime traumaSurgeonArrivalTime
    LocalDate edHospitalArrivalDate
    LocalTime edHospitalArrivalTime
    
    // Initial Vital Signs
    Integer initialSystolicBloodPressure
    Integer initialPulseRate
    BigDecimal initialTemperature
    Integer initialRespiratoryRate
    String initialRespiratoryAssistance
    Integer initialOxygenSaturation
    String initialSupplementalOxygen
    
    // Glasgow Coma Scale (GCS)
    Integer initialGcsEyes
    Integer initialGcsVerbal
    Integer initialGcsMotor
    Integer initialGcsTotal
    String initialGcsAssessmentQualifiers
    
    // GCS-40 (for pediatric patients)
    Integer initialGcs40Eyes
    Integer initialGcs40Verbal
    Integer initialGcs40Motor
    
    // Physical Measurements
    BigDecimal initialHeight
    BigDecimal initialWeight
    
    // Screening
    Boolean drugScreen
    Boolean alcoholScreen
    BigDecimal alcoholScreenResults
    
    // Primary Trauma Service
    String primaryTraumaServiceType
    
    static belongsTo = [patient: Patient]
    
    static constraints = {
        highestActivation nullable: true, maxSize: 100
        traumaSurgeonArrivalDate nullable: true
        traumaSurgeonArrivalTime nullable: true
        edHospitalArrivalDate nullable: true
        edHospitalArrivalTime nullable: true
        
        initialSystolicBloodPressure nullable: true, min: 0, max: 300
        initialPulseRate nullable: true, min: 0, max: 300
        initialTemperature nullable: true, scale: 2
        initialRespiratoryRate nullable: true, min: 0, max: 100
        initialRespiratoryAssistance nullable: true, maxSize: 255
        initialOxygenSaturation nullable: true, min: 0, max: 100
        initialSupplementalOxygen nullable: true, maxSize: 100
        
        initialGcsEyes nullable: true, min: 1, max: 4
        initialGcsVerbal nullable: true, min: 1, max: 5
        initialGcsMotor nullable: true, min: 1, max: 6
        initialGcsTotal nullable: true, min: 3, max: 15
        initialGcsAssessmentQualifiers nullable: true, maxSize: 255
        
        initialGcs40Eyes nullable: true, min: 1, max: 4
        initialGcs40Verbal nullable: true, min: 1, max: 5
        initialGcs40Motor nullable: true, min: 1, max: 6
        
        initialHeight nullable: true, scale: 2
        initialWeight nullable: true, scale: 2
        
        drugScreen nullable: true
        alcoholScreen nullable: true
        alcoholScreenResults nullable: true, scale: 3
        
        primaryTraumaServiceType nullable: true, maxSize: 100
    }
    
    static mapping = {
        table 'emergency_department_info'
        version false
    }
    
    String toString() {
        return "ED Info - GCS Total: ${initialGcsTotal}"
    }
}
