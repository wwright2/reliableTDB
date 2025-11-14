package com.padron

import com.padron.injury.*
import com.padron.emergencyDeptInfo.*


class Patient {

    static hasOne = [person: Person, traumaQualityImprovement: TraumaQualityImprovement, surgeonSpecReportOptional: SurgeonSpecReportOptional]
    static hasMany = [injury: Injury, injuryIncident: InjuryIncident, injuryIncidentLocation: InjuryIncidentLocation, injuryIncidentLocationType: InjuryIncidentLocationType, injuryIncidentType: InjuryIncidentType, injuryIntent: InjuryIntent, injuryIntentType: InjuryIntentType, injuryMechanism: InjuryMechanism, injuryMechanismType: InjuryMechanismType, injuryPlace: InjuryPlace, injuryPlaceType: InjuryPlaceType, injuryPreventability: InjuryPreventability, injuryPreventabilityType: InjuryPreventabilityType, injurySeverity: InjurySeverity, injurySeverityType: InjurySeverityType, injuryType: InjuryType, injuryTypeType: InjuryTypeType, injuryWorkRelated: InjuryWorkRelated
      ]

}
