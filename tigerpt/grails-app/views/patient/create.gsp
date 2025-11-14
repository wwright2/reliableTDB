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
        
        <fieldset>
            <legend>Personal Information</legend>
            
            <div class="form-group">
                <label>First Name</label>
                <g:textField name="firstName" value="${patient?.firstName}" class="form-control"/>
            </div>
            
            <div class="form-group">
                <label>Last Name</label>
                <g:textField name="lastName" value="${patient?.lastName}" class="form-control"/>
            </div>
            
            <div class="form-group">
                <label>Middle Name</label>
                <g:textField name="middleName" value="${patient?.middleName}" class="form-control"/>
            </div>
            
            <div class="form-group">
                <label>Medical Record Number</label>
                <g:textField name="medicalRecordNumber" value="${patient?.medicalRecordNumber}" class="form-control"/>
            </div>
            
            <div class="form-group">
                <label>Date of Birth</label>
                <g:datePicker name="dateOfBirth" value="${patient?.dateOfBirth}" precision="day" years="${1900..2025}"/>
            </div>
            
            <div class="form-group">
                <label>Age</label>
                <g:field type="number" name="age" value="${patient?.age}" class="form-control"/>
            </div>
            
            <div class="form-group">
                <label>Age Units</label>
                <g:textField name="ageUnits" value="${patient?.ageUnits}" class="form-control" placeholder="e.g., years, months"/>
            </div>
            
            <div class="form-group">
                <label>Sex</label>
                <g:select name="sex" from="${['Male', 'Female', 'Other', 'Unknown']}" 
                          value="${patient?.sex}" class="form-control" noSelection="['':'Select...']"/>
            </div>
            
            <div class="form-group">
                <label>Race</label>
                <g:textField name="race" value="${patient?.race}" class="form-control"/>
            </div>
            
            <div class="form-group">
                <label>Ethnicity</label>
                <g:textField name="ethnicity" value="${patient?.ethnicity}" class="form-control"/>
            </div>
        </fieldset>
        
        <fieldset>
            <legend>Address Information</legend>
            
            <div class="form-group">
                <label>Home ZIP Code</label>
                <g:textField name="homeZipCode" value="${patient?.homeZipCode}" class="form-control"/>
            </div>
            
            <div class="form-group">
                <label>Home City</label>
                <g:textField name="homeCity" value="${patient?.homeCity}" class="form-control"/>
            </div>
            
            <div class="form-group">
                <label>Home State</label>
                <g:textField name="homeState" value="${patient?.homeState}" class="form-control"/>
            </div>
            
            <div class="form-group">
                <label>Home County</label>
                <g:textField name="homeCounty" value="${patient?.homeCounty}" class="form-control"/>
            </div>
            
            <div class="form-group">
                <label>Home Country</label>
                <g:textField name="homeCountry" value="${patient?.homeCountry}" class="form-control"/>
            </div>
            
            <div class="form-group">
                <label>Alternate Home Residence</label>
                <g:textField name="alternateHomeResidence" value="${patient?.alternateHomeResidence}" class="form-control"/>
            </div>
        </fieldset>
        
        <button type="submit" class="btn btn-primary">${patient?.id ? 'Update' : 'Create'}</button>
        <g:link action="index" class="btn btn-secondary">Cancel</g:link>
    </g:form>
</body>
</html>
