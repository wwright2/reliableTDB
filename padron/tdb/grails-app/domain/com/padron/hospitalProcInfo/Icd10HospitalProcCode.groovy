package com.padron.hospitalProcInfo

import antlr.actions.python.CodeLexerTokenTypes

import java.sql.Time

class Icd10HospitalProcCode {

    String      topic;   // Hospital Procedure Information
                        // DIAGNOSTIC AND THERAPEUTIC IMAGING
                        // CARDIOVASCULAR,  CNS, GENITOURINARY
                        // MUSCULOSKETETAL, TRANSFUSION,RESPIRATORY,GASTROINTESTINAL

    String      code;    // ICD-10-PCS codeElement Values
                            // • Major and minor procedure ICD-10 PCS or ICD-10 CA procedure codes
                            // • The maximum number of procedures that may be reported for a patient is 200

    Icd10CodeType   codes; // 1. ICD-10-PCS 2. ICD-10-CA
    Time            startTime;   // Start time of the procedure
}
