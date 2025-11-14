<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Import Idaho XML Data</title>
</head>
<body>
    <h1>Import Idaho Trauma Registry XML</h1>
    
    <g:if test="${flash.message}">
        <div class="alert alert-success">${flash.message}</div>
    </g:if>
    
    <g:if test="${flash.error}">
        <div class="alert alert-danger">${flash.error}</div>
    </g:if>
    
    <div class="card">
        <div class="card-body">
            <h5>Upload Idaho Sample XML File</h5>
            <p>Select an Idaho trauma registry XML file (e.g., Idaho_Sample.xml) to import patient and injury data.</p>
            
            <g:uploadForm action="uploadXml">
                <div class="form-group">
                    <label for="xmlFile">Select XML File:</label>
                    <input type="file" name="xmlFile" id="xmlFile" accept=".xml" class="form-control" required/>
                </div>
                
                <button type="submit" class="btn btn-primary">Import Data</button>
                <g:link action="index" controller="home" class="btn btn-secondary">Cancel</g:link>
            </g:uploadForm>
        </div>
    </div>
    
    <div class="mt-4">
        <h5>XML Format</h5>
        <p>The system expects Idaho Trauma Registry XML format with the following structure:</p>
        <pre>&lt;ITRRecords&gt;
  &lt;ITRRecord&gt;
    &lt;PatientId&gt;...&lt;/PatientId&gt;
    &lt;PatientFirstName&gt;...&lt;/PatientFirstName&gt;
    &lt;PatientLastName&gt;...&lt;/PatientLastName&gt;
    ...
  &lt;/ITRRecord&gt;
&lt;/ITRRecords&gt;</pre>
    </div>
</body>
</html>
