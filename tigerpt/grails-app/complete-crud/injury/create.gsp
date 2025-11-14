<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>${injury?.id ? 'Edit' : 'Create'} Injury</title>
</head>
<body>
    <h1>${injury?.id ? 'Edit' : 'Create'} Injury</h1>
    
    <g:if test="${injury?.errors}">
        <div class="alert alert-danger">
            <g:renderErrors bean="${injury}"/>
        </div>
    </g:if>
    
    <g:form action="${injury?.id ? 'update' : 'save'}">
        <g:if test="${injury?.id}">
            <g:hiddenField name="id" value="${injury.id}"/>
        </g:if>
        
        <fieldset>
            <legend>Patient & Incident Info</legend>
            
            <div class="form-group">
                <label>Patient *</label>
                <g:select name="patient.id" from="${com.tigerpt.domain.Patient.list()}" optionKey="id" 
                          optionValue="${{it.lastName + ', ' + it.firstName}}" 
                          value="${injury?.patient?.id}" class="form-control" required="true"
                          noSelection="['':'Select Patient...']"/>
            </div>
            
            <div class="form-group">
                <label>Injury Incident Date</label>
                <g:datePicker name="injuryIncidentDate" value="${injury?.injuryIncidentDate}" precision="day" years="${2000..2030}"/>
            </div>
            
            <div class="form-group">
                <label>Injury Incident Time</label>
                <g:datePicker name="injuryIncidentTime" value="${injury?.injuryIncidentTime}" precision="minute" noSelection="['':'']"/>
            </div>
            
            <div class="form-group">
                <label>Work Related</label>
                <g:checkBox name="workRelated" value="${injury?.workRelated}"/>
            </div>
            
            <div class="form-group">
                <label>ICD-10 Primary External Cause</label>
                <g:textField name="icd10PrimaryExternalCause" value="${injury?.icd10PrimaryExternalCause}" class="form-control"/>
            </div>
            
            <div class="form-group">
                <label>ICD-10 Place of Occurrence</label>
                <g:textField name="icd10PlaceOfOccurrence" value="${injury?.icd10PlaceOfOccurrence}" class="form-control"/>
            </div>
        </fieldset>
        
        <fieldset>
            <legend>Location</legend>
            
            <div class="form-group">
                <label>Incident ZIP Code</label>
                <g:textField name="incidentLocationZipCode" value="${injury?.incidentLocationZipCode}" class="form-control"/>
            </div>
            
            <div class="form-group">
                <label>Incident City</label>
                <g:textField name="incidentCity" value="${injury?.incidentCity}" class="form-control"/>
            </div>
            
            <div class="form-group">
                <label>Incident State</label>
                <g:textField name="incidentState" value="${injury?.incidentState}" class="form-control"/>
            </div>
            
            <div class="form-group">
                <label>Incident County</label>
                <g:textField name="incidentCounty" value="${injury?.incidentCounty}" class="form-control"/>
            </div>
        </fieldset>
        
        <fieldset>
            <legend>Transport</legend>
            
            <div class="form-group">
                <label>Transport Mode</label>
                <g:textField name="transportMode" value="${injury?.transportMode}" class="form-control"/>
            </div>
            
            <div class="form-group">
                <label>Inter-Facility Transfer</label>
                <g:checkBox name="interFacilityTransfer" value="${injury?.interFacilityTransfer}"/>
            </div>
            
            <div class="form-group">
                <label>Pre-Hospital Cardiac Arrest</label>
                <g:checkBox name="preHospitalCardiacArrest" value="${injury?.preHospitalCardiacArrest}"/>
            </div>
        </fieldset>
        
        <fieldset>
            <legend>ED Arrival & Vitals</legend>
            
            <div class="form-group">
                <label>ED Hospital Arrival Date</label>
                <g:datePicker name="edHospitalArrivalDate" value="${injury?.edHospitalArrivalDate}" precision="day" years="${2000..2030}"/>
            </div>
            
            <div class="form-group">
                <label>Systolic BP</label>
                <g:field type="number" name="initialEdSystolicBP" value="${injury?.initialEdSystolicBP}" class="form-control"/>
            </div>
            
            <div class="form-group">
                <label>Pulse Rate</label>
                <g:field type="number" name="initialEdPulseRate" value="${injury?.initialEdPulseRate}" class="form-control"/>
            </div>
            
            <div class="form-group">
                <label>Temperature (°C)</label>
                <g:field type="number" name="initialEdTemperature" value="${injury?.initialEdTemperature}" step="0.1" class="form-control"/>
            </div>
            
            <div class="form-group">
                <label>Respiratory Rate</label>
                <g:field type="number" name="initialEdRespiratoryRate" value="${injury?.initialEdRespiratoryRate}" class="form-control"/>
            </div>
            
            <div class="form-group">
                <label>Oxygen Saturation (%)</label>
                <g:field type="number" name="initialEdOxygenSaturation" value="${injury?.initialEdOxygenSaturation}" class="form-control"/>
            </div>
        </fieldset>
        
        <fieldset>
            <legend>Glasgow Coma Scale</legend>
            
            <div class="form-group">
                <label>GCS Eyes (1-4)</label>
                <g:field type="number" name="initialEdGcsEyes" value="${injury?.initialEdGcsEyes}" min="1" max="4" class="form-control"/>
            </div>
            
            <div class="form-group">
                <label>GCS Verbal (1-5)</label>
                <g:field type="number" name="initialEdGcsVerbal" value="${injury?.initialEdGcsVerbal}" min="1" max="5" class="form-control"/>
            </div>
            
            <div class="form-group">
                <label>GCS Motor (1-6)</label>
                <g:field type="number" name="initialEdGcsMotor" value="${injury?.initialEdGcsMotor}" min="1" max="6" class="form-control"/>
            </div>
            
            <div class="form-group">
                <label>GCS Total (3-15)</label>
                <g:field type="number" name="initialEdGcsTotal" value="${injury?.initialEdGcsTotal}" min="3" max="15" class="form-control"/>
            </div>
        </fieldset>
        
        <fieldset>
            <legend>Physical Measurements</legend>
            
            <div class="form-group">
                <label>Height (cm)</label>
                <g:field type="number" name="initialEdHeight" value="${injury?.initialEdHeight}" step="0.1" class="form-control"/>
            </div>
            
            <div class="form-group">
                <label>Weight (kg)</label>
                <g:field type="number" name="initialEdWeight" value="${injury?.initialEdWeight}" step="0.1" class="form-control"/>
            </div>
        </fieldset>
        
        <fieldset>
            <legend>Screening</legend>
            
            <div class="form-group">
                <label>Drug Screen</label>
                <g:textField name="drugScreen" value="${injury?.drugScreen}" class="form-control"/>
            </div>
            
            <div class="form-group">
                <label>Alcohol Screen</label>
                <g:textField name="alcoholScreen" value="${injury?.alcoholScreen}" class="form-control"/>
            </div>
            
            <div class="form-group">
                <label>Alcohol Screen Results</label>
                <g:field type="number" name="alcoholScreenResults" value="${injury?.alcoholScreenResults}" step="0.001" class="form-control"/>
            </div>
        </fieldset>
        
        <fieldset>
            <legend>Discharge</legend>
            
            <div class="form-group">
                <label>ED Discharge Disposition</label>
                <g:textField name="edDischargeDisposition" value="${injury?.edDischargeDisposition}" class="form-control"/>
            </div>
            
            <div class="form-group">
                <label>ED Discharge Date</label>
                <g:datePicker name="edDischargeDate" value="${injury?.edDischargeDate}" precision="day" years="${2000..2030}" noSelection="['':'']"/>
            </div>
        </fieldset>
        
        <button type="submit" class="btn btn-primary">${injury?.id ? 'Update' : 'Create'}</button>
        <g:link action="index" class="btn btn-secondary">Cancel</g:link>
    </g:form>
</body>
</html>
