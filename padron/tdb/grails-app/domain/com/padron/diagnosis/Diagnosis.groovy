package com.padron.diagnosis

import com.padron.injury.InjuryCodeType

class Diagnosis {

    static hasMany = [codes: InjuryCodeType]

    List<InjuryCodeType>    codes   //max 50
    String                  aisCode //The code is the 8-digit AIS code,The Abbreviated Injury Scale (AIS) code(s) that reflect the patient's injuries.

    Integer                 aisCodeVersion // 05, Update 08, or AIS 2015 codes
}


/*
Description
The Abbreviated Injury Scale (AIS) code(s) that reflect the patient's injuries.
Element Values
• The code is the 8-digit AIS code
Additional Information
None
Data Source Hierarch y Guide
1. AIS Coding Manual
Associated Edit Chec ks
Rule ID Level Message
21001 1 Invalid value
21004 2 AIS codes submitted are not valid AIS 05, Update 08, or AIS 2015 codes
21007 2 Element cannot be blank
21008 2 Element cannot be “Not Applicable”
21009 2 Element cannot be “Not Known/Not Recorded” along with any other value
21050 1 Multiple Entry Max exceeded
 */