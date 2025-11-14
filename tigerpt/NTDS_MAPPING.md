# TigerPT - NTDS Data Dictionary Mapping

This document maps the National Trauma Data Standard (NTDS) 2023 data elements to the TigerPT domain model.

## Domain Model Overview

The TigerPT application implements the NTDS 2023 specification through the following domain classes:

### 1. Patient Domain (Primary Entity)

**Purpose**: Stores patient demographic information and pre-existing conditions

**NTDS Sections Covered**:
- Demographic Information (elements 1-12)
- Pre-Hospital Information (elements 29-33)
- Pre-Existing Conditions (elements 67-94)

**Key Fields**:

| Domain Field | NTDS Element | Description |
|--------------|--------------|-------------|
| homeZipPostalCode | Patient's Home Zip/Postal Code | Patient residence postal code |
| homeCountry | Patient's Home Country | Country of residence |
| homeState | Patient's Home State | State/province of residence |
| homeCounty | Patient's Home County | County of residence |
| homeCity | Patient's Home City | City of residence |
| dateOfBirth | Date of Birth | Patient's birth date |
| age | Age | Patient's age at time of injury |
| ageUnits | Age Units | Units (Years, Months, Days) |
| race | Race | Patient's race |
| ethnicity | Ethnicity | Patient's ethnicity |
| sex | Sex | Patient's biological sex |

**Pre-Existing Conditions** (Boolean fields):
- advanceDirectiveLimitingCare
- alcoholUseDisorder
- anticoagulantTherapy
- addAdhd (ADD/ADHD)
- bipolarDisorder
- bleedingDisorder
- cerebralVascularAccident (CVA)
- copd (Chronic Obstructive Pulmonary Disease)
- chronicRenalFailure
- cirrhosis
- congenitalAnomalies
- congestiveHeartFailure (CHF)
- currentSmoker
- currentlyReceivingChemotherapy
- dementia
- diabetesMellitus
- disseminatedCancer
- functionallyDependent
- hypertension
- majorDepressiveDisorder
- myocardialInfarction (MI)
- otherMentalDisorders
- peripheralArterialDisease (PAD)
- postTraumaticStressDisorder
- pregnancy
- prematurity
- schizoaffectiveDisorder
- schizophrenia

### 2. InjuryInformation Domain

**Purpose**: Captures injury-specific details and incident information

**NTDS Sections Covered**:
- Injury Information (elements 13-28)

**Key Fields**:

| Domain Field | NTDS Element | Description |
|--------------|--------------|-------------|
| injuryIncidentDate | Injury Incident Date | Date of injury |
| injuryIncidentTime | Injury Incident Time | Time of injury |
| workRelated | Work-Related | Whether injury occurred at work |
| occupationalIndustry | Patient's Occupational Industry | Industry classification |
| occupation | Patient's Occupation | Job/occupation |
| primaryExternalCauseCode | ICD-10 Primary External Cause Code | Primary cause of injury (ICD-10) |
| placeOfOccurrenceCode | ICD-10 Place of Occurrence External Cause Code | Where injury occurred |
| additionalExternalCauseCode | ICD-10 Additional External Cause Code | Additional cause codes |
| incidentLocationZipPostalCode | Incident Location Zip/Postal Code | Location postal code |
| incidentCountry | Incident Country | Country where injury occurred |
| incidentState | Incident State | State where injury occurred |
| incidentCounty | Incident County | County where injury occurred |
| incidentCity | Incident City | City where injury occurred |
| protectiveDevices | Protective Devices | Devices in use (helmet, seatbelt, etc.) |
| childSpecificRestraint | Child Specific Restraint | Child safety seat information |
| airbagDeployment | Airbag Deployment | Whether airbags deployed |

### 3. EmergencyDepartmentInfo Domain

**Purpose**: Stores emergency department assessment and vital signs

**NTDS Sections Covered**:
- Emergency Department Information (elements 34-62)

**Key Fields**:

| Domain Field | NTDS Element | Description |
|--------------|--------------|-------------|
| highestActivation | Highest Activation | Trauma team activation level |
| traumaSurgeonArrivalDate | Trauma Surgeon Arrival Date | When surgeon arrived |
| traumaSurgeonArrivalTime | Trauma Surgeon Arrival Time | Time surgeon arrived |
| edHospitalArrivalDate | ED/Hospital Arrival Date | ED arrival date |
| edHospitalArrivalTime | ED/Hospital Arrival Time | ED arrival time |
| initialSystolicBloodPressure | Initial ED/Hospital Systolic Blood Pressure | First BP reading (mmHg) |
| initialPulseRate | Initial ED/Hospital Pulse Rate | First pulse (bpm) |
| initialTemperature | Initial ED/Hospital Temperature | First temp (°F or °C) |
| initialRespiratoryRate | Initial ED/Hospital Respiratory Rate | First RR (breaths/min) |
| initialRespiratoryAssistance | Initial ED/Hospital Respiratory Assistance | Type of breathing support |
| initialOxygenSaturation | Initial ED/Hospital Oxygen Saturation | First O2 sat (%) |
| initialSupplementalOxygen | Initial ED/Hospital Supplemental Oxygen | O2 delivery method |

