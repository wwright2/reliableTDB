<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>TigerPT - Idaho Trauma Registry</title>
</head>
<body>
    <div class="container">
        <h1>TigerPT - Idaho Trauma Registry System</h1>
        
        <div class="row">
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Patients</h5>
                        <p>Manage patient demographics and information</p>
                        <g:link controller="patient" action="index" class="btn btn-primary">View Patients</g:link>
                    </div>
                </div>
            </div>
            
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Injuries</h5>
                        <p>Track injury incidents and ED data</p>
                        <g:link controller="injury" action="index" class="btn btn-primary">View Injuries</g:link>
                    </div>
                </div>
            </div>
            
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Procedures</h5>
                        <p>Hospital procedures and ICD-10 codes</p>
                        <g:link controller="procedure" action="index" class="btn btn-primary">View Procedures</g:link>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="row mt-4">
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Diagnoses</h5>
                        <p>ICD-10 diagnoses and AIS codes</p>
                        <g:link controller="diagnosis" action="index" class="btn btn-primary">View Diagnoses</g:link>
                    </div>
                </div>
            </div>
            
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Complications</h5>
                        <p>Hospital events and complications</p>
                        <g:link controller="complication" action="index" class="btn btn-primary">View Complications</g:link>
                    </div>
                </div>
            </div>
            
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Import XML</h5>
                        <p>Import Idaho trauma registry XML data</p>
                        <g:link controller="import" action="index" class="btn btn-success">Import Data</g:link>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
