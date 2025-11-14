<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Diagnosis Details</title>
</head>
<body>
    <h1>Diagnosis #${diagnosis.id}</h1>
    
    <table class="table">
        <tr><th>Injury:</th><td><g:link controller="injury" action="show" id="${diagnosis.injury?.id}">${diagnosis.injury}</g:link></td></tr>
        <tr><th>Patient:</th><td><g:link controller="patient" action="show" id="${diagnosis.injury?.patient?.id}">${diagnosis.injury?.patient}</g:link></td></tr>
        <tr><th>ICD-10 Diagnosis:</th><td>${diagnosis.icd10InjuryDiagnosis}</td></tr>
        <tr><th>AIS Code:</th><td>${diagnosis.aisCode}</td></tr>
        <tr><th>AIS Version:</th><td>${diagnosis.aisVersion}</td></tr>
        <tr><th>Body Region:</th><td>${diagnosis.bodyRegion}</td></tr>
        <tr><th>AIS Severity:</th><td>${diagnosis.aisSeverity}/6</td></tr>
    </table>
    
    <g:link action="edit" id="${diagnosis.id}" class="btn btn-primary">Edit</g:link>
    <g:link action="index" class="btn btn-secondary">Back</g:link>
    <g:form action="delete" id="${diagnosis.id}" style="display:inline">
        <button type="submit" class="btn btn-danger" onclick="return confirm('Delete?')">Delete</button>
    </g:form>
</body>
</html>
