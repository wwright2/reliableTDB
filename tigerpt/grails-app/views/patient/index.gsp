<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Patient List</title>
</head>
<body>
    <h1>Trauma Registry - Patients</h1>
    
    <g:link action="create" class="btn btn-primary">Add New Patient</g:link>
    
    <table class="table">
        <thead>
            <tr>
                <th>Patient ID</th>
                <th>Medical Record</th>
                <th>Name</th>
                <th>DOB</th>
                <th>SSN</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <g:each in="${patientList}" var="patient">
                <tr>
                    <td>${patient.patientId}</td>
                    <td>${patient.medicalRecordNumber}</td>
                    <td>
                        <g:link action="show" id="${patient.id}">
                            ${patient.patientLastName}, ${patient.patientFirstName} ${patient.patientMiddleName}
                        </g:link>
                    </td>
                    <td><g:formatDate date="${patient.dateOfBirth}" format="yyyy-MM-dd"/></td>
                    <td>${patient.socialSecurityNumber}</td>
                    <td>
                        <g:link action="edit" id="${patient.id}" class="btn btn-sm">Edit</g:link>
                        <g:form action="delete" id="${patient.id}" style="display:inline">
                            <button type="submit" class="btn btn-sm btn-danger" onclick="return confirm('Delete?')">Delete</button>
                        </g:form>
                    </td>
                </tr>
            </g:each>
        </tbody>
    </table>
    
    <g:paginate total="${patientCount ?: 0}" />
</body>
</html>
