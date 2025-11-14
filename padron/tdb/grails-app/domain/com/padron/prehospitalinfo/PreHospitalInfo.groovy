package com.padron.prehospitalinfo;

import com.padron.Affirmation;

public class PreHospitalInfo {

    TransportModeType       transport;      // single entry ;The mode of transport delivering the patient to your hospital.
    List<TransportModeType> otherTrasport;  // other max=5 entries.

    String emsUuid;     //Must be represented in canonical form, matching the following regular expression:
                        // [a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[1-5][a-fA-F0-9]{3}-[89abAB][a-fA-F0-9]{3}-[a-fA-F0-9]{12}
                        // The universally unique identifier (UUID) of the patient care report (PCR) of each emergency
                        //service (EMS) unit treating the patient from the time of injury to arrival at your ED/hospital.
                        //The null value "Not Applicable" must be reported if the patient was never transported via
                        //  EMS prior to arrival at your hospital.

    Affirmation interFacilityTransfer; // single entry ;Indicates whether the patient was transferred from another facility.
    Affirmation preHospitalCardiacArrest; // single entry ;Indicates whether the patient experienced a pre-hospital cardiac arrest.



}
