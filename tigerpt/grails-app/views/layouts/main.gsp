<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="TigerPT - Trauma Patient Tracking"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:stylesheet src="application.css"/>
    <g:layoutHead/>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
        }
        .navbar {
            background-color: #2c3e50;
            color: white;
            padding: 15px 30px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        .navbar h1 {
            margin: 0;
            font-size: 24px;
            display: inline-block;
        }
        .navbar a {
            color: white;
            text-decoration: none;
            margin-left: 20px;
            padding: 8px 15px;
            border-radius: 4px;
            transition: background-color 0.3s;
        }
        .navbar a:hover {
            background-color: #34495e;
        }
        .container {
            max-width: 1200px;
            margin: 20px auto;
            padding: 20px;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
        }
        .flash {
            padding: 15px;
            margin: 20px 0;
            border-radius: 4px;
        }
        .flash.message {
            background-color: #d4edda;
            border: 1px solid #c3e6cb;
            color: #155724;
        }
        .flash.error {
            background-color: #f8d7da;
            border: 1px solid #f5c6cb;
            color: #721c24;
        }
    </style>
</head>
<body>
    <div class="navbar">
        <h1>🏥 TigerPT - Trauma Patient Tracking</h1>
        <g:link controller="home" action="index">Home</g:link>
        <g:link controller="patient" action="index">Patients</g:link>
        <g:link controller="injury" action="index">Injuries</g:link>
    </div>
    
    <div class="container">
        <g:if test="${flash.message}">
            <div class="flash message" role="status">${flash.message}</div>
        </g:if>
        <g:if test="${flash.error}">
            <div class="flash error" role="alert">${flash.error}</div>
        </g:if>
        
        <g:layoutBody/>
    </div>
    
    <asset:javascript src="application.js"/>
</body>
</html>
