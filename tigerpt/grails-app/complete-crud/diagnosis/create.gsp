<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>${diagnosis?.id ? 'Edit' : 'Create'} Diagnosis</title>
</head>
<body>
    <h1>${diagnosis?.id ? 'Edit' : 'Create'} Diagnosis</h1>
    
    <g:if test="${diagnosis?.errors}">
        <div class="alert alert-danger"><g:renderErrors bean="${diagnosis}"/></div>
    </g:if>
    
    <g:form action="${diagnosis?.id ? 'update' : 'save'}">
        <g:if test="${diagnosis?.id}">
            <g:hiddenField name="id" value="${diagnosis.id}"/>
        </g:if>
        
        <div class="form-group">
            <label>Injury *</label>
            <g:select name="injury.id" from="${com.tigerpt.domain.Injury.list()}" optionKey="id" 
                      value="${diagnosis?.injury?.id}" class="form-control" required="true"/>
        </div>
        
        <div class="form-group">
            <label>ICD-10 Injury Diagnosis</label>
            <g:textField name="icd10InjuryDiagnosis" value="${diagnosis?.icd10InjuryDiagnosis}" class="form-control"/>
        </div>
        
        <div class="form-group">
            <label>AIS Code</label>
            <g:textField name="aisCode" value="${diagnosis?.aisCode}" class="form-control"/>
        </div>
        
        <div class="form-group">
            <label>AIS Version</label>
            <g:textField name="aisVersion" value="${diagnosis?.aisVersion}" class="form-control"/>
        </div>
        
        <div class="form-group">
            <label>Body Region</label>
            <g:textField name="bodyRegion" value="${diagnosis?.bodyRegion}" class="form-control"/>
        </div>
        
        <div class="form-group">
            <label>AIS Severity (1-6)</label>
            <g:field type="number" name="aisSeverity" value="${diagnosis?.aisSeverity}" min="1" max="6" class="form-control"/>
        </div>
        
        <button type="submit" class="btn btn-primary">${diagnosis?.id ? 'Update' : 'Create'}</button>
        <g:link action="index" class="btn btn-secondary">Cancel</g:link>
    </g:form>
</body>
</html>