**Glasgow Coma Scale (GCS)**:
| Domain Field | NTDS Element | Description | Range |
|--------------|--------------|-------------|-------|
| initialGcsEyes | Initial ED/Hospital GCS-Eyes | Eye opening response | 1-4 |
| initialGcsVerbal | Initial ED/Hospital GCS-Verbal | Verbal response | 1-5 |
| initialGcsMotor | Initial ED/Hospital GCS-Motor | Motor response | 1-6 |
| initialGcsTotal | Initial ED/Hospital GCS-Total | Total GCS score | 3-15 |
| initialGcsAssessmentQualifiers | Initial ED/Hospital GCS-Assessment Qualifiers | Factors affecting assessment |

**GCS-40 (Pediatric)**:
| Domain Field | NTDS Element | Description | Range |
|--------------|--------------|-------------|-------|
| initialGcs40Eyes | Initial ED/Hospital GCS-40 Eyes | Pediatric eye response | 1-4 |
| initialGcs40Verbal | Initial ED/Hospital GCS-40 Verbal | Pediatric verbal response | 1-5 |
| initialGcs40Motor | Initial ED/Hospital GCS-40 Motor | Pediatric motor response | 1-6 |

**Physical Measurements & Screening**:
| Domain Field | NTDS Element | Description |
|--------------|--------------|-------------|
| initialHeight | Initial ED/Hospital Height | Height in cm |
| initialWeight | Initial ED/Hospital Weight | Weight in kg |
| drugScreen | Drug Screen | Whether drug screen performed |
| alcoholScreen | Alcohol Screen | Whether alcohol screen performed |
| alcoholScreenResults | Alcohol Screen Results | BAC level |
| primaryTraumaServiceType | Primary Trauma Service Type | Service managing patient |

### 4. Disposition Domain

**Purpose**: Records patient discharge information from ED

**NTDS Sections Covered**:
- Emergency Department Information (elements 59-61)

**Key Fields**:

| Domain Field | NTDS Element | Description |
|--------------|--------------|-------------|
| edDischargeDisposition | ED Discharge Disposition | Where patient went from ED |
| edDischargeDate | ED Discharge Date | Date left ED |
| edDischargeTime | ED Discharge Time | Time left ED |

**Common Disposition Values**:
- Admitted to ICU
- Admitted to Floor
- To Operating Room
- Transferred to Another Facility
- Discharged Home
- Expired in ED
- Left Against Medical Advice

### 5. HospitalProcedure Domain

**Purpose**: Tracks procedures performed on patient

**NTDS Sections Covered**:
- Hospital Procedure Information (elements 63-66)

**Key Fields**:

| Domain Field | NTDS Element | Description |
|--------------|--------------|-------------|
| icd10Code | ICD-10 Hospital Procedures | ICD-10-PCS procedure code |
| procedureDescription | Description | Human-readable description |
| procedureStartDate | Hospital Procedures Start Date | When procedure began |
| procedureStartTime | Hospital Procedure Start Time | Time procedure began |

**Relationship**: One patient can have many procedures (one-to-many)

## Database Schema

### Entity Relationships

```
Patient (1) -------- (1) InjuryInformation
   |
   |-------- (1) EmergencyDepartmentInfo
   |
   |-------- (1) Disposition
   |
   |-------- (0..n) HospitalProcedure
```

### Table Names

| Domain Class | Table Name |
|--------------|------------|
| Patient | patient |
| InjuryInformation | injury_information |
| EmergencyDepartmentInfo | emergency_department_info |
| Disposition | disposition |
| HospitalProcedure | hospital_procedure |

### Primary Keys

All tables use auto-generated `id` columns (BIGINT) as primary keys.

### Foreign Keys

- `injury_information.patient_id` → `patient.id`
- `emergency_department_info.patient_id` → `patient.id`
- `disposition.patient_id` → `patient.id`
- `hospital_procedure.patient_id` → `patient.id`

## Data Types Mapping

