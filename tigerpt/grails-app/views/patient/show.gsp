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
            <th>Patient ID:</th>
            <td>${patient.patientId}</td>
        </tr>
        <tr>
            <th>Medical Record:</th>
            <td>${patient.medicalRecordNumber}</td>
        </tr>
        <tr>
            <th>Name:</th>
            <td>${patient.patientLastName}, ${patient.patientFirstName} ${patient.patientMiddleName}</td>
        </tr>
        <tr>
            <th>SSN:</th>
            <td>${patient.socialSecurityNumber}</td>
        </tr>
        <tr>
            <th>Date of Birth:</th>
            <td><g:formatDate date="${patient.dateOfBirth}" format="yyyy-MM-dd"/></td>
        </tr>
        <tr>
            <th>Age:</th>
            <td>${patient.age} ${patient.ageUnits}</td>
        </tr>
        <tr>
            <th>Sex:</th>
            <td>${patient.sex == '1' ? 'Male' : patient.sex == '2' ? 'Female' : 'Other'}</td>
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
            <td>${patient.homeZip}, ${patient.homeState}, ${patient.homeCounty}</td>
        </tr>
    </table>
    
    <g:link action="edit" id="${patient.id}" class="btn btn-primary">Edit</g:link>
    <g:link action="index" class="btn btn-secondary">Back to List</g:link>
    <g:form action="delete" id="${patient.id}" style="display:inline">
        <button type="submit" class="btn btn-danger" onclick="return confirm('Delete patient?')">Delete</button>
    </g:form>
    
    <h2>Related Records</h2>
    <g:if test="${patient.injuries}">
        <h3>Injuries</h3>
        <ul>
            <g:each in="${patient.injuries}" var="injury">
                <li><g:link controller="injury" action="show" id="${injury.id}">${injury.incidentDate}</g:link></li>
            </g:each>
        </ul>
    </g:if>
</body>
</html>
