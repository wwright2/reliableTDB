<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Injury Details</title>
</head>
<body>
    <h1>Injury Details #${injury.id}</h1>
    
    <div class="card mb-3">
        <div class="card-header">Patient & Incident Information</div>
        <div class="card-body">
            <table class="table">
                <tr>
                    <th>Patient:</th>
                    <td><g:link controller="patient" action="show" id="${injury.patient?.id}">${injury.patient}</g:link></td>
                </tr>
                <tr>
                    <th>Incident Date:</th>
                    <td><g:formatDate date="${injury.injuryIncidentDate}" format="yyyy-MM-dd"/></td>
                </tr>
                <tr>
                    <th>Work Related:</th>
                    <td>${injury.workRelated ? 'Yes' : 'No'}</td>
                </tr>
                <tr>
                    <th>ICD-10 External Cause:</th>
                    <td>${injury.icd10PrimaryExternalCause}</td>
                </tr>
                <tr>
                    <th>Place of Occurrence:</th>
                    <td>${injury.icd10PlaceOfOccurrence}</td>
                </tr>
            </table>
        </div>
    </div>
    
    <div class="card mb-3">
        <div class="card-header">ED Arrival & Vitals</div>
        <div class="card-body">
            <table class="table">
                <tr>
                    <th>ED Arrival:</th>
                    <td><g:formatDate date="${injury.edHospitalArrivalDate}" format="yyyy-MM-dd HH:mm"/></td>
                </tr>
                <tr>
                    <th>Blood Pressure:</th>
                    <td>${injury.initialEdSystolicBP}/${injury.initialEdPulseRate} mmHg</td>
                </tr>
                <tr>
                    <th>Pulse Rate:</th>
                    <td>${injury.initialEdPulseRate} bpm</td>
                </tr>
                <tr>
                    <th>Temperature:</th>
                    <td>${injury.initialEdTemperature} °C</td>
                </tr>
                <tr>
                    <th>Respiratory Rate:</th>
                    <td>${injury.initialEdRespiratoryRate} /min</td>
                </tr>
                <tr>
                    <th>O2 Saturation:</th>
                    <td>${injury.initialEdOxygenSaturation}%</td>
                </tr>
            </table>
        </div>
    </div>
    
    <div class="card mb-3">
        <div class="card-header">Glasgow Coma Scale</div>
        <div class="card-body">
            <table class="table">
                <tr>
                    <th>Eyes:</th>
                    <td>${injury.initialEdGcsEyes}/4</td>
                </tr>
                <tr>
                    <th>Verbal:</th>
                    <td>${injury.initialEdGcsVerbal}/5</td>
                </tr>
                <tr>
                    <th>Motor:</th>
                    <td>${injury.initialEdGcsMotor}/6</td>
                </tr>
                <tr>
                    <th>Total:</th>
                    <td><strong>${injury.initialEdGcsTotal}/15</strong></td>
                </tr>
            </table>
        </div>
    </div>
    
    <div class="card mb-3">
        <div class="card-header">Physical Measurements</div>
        <div class="card-body">
            <table class="table">
                <tr>
                    <th>Height:</th>
                    <td>${injury.initialEdHeight} cm</td>
                </tr>
                <tr>
                    <th>Weight:</th>
                    <td>${injury.initialEdWeight} kg</td>
                </tr>
            </table>
        </div>
    </div>
    
    <div class="card mb-3">
        <div class="card-header">Screening</div>
        <div class="card-body">
            <table class="table">
                <tr>
                    <th>Drug Screen:</th>
                    <td>${injury.drugScreen ?: 'Not Performed'}</td>
                </tr>
                <tr>
                    <th>Alcohol Screen:</th>
                    <td>${injury.alcoholScreen ?: 'Not Performed'}</td>
                </tr>
                <tr>
                    <th>Alcohol Results:</th>
                    <td>${injury.alcoholScreenResults}</td>
                </tr>
            </table>
        </div>
    </div>
    
    <div class="btn-group">
        <g:link action="edit" id="${injury.id}" class="btn btn-primary">Edit</g:link>
        <g:link action="index" class="btn btn-secondary">Back to List</g:link>
        <g:form action="delete" id="${injury.id}" style="display:inline">
            <button type="submit" class="btn btn-danger" onclick="return confirm('Delete injury?')">Delete</button>
        </g:form>
    </div>
    
    <h2 class="mt-4">Diagnoses</h2>
    <g:if test="${injury.diagnoses}">
        <table class="table">
            <thead>
                <tr>
                    <th>ICD-10</th>
                    <th>AIS Code</th>
                    <th>Severity</th>
                    <th>Body Region</th>
                </tr>
            </thead>
            <tbody>
                <g:each in="${injury.diagnoses}" var="diagnosis">
                    <tr>
                        <td>${diagnosis.icd10InjuryDiagnosis}</td>
                        <td>${diagnosis.aisCode}</td>
                        <td>${diagnosis.aisSeverity}</td>
                        <td>${diagnosis.bodyRegion}</td>
                    </tr>
                </g:each>
            </tbody>
        </table>
    </g:if>
    <g:else>
        <p>No diagnoses recorded.</p>
    </g:else>
</body>
</html>
