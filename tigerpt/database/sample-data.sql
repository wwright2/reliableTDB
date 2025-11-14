-- TigerPT Sample Data
-- Insert sample trauma patient records for testing

USE tigerpt_dev;

-- Sample Patient 1: Motor Vehicle Accident
INSERT INTO patient (
    home_zip_postal_code, home_country, home_state, home_city,
    date_of_birth, age, age_units, race, ethnicity, sex,
    transport_mode, inter_facility_transfer, pre_hospital_cardiac_arrest,
    hypertension, diabetes_mellitus, current_smoker
) VALUES (
    '75080', 'USA', 'Texas', 'Richardson',
    '1978-05-15', 45, 'Years', 'White', 'Not Hispanic', 'Male',
    'Ground Ambulance', FALSE, FALSE,
    TRUE, FALSE, TRUE
);

SET @patient1_id = LAST_INSERT_ID();

-- Injury Information for Patient 1
INSERT INTO injury_information (
    injury_incident_date, injury_incident_time, work_related,
    primary_external_cause_code, place_of_occurrence_code,
    incident_location_zip_postal_code, incident_state, incident_city,
    protective_devices, airbag_deployment,
    patient_id
) VALUES (
    '2023-10-15', '14:30:00', FALSE,
    'V43.52XA', 'Y92.411',
    '75080', 'Texas', 'Richardson',
    'Seat belt', 'Deployed',
    @patient1_id
);

-- ED Info for Patient 1
INSERT INTO emergency_department_info (
    highest_activation, ed_hospital_arrival_date, ed_hospital_arrival_time,
    initial_systolic_blood_pressure, initial_pulse_rate, initial_temperature,
    initial_respiratory_rate, initial_oxygen_saturation,
    initial_gcs_eyes, initial_gcs_verbal, initial_gcs_motor, initial_gcs_total,
    initial_height, initial_weight,
    drug_screen, alcohol_screen, alcohol_screen_results,
    primary_trauma_service_type,
    patient_id
) VALUES (
    'Full Trauma Team', '2023-10-15', '15:05:00',
    120, 88, 98.6,
    16, 98,
    4, 5, 6, 15,
    180.5, 85.0,
    TRUE, TRUE, 0.02,
    'Trauma Surgery',
    @patient1_id
);

-- Disposition for Patient 1
INSERT INTO disposition (
    ed_discharge_disposition, ed_discharge_date, ed_discharge_time,
    patient_id
) VALUES (
    'Admitted to ICU', '2023-10-15', '17:30:00',
    @patient1_id
);

-- Hospital Procedure for Patient 1
INSERT INTO hospital_procedure (
    icd10_code, procedure_description,
    procedure_start_date, procedure_start_time,
    patient_id
) VALUES (
    '0W9G30Z', 'Drainage of Peritoneal Cavity',
    '2023-10-15', '18:00:00',
    @patient1_id
);

-- Sample Patient 2: Fall from Height
INSERT INTO patient (
    home_zip_postal_code, home_country, home_state, home_city,
    date_of_birth, age, age_units, race, ethnicity, sex,
    transport_mode, inter_facility_transfer, pre_hospital_cardiac_arrest,
    hypertension, congestive_heart_failure, functionally_dependent
) VALUES (
    '75082', 'USA', 'Texas', 'Richardson',
    '1950-08-22', 73, 'Years', 'Black', 'Not Hispanic', 'Female',
    'Helicopter', FALSE, FALSE,
    TRUE, TRUE, TRUE
);

SET @patient2_id = LAST_INSERT_ID();

-- Injury Information for Patient 2
INSERT INTO injury_information (
    injury_incident_date, injury_incident_time, work_related,
    primary_external_cause_code, place_of_occurrence_code,
    incident_location_zip_postal_code, incident_state, incident_city,
    patient_id
) VALUES (
    '2023-10-18', '10:15:00', FALSE,
    'W19.XXXA', 'Y92.009',
    '75082', 'Texas', 'Richardson',
    @patient2_id
);

