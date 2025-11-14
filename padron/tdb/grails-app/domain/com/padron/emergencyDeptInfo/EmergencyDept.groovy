package com.padron.emergencyDeptInfo;

import com.padron.Affirmation;

import java.sql.Time;

public class EmergencyDept {
    Affirmation  highestActivation; // single entry ;The highest level of activation of the emergency department (ED) during the patient's visit.
    Time         traumaSurgeonArrival;   //     The date the first trauma surgeon arrived at the patient’s bedside.
    Time         edHospitalArrival;   // The date the patient arrived at the ED/hospital.
    String      initialSystolicBloodPressure; // The initial systolic blood pressure of the patient upon arrival at the ED/hospital.
    Integer     pulseRate;  // value= 30-220; beat/minute.
    Integer     temperature; // value= 10-45 degree Celsius.
    Integer     respiratoryRate; // value= 5-60; breaths/minute.

    RespiratoryAssistanceType   respAssistance; // 1. Unassisted 2. Assisted
    Integer        initialOxygenSaturation; // 0-100; percent.
    SupplementalOxygenType   supplementalOxygen; // 1. None 2. Supplemental Oxygen

    GCS_EyesType    gcsEye;
    String          gcsEyeNote;

    GCS_VerbalType  gcsVerbal;  // 1. None 2. Incomprehensible sounds 3. Inappropriate words 4. Confused 5. Oriented
    String          gcsVerbalNote;

    GCS_MotorType   gcsMotor;   // 1. None 2. Extension to pain 3. Flexion to pain 4. Withdrawal from pain 5. Localizes to pain 6. Obeys commands
    String          gcsMotorNote;

    Integer         gcsTotal;   // 3-15; total score.
    String          gcsTotalNote;


    GCS_AssessmentType gcsAssessment;   // 1. Documentation of factors potentially affecting the first assessment of GCS within 30 minutes of ED/hospital arrival.
    String          gcsAssessmentNote; // Documentation of factors potentially affecting the first assessment of GCS within 30 minutes of ED/hospital arrival.

    GCS40_EyesType  gcs40Eyes; //
    GCS40_VerbalType gcs40Verbal;
    GCS40_MotorType  gcs40Motor;

    Integer         height; // 30-275  9ft.
    Integer         weight; // 1-650; kg.

    DrugScreenType  drugScreen; //
    Affirmation     alcoholScreen; // single entry ;Indicates whether the patient was screened for alcohol.
    Integer         bloodAlcoholLevel; //0.0-1.5  0-500; mg/dL.

    DischargeDispositionType    dischargeDisposition; // 1. Admitted

    Time    dischargeTime;
    PrimaryTraumaServiceType    primaryTraumaService; // 1. Trauma Surgery 2. Neurosurgery 3. Orthopedic Surgery 4. Cardiothoracic Surgery 5. General Surgery 6. Other Surgery 7. Other Specialty 8. Not Applicable




}




