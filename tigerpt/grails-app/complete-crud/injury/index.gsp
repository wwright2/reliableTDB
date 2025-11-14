<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Injury List</title>
</head>
<body>
    <h1>Trauma Injuries</h1>
    
    <g:link action="create" class="btn btn-primary">Add New Injury</g:link>
    
    <table class="table">
        <thead>
            <tr>
                <th>ID</th>
                <th>Patient</th>
                <th>Incident Date</th>
                <th>External Cause (ICD-10)</th>
                <th>ED Arrival</th>
                <th>GCS Total</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <g:each in="${injuryList}" var="injury">
                <tr>
                    <td>${injury.id}</td>
                    <td>
                        <g:link controller="patient" action="show" id="${injury.patient?.id}">
                            ${injury.patient?.lastName}, ${injury.patient?.firstName}
                        </g:link>
                    </td>
                    <td><g:formatDate date="${injury.injuryIncidentDate}" format="yyyy-MM-dd"/></td>
                    <td>${injury.icd10PrimaryExternalCause}</td>
                    <td><g:formatDate date="${injury.edHospitalArrivalDate}" format="yyyy-MM-dd HH:mm"/></td>
                    <td>${injury.initialEdGcsTotal}</td>
                    <td>
                        <g:link action="show" id="${injury.id}" class="btn btn-sm">View</g:link>
                        <g:link action="edit" id="${injury.id}" class="btn btn-sm">Edit</g:link>
                        <g:form action="delete" id="${injury.id}" style="display:inline">
                            <button type="submit" class="btn btn-sm btn-danger" onclick="return confirm('Delete?')">Delete</button>
                        </g:form>
                    </td>
                </tr>
            </g:each>
        </tbody>
    </table>
    
    <g:paginate total="${injuryCount ?: 0}" />
</body>
</html>
