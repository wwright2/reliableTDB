<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>${patient?.id ? 'Edit' : 'Create'} Patient</title>
</head>
<body>
    <h1>${patient?.id ? 'Edit' : 'Create'} Patient</h1>
    
    <g:if test="${patient?.errors}">
        <div class="alert alert-danger">
            <g:renderErrors bean="${patient}"/>
        </div>
    </g:if>
    
    <g:form action="${patient?.id ? 'update' : 'save'}">
        <g:if test="${patient?.id}">
            <g:hiddenField name="id" value="${patient.id}"/>
        </g:if>
        
        <div class="form-group">
            <label>Patient ID *</label>
            <g:textField name="patientId" value="${patient?.patientId}" class="form-control" required="true"/>
        </div>
        
        <div class="form-group">
            <label>Medical Record Number *</label>
            <g:textField name="medicalRecordNumber" value="${patient?.medicalRecordNumber}" class="form-control" required="true"/>
        </div>
        
        <div class="form-group">
            <label>Last Name *</label>
            <g:textField name="patientLastName" value="${patient?.patientLastName}" class="form-control" required="true"/>
        </div>
        
        <div class="form-group">
            <label>First Name *</label>
            <g:textField name="patientFirstName" value="${patient?.patientFirstName}" class="form-control" required="true"/>
        </div>
        
        <div class="form-group">
            <label>Middle Name</label>
            <g:textField name="patientMiddleName" value="${patient?.patientMiddleName}" class="form-control"/>
        </div>
        
        <div class="form-group">
            <label>Social Security Number</label>
            <g:textField name="socialSecurityNumber" value="${patient?.socialSecurityNumber}" class="form-control"/>
        </div>
        
        <div class="form-group">
            <label>Date of Birth *</label>
            <g:datePicker name="dateOfBirth" value="${patient?.dateOfBirth}" precision="day"/>
        </div>
        
        <div class="form-group">
            <label>Age</label>
            <g:field type="number" name="age" value="${patient?.age}" class="form-control"/>
        </div>
        
        <div class="form-group">
            <label>Sex</label>
            <g:select name="sex" from="${['1':'Male', '2':'Female', '3':'Other']}" optionKey="key" optionValue="value" value="${patient?.sex}" class="form-control"/>
        </div>
        
        <div class="form-group">
            <label>Home ZIP</label>
            <g:textField name="homeZip" value="${patient?.homeZip}" class="form-control"/>
        </div>
        
        <div class="form-group">
            <label>Home State</label>
            <g:textField name="homeState" value="${patient?.homeState}" class="form-control"/>
        </div>
        
        <div class="form-group">
            <label>Home County</label>
            <g:textField name="homeCounty" value="${patient?.homeCounty}" class="form-control"/>
        </div>
        
        <button type="submit" class="btn btn-primary">${patient?.id ? 'Update' : 'Create'}</button>
        <g:link action="index" class="btn btn-secondary">Cancel</g:link>
    </g:form>
</body>
</html>
