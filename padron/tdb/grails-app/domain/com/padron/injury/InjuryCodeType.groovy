package com.padron.injury

class InjuryCodeType {

    String code
}
/*
Description
Diagnoses related to all identified injuries.
Element Values
    • Injury diagnoses as defined by ICD-10-CM code range S00-S99, T07, T14, T79.A1-T79.A9 OR
    compatible ICD-10-CA code range
    • The maximum number of diagnoses that may be reported for an individual patient is 50
Additional Information
    • ICD-10-CM codes pertaining to other medical conditions (e.g., CVA, MI, co-morbidities, etc.)
may also be included in this element.
Data Source Hierarch y Guide
    1. Autopsy/Medical Examiner Report
    2. Operative Reports
    3. Radiology Reports
    4. Physician Notes/Flow Sheet
    5. Trauma Flow Sheet
    6. History and Physical
    7. Nursing Notes/Flow Sheet
    8. Progress Notes
    9. Discharge Summary
Associated Edit Checks
Rule ID Level Message
8701 1 Invalid value (ICD-10-CM only)
8702 2 Element cannot be blank
8703 2 At least one diagnosis must be provided and meet inclusion criteria. (ICD-10-
CM only)
8705 1 Invalid value (ICD-10-CA only)
8706 2 At least one diagnosis must be provided and meet inclusion criteria. (ICD-10-
CA only)
8707 2 Element cannot be “Not Applicable” or “Not Known/Not Recorded” along
with any other value
8750 1 Multiple Entry Max exceeded

 */