### NTDS Type → Grails/MySQL Type

| NTDS Type | Grails Type | MySQL Type | Notes |
|-----------|-------------|------------|-------|
| Date | LocalDate | DATE | ISO 8601 format |
| Time | LocalTime | TIME | 24-hour format |
| Boolean | Boolean | TINYINT(1) | 0/1 or NULL |
| Integer | Integer | INT | Numeric values |
| Decimal | BigDecimal | DECIMAL | For precise values |
| Text/String | String | VARCHAR | Variable length |
| Code | String | VARCHAR(20) | ICD-10 codes |

## NTDS Elements Not Yet Implemented

The following NTDS elements from the 2023 data dictionary are optional or not yet implemented:

### Optional Pre-Hospital Elements (Appendix 3)
- EMS Dispatch Date/Time
- EMS Unit Arrival Date/Time at Scene
- EMS Unit Departure Date/Time from Scene
- Initial Field Vitals (BP, Pulse, RR, O2 Sat)
- Initial Field GCS
- Trauma Triage Criteria

### Additional Elements for Future Implementation
- Hospital discharge information
- ICU admission/discharge dates
- Hospital complications
- Injury Severity Score (ISS)
- Abbreviated Injury Scale (AIS) codes
- Hospital outcome/mortality data
- Length of stay calculations
- Ventilator days
- Hospital charges/costs

## ICD-10 Code Reference

### External Cause Codes (Chapter 20)

Common codes used in trauma registry:

**Transport Accidents (V00-V99)**:
- V43.52XA - Car driver injured in collision with car
- V29.9XXA - Motorcycle rider injured in traffic accident

**Falls (W00-W19)**:
- W19.XXXA - Unspecified fall
- W06.XXXA - Fall from bed
- W10.XXXA - Fall on stairs

**Assault (X92-Y09)**:
- X95.9XXA - Assault by unspecified firearm
- X99.9XXA - Assault by sharp object

**Place of Occurrence Codes (Y92)**:
- Y92.009 - Unspecified place in home
- Y92.411 - Street and highway
- Y92.29 - Other specified residential institution

### Procedure Codes (ICD-10-PCS)

Format: 7 characters
- Character 1: Section
- Character 2: Body System
- Character 3: Root Operation
- Characters 4-7: Additional specificity

Example: 0W9G30Z
- 0: Medical and Surgical
- W: Anatomical Regions, General
- 9: Drainage
- G: Peritoneal Cavity
- 3: Percutaneous
- 0: Drainage Device
- Z: No Qualifier

## Compliance Notes

### HIPAA Considerations

Protected Health Information (PHI) stored in this system:
- Patient demographics (name, DOB, address)
- Medical record numbers
- Dates of service
- Clinical information

**Security Requirements**:
1. Implement authentication and authorization
2. Encrypt data in transit (SSL/TLS)
3. Encrypt data at rest
4. Maintain audit logs
5. Regular security assessments
6. Access controls and user permissions
7. Backup and disaster recovery

### NTDS Compliance

This implementation follows NTDS 2023 specifications for:
- Data element definitions
- Allowable values
- Data validation rules
- Null value handling

### Data Quality

Implement validation for:
- Required vs optional fields
- Value ranges (e.g., GCS 3-15)
- Date/time logic (e.g., arrival before discharge)
- Referential integrity
- ICD-10 code format validation

## Future Enhancements

1. **Data Import/Export**
   - CSV import functionality
   - HL7 interface
   - NEMSIS integration for EMS data
   - Export to NTDB format

2. **Reporting**
   - Custom report builder
   - Dashboard with key metrics
   - TQIP benchmarking reports
   - Outcome analysis

3. **Advanced Features**
   - Automatic ISS calculation
   - Predicted mortality (TRISS)
   - Real-time alerts
   - Mobile application
   - Integration with EHR systems

4. **Quality Improvement**
   - Data quality dashboards
   - Automated data validation
   - Compliance checking
   - Audit trail

## References

- NTDS Data Dictionary 2023, American College of Surgeons
- ICD-10-CM/PCS Official Guidelines
- NEMSIS (National EMS Information System)
- TQIP (Trauma Quality Improvement Program)
- ACS Committee on Trauma Resources

## Version History

- v1.0.0 (Current) - Initial implementation based on NTDS 2023
  - Core patient demographics
  - Injury information
  - ED information
  - Basic procedures
  - Pre-existing conditions

## Contact

For questions about NTDS implementation or data standards, consult:
- ACS Trauma Quality Programs
- Your facility's trauma program manager
- State trauma registry coordinator
