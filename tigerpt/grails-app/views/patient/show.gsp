<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Patient Details</title>
</head>
<body>
    <h1>Patient Details</h1>
    
    <table class="table">
        <tr>
            <th>ID:</th>
            <td>${patient.id}</td>
        </tr>
        <tr>
            <th>Medical Record:</th>
            <td>${patient.medicalRecordNumber}</td>
        </tr>
        <tr>
            <th>Name:</th>
            <td>${patient.lastName}, ${patient.firstName} ${patient.middleName ?: ''}</td>
        </tr>
        <tr>
            <th>Date of Birth:</th>
            <td><g:formatDate date="${patient.dateOfBirth}" format="yyyy-MM-dd"/></td>
        </tr>
        <tr>
            <th>Age:</th>
            <td>${patient.age} ${patient.ageUnits ?: ''}</td>
        </tr>
        <tr>
            <th>Sex:</th>
            <td>${patient.sex}</td>
        </tr>
        <tr>
            <th>Race:</th>
            <td>${patient.race}</td>
        </tr>
        <tr>
            <th>Ethnicity:</th>
            <td>${patient.ethnicity}</td>
        </tr>
        <tr>
            <th>Address:</th>
            <td>
                ${patient.homeCity ?: ''}, ${patient.homeState ?: ''} ${patient.homeZipCode ?: ''}<br/>
                ${patient.homeCounty ?: ''}, ${patient.homeCountry ?: ''}
            </td>
        </tr>
        <tr>
            <th>Alternate Residence:</th>
            <td>${patient.alternateHomeResidence ?: 'N/A'}</td>
        </tr>
    </table>
    
    <div class="btn-group">
        <g:link action="edit" id="${patient.id}" class="btn btn-primary">Edit</g:link>
        <g:link action="index" class="btn btn-secondary">Back to List</g:link>
        <g:form action="delete" id="${patient.id}" style="display:inline">
            <button type="submit" class="btn btn-danger" onclick="return confirm('Delete patient?')">Delete</button>
        </g:form>
    </div>
    
    <h2 class="mt-4">Related Records</h2>
    
    <g:if test="${patient.injuries}">
        <h3>Injuries (${patient.injuries.size()})</h3>
        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Incident Date</th>
                    <th>Trauma Type</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <g:each in="${patient.injuries}" var="injury">
                    <tr>
                        <td>${injury.id}</td>
                        <td><g:formatDate date="${injury.incidentDate}" format="yyyy-MM-dd"/></td>
                        <td>${injury.traumaType}</td>
                        <td><g:link controller="injury" action="show" id="${injury.id}">View</g:link></td>
                    </tr>
                </g:each>
            </tbody>
        </table>
    </g:if>
    <g:else>
        <p>No injuries recorded.</p>
    </g:else>
    
    <g:if test="${patient.procedures}">
        <h3>Procedures (${patient.procedures.size()})</h3>
        <ul>
            <g:each in="${patient.procedures}" var="procedure">
                <li>${procedure.hospitalProcedureIcd10} - <g:formatDate date="${procedure.procedureStartDate}" format="yyyy-MM-dd"/></li>
            </g:each>
        </ul>
    </g:if>
    
    <g:if test="${patient.preExistingConditions}">
        <h3>Pre-Existing Conditions (${patient.preExistingConditions.size()})</h3>
        <ul>
            <g:each in="${patient.preExistingConditions}" var="condition">
                <li>${condition.conditionName}</li>
            </g:each>
        </ul>
    </g:if>
    
    <g:if test="${patient.hospitalEvents}">
        <h3>Hospital Events (${patient.hospitalEvents.size()})</h3>
        <ul>
            <g:each in="${patient.hospitalEvents}" var="event">
                <li>${event.eventType} - <g:formatDate date="${event.eventDate}" format="yyyy-MM-dd"/></li>
            </g:each>
        </ul>
    </g:if>
</body>
</html>