-- ED Info for Patient 2
INSERT INTO emergency_department_info (
    highest_activation, ed_hospital_arrival_date, ed_hospital_arrival_time,
    initial_systolic_blood_pressure, initial_pulse_rate, initial_temperature,
    initial_respiratory_rate, initial_oxygen_saturation,
    initial_gcs_eyes, initial_gcs_verbal, initial_gcs_motor, initial_gcs_total,
    initial_height, initial_weight,
    drug_screen, alcohol_screen,
    primary_trauma_service_type,
    patient_id
) VALUES (
    'Full Trauma Team', '2023-10-18', '11:30:00',
    95, 110, 98.2,
    22, 92,
    3, 4, 5, 12,
    165.0, 68.5,
    FALSE, FALSE,
    'Trauma Surgery',
    @patient2_id
);

-- Disposition for Patient 2
INSERT INTO disposition (
    ed_discharge_disposition, ed_discharge_date, ed_discharge_time,
    patient_id
) VALUES (
    'Admitted to Floor', '2023-10-18', '13:45:00',
    @patient2_id
);

-- Sample Patient 3: Gunshot Wound
INSERT INTO patient (
    home_zip_postal_code, home_country, home_state, home_city,
    date_of_birth, age, age_units, race, ethnicity, sex,
    transport_mode, inter_facility_transfer, pre_hospital_cardiac_arrest,
    current_smoker, alcohol_use_disorder
) VALUES (
    '75081', 'USA', 'Texas', 'Dallas',
    '1995-03-10', 28, 'Years', 'Hispanic', 'Hispanic', 'Male',
    'Ground Ambulance', FALSE, TRUE,
    TRUE, TRUE
);

SET @patient3_id = LAST_INSERT_ID();

-- Injury Information for Patient 3
INSERT INTO injury_information (
    injury_incident_date, injury_incident_time, work_related,
    primary_external_cause_code, place_of_occurrence_code,
    incident_location_zip_postal_code, incident_state, incident_city,
    patient_id
) VALUES (
    '2023-10-20', '22:45:00', FALSE,
    'X95.9XXA', 'Y92.29',
    '75081', 'Texas', 'Dallas',
    @patient3_id
);

-- ED Info for Patient 3
INSERT INTO emergency_department_info (
    highest_activation, ed_hospital_arrival_date, ed_hospital_arrival_time,
    initial_systolic_blood_pressure, initial_pulse_rate, initial_temperature,
    initial_respiratory_rate, initial_oxygen_saturation, initial_respiratory_assistance,
    initial_gcs_eyes, initial_gcs_verbal, initial_gcs_motor, initial_gcs_total,
    initial_height, initial_weight,
    drug_screen, alcohol_screen, alcohol_screen_results,
    primary_trauma_service_type,
    patient_id
) VALUES (
    'Full Trauma Team', '2023-10-20', '23:10:00',
    70, 135, 97.8,
    28, 88, 'Intubated',
    1, 1, 4, 6,
    175.0, 78.0,
    TRUE, TRUE, 0.18,
    'Trauma Surgery',
    @patient3_id
);

-- Disposition for Patient 3
INSERT INTO disposition (
    ed_discharge_disposition, ed_discharge_date, ed_discharge_time,
    patient_id
) VALUES (
    'To Operating Room', '2023-10-20', '23:45:00',
    @patient3_id
);

-- Hospital Procedures for Patient 3
INSERT INTO hospital_procedure (
    icd10_code, procedure_description,
    procedure_start_date, procedure_start_time,
    patient_id
) VALUES 
(
    '0W9G40Z', 'Drainage of Peritoneal Cavity',
    '2023-10-21', '00:30:00',
    @patient3_id
),
(
    '02YA0Z2', 'Transfusion of Blood Products',
    '2023-10-21', '00:15:00',
    @patient3_id
);

-- Verify data
SELECT 'Patient Count:' as Info, COUNT(*) as Count FROM patient;
SELECT 'Injury Info Count:' as Info, COUNT(*) as Count FROM injury_information;
SELECT 'ED Info Count:' as Info, COUNT(*) as Count FROM emergency_department_info;
SELECT 'Disposition Count:' as Info, COUNT(*) as Count FROM disposition;
SELECT 'Procedure Count:' as Info, COUNT(*) as Count FROM hospital_procedure;

-- Display sample data
SELECT 
    p.id,
    p.age,
    p.sex,
    p.home_city,
    i.injury_incident_date,
    i.primary_external_cause_code,
    e.initial_gcs_total,
    d.ed_discharge_disposition
FROM patient p
LEFT JOIN injury_information i ON i.patient_id = p.id
LEFT JOIN emergency_department_info e ON e.patient_id = p.id
LEFT JOIN disposition d ON d.patient_id = p.id
ORDER BY p.id;
