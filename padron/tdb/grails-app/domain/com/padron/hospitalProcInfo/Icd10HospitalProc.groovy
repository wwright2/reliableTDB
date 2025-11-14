package com.padron.hospitalProcInfo

import com.padron.Address

import java.sql.Time

class Icd10HospitalProc {

    static hasMany = [codes: Icd10HospitalProcCode]

    // codes
    //  • Major and minor procedure ICD-10 PCS or ICD-10 CA procedure codes
    //  • The maximum number of procedures that may be reported for a patient is 200
}

/*
Additional Information
• Only report procedures performed at your institution.
• Report all procedures performed in the operating room.
• Report all procedures in the ED, ICU, ward, or radiology department that were essential
to the diagnosis, stabilization, or treatment of the patient’s specific injuries or their
complications.
• Procedures with an asterisk have the potential to be performed multiple times during one
episode of hospitalization. In this case, report only the first event. If there is no asterisk,
report each event even if there is more than one.
• Note that the hospital may report additional procedures.
• Report the null value “Not Applicable” if the patient did not have procedures.
DIAGNOSTIC AND THERAPEUTIC IMAGING
Computerized tomographic Head *
Computerized tomographic Chest *
Computerized tomographic Abdomen *
Computerized tomographic Pelvis *
Computerized tomographic C-Spine *
Computerized tomographic T-Spine *
Computerized tomographic L-Spine *
Doppler ultrasound of extremities *
Diagnostic ultrasound (includes FAST) *
Angioembolization
Angiography
IVC filter
REBOA
Diagnostic imaging interventions on the total
body
Plain radiography of whole body
Plain radiography of whole skeleton
Plain radiography of infant whole body
CARDIOVASCULAR
Open cardiac massage
CPR
CNS
Insertion of ICP monitor *
Ventriculostomy
Cerebral oxygen monitoring *
GENITOURINARY
Ureteric catheterization (i.e. Ureteric stent)
Suprapubic cystostomy
MUSCULOSKETETAL
Soft tissue/bony debridement *
Closed reduction of fractures
Skeletal and halo traction
Fasciotomy
HOSPITAL PROCEDURE INFORMATION PAGE 64
TRANSFUSION
Transfusion of red cells * (only report first 24
hours after hospital arrival)
Transfusion of platelets * (only report first
24 hours after hospital arrival)
Transfusion of plasma * (only report first 24
hours after hospital arrival)
RESPIRATORY
Insertion of endotracheal tube * (exclude
intubations performed in the OR)
Continuous mechanical ventilation *
Chest tube *
Bronchoscopy *
Tracheostomy
GASTROINTESTINAL
Endoscopy (includes gastroscopy, sigmoidoscopy,
colonoscopy)
Gastrostomy/jejunostomy (percutaneous or
endoscopic)
Percutaneous (endoscopic)
gastrojejunoscopy
Data Source Hierarch y Guide
1. Operative Reports
2. Procedure Notes
3. Trauma Flow Sheet
4. ED Record
5. Nursing Notes/Flow Sheet
6. Radiology Reports
7. Discharge Summary
Associated Edit Chec ks
Rule ID Level Message
8801 1 Invalid Value (ICD-10 PCS only)
8803 2 Element cannot be blank
8804 2 Element must not be “Not Applicable” or “Not Known/Not Recorded” along
with any other value
8805 1 Invalid value (ICD-10-CA only)
8850 1 Multiple Entry Max exceeded
 */

/*
Description
The time operative and selected non-operative procedures were performed.
Element Values
• Relevant values for data element
Additional Information
• Reported as HHMM military time.
• Procedure start time is defined as the time the incision was made (or the procedure started).
Data Source Hierarch y Guide
1. Operative Reports
2. Anesthesia Record
3. Procedure Notes
4. Trauma Flow Sheet
5. ED Record
6. Nursing Notes/Flow Sheet
7. Radiology Reports
8. Discharge Summary
Associated Edit Chec ks
Rule ID Level Message
6701 1 Time is not valid
6702 1 Time out of range
6706 3 Hospital Procedure Start Time is earlier than ED/Hospital Arrival Time
6708 2 Element cannot be blank
6709 2 Element must be and can only be “Not Applicable” when Hospital Procedure
Start Date is “Not Applicable”
6710 2 Element must be “Not Known/Not Recorded” when Hospital Procedure
Start Date is “Not Known/Not Recorded”
6750 1 Multiple Entry Max exceeded
 */