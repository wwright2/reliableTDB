<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Diagnosis List</title>
</head>
<body>
    <h1>Diagnoses</h1>
    <g:link action="create" class="btn btn-primary">Add New Diagnosis</g:link>
    
    <table class="table">
        <thead>
            <tr>
                <th>ID</th>
                <th>Patient</th>
                <th>ICD-10 Diagnosis</th>
                <th>AIS Code</th>
                <th>Severity</th>
                <th>Body Region</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <g:each in="${diagnosisList}" var="diagnosis">
                <tr>
                    <td>${diagnosis.id}</td>
                    <td><g:link controller="patient" action="show" id="${diagnosis.injury?.patient?.id}">${diagnosis.injury?.patient}</g:link></td>
                    <td>${diagnosis.icd10InjuryDiagnosis}</td>
                    <td>${diagnosis.aisCode}</td>
                    <td>${diagnosis.aisSeverity}</td>
                    <td>${diagnosis.bodyRegion}</td>
                    <td>
                        <g:link action="show" id="${diagnosis.id}" class="btn btn-sm">View</g:link>
                        <g:link action="edit" id="${diagnosis.id}" class="btn btn-sm">Edit</g:link>
                    </td>
                </tr>
            </g:each>
        </tbody>
    </table>
    <g:paginate total="${diagnosisCount ?: 0}" />
</body>
</html>
