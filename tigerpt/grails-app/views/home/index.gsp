<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>TigerPT - Trauma Registry</title>
    <style>
        .dashboard-container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
        }
        .dashboard-header {
            text-align: center;
            margin-bottom: 40px;
        }
        .dashboard-header h1 {
            color: #2c3e50;
            font-size: 2.5em;
            margin-bottom: 10px;
        }
        .card-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
            gap: 20px;
            margin-bottom: 30px;
        }
        .dashboard-card {
            background: white;
            border-radius: 8px;
            padding: 25px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            transition: transform 0.2s;
        }
        .dashboard-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 4px 12px rgba(0,0,0,0.15);
        }
        .dashboard-card h3 {
            color: #3498db;
            margin-top: 0;
        }
        .dashboard-card .btn {
            display: inline-block;
            padding: 10px 20px;
            background: #3498db;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            margin-right: 10px;
        }
        .stats-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
            gap: 15px;
            margin-bottom: 30px;
        }
        .stat-card {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            padding: 20px;
            border-radius: 8px;
            text-align: center;
        }
        .stat-number {
            font-size: 2.5em;
            font-weight: bold;
        }
        .section-title {
            color: #2c3e50;
            border-bottom: 3px solid #3498db;
            padding-bottom: 10px;
            margin: 30px 0 20px 0;
        }
    </style>
</head>
<body>
    <div class="dashboard-container">
        <div class="dashboard-header">
            <h1>🏥 TigerPT -  Trauma Registry</h1>
            <p>Comprehensive Trauma Patient Tracking System</p>
        </div>
        
        <div class="stats-grid">
            <div class="stat-card">
                <div>Total Patients</div>
                <div class="stat-number">${com.tigerpt.domain.Patient.count()}</div>
            </div>
            <div class="stat-card" style="background: linear-gradient(135deg, #f093fb 0%, #f5576c 100%);">
                <div>Injuries Recorded</div>
                <div class="stat-number">${com.tigerpt.domain.Injury.count()}</div>
            </div>
            <div class="stat-card" style="background: linear-gradient(135deg, #4facfe 0%, #00f2fe 100%);">
                <div>Diagnoses</div>
                <div class="stat-number">${com.tigerpt.domain.Diagnosis.count()}</div>
            </div>
            <div class="stat-card" style="background: linear-gradient(135deg, #43e97b 0%, #38f9d7 100%);">
                <div>Procedures</div>
                <div class="stat-number">${com.tigerpt.domain.HospitalProcedure.count()}</div>
            </div>
        </div>
        
        <h2 class="section-title">Core Data Management</h2>
        <div class="card-grid">
            <div class="dashboard-card">
                <h3>👤 Patients</h3>
                <p>Manage patient demographics and medical records</p>
                <g:link controller="patient" action="index" class="btn">View Patients</g:link>
                <g:link controller="patient" action="create" class="btn" style="background: #27ae60;">Add New</g:link>
            </div>
            
            <div class="dashboard-card">
                <h3>🚑 Injuries</h3>
                <p>Track trauma incidents, ED data, and vital signs</p>
                <g:link controller="injury" action="index" class="btn">View Injuries</g:link>
                <g:link controller="injury" action="create" class="btn" style="background: #27ae60;">Add New</g:link>
            </div>
            
            <div class="dashboard-card">
                <h3>📋 Diagnoses</h3>
                <p>ICD-10 injury diagnoses and AIS codes</p>
                <g:link controller="diagnosis" action="index" class="btn">View Diagnoses</g:link>
                <g:link controller="diagnosis" action="create" class="btn" style="background: #27ae60;">Add New</g:link>
            </div>
        </div>
        
        <h2 class="section-title">Hospital Events & Procedures</h2>
        <div class="card-grid">
            <div class="dashboard-card">
                <h3>⚕️ Hospital Procedures</h3>
                <p>ICD-10 procedure codes and surgery details</p>
                <g:link controller="hospitalProcedure" action="index" class="btn">View Procedures</g:link>
                <g:link controller="hospitalProcedure" action="create" class="btn" style="background: #27ae60;">Add New</g:link>
            </div>
            
            <div class="dashboard-card">
                <h3>🏥 Hospital Events</h3>
                <p>Track complications and adverse events</p>
                <g:link controller="hospitalEvent" action="index" class="btn">View Events</g:link>
                <g:link controller="hospitalEvent" action="create" class="btn" style="background: #27ae60;">Add New</g:link>
            </div>
            
            <div class="dashboard-card">
                <h3>📊 Outcomes</h3>
                <p>ICU length of stay and discharge data</p>
                <g:link controller="outcome" action="index" class="btn">View Outcomes</g:link>
                <g:link controller="outcome" action="create" class="btn" style="background: #27ae60;">Add New</g:link>
            </div>
        </div>
        
        <h2 class="section-title">Patient History & Data</h2>
        <div class="card-grid">
            <div class="dashboard-card">
                <h3>🩺 Pre-Existing Conditions</h3>
                <p>Patient comorbidities per NTDS standards</p>
                <g:link controller="preExistingCondition" action="index" class="btn">View Conditions</g:link>
                <g:link controller="preExistingCondition" action="create" class="btn" style="background: #27ae60;">Add New</g:link>
            </div>
            
            <div class="dashboard-card">
                <h3>📁 Import Data</h3>
                <p>Upload




 trauma registry XML files</p>
                <g:link controller="import" action="index" class="btn">Import XML</g:link>
            </div>
        </div>
        
        <div style="text-align: center; margin-top: 40px; padding: 20px; background: #ecf0f1; border-radius: 8px;">
            <p style="color: #7f8c8d;"><strong>TigerPT v1.0</strong> | NTDS 2023 Compliant |




 Trauma Registry System</p>
        </div>
    </div>
</body>
</html>
