# TigerPT - Trauma Patient Tracking System

A Grails-based web application for managing trauma patient data according to the National Trauma Data Standard (NTDS) 2023 specifications.

## Overview

TigerPT is a comprehensive trauma patient tracking system that implements the complete National Trauma Data Standard (NTDS) data dictionary. It provides a robust platform for recording, managing, and analyzing trauma patient information including:

- **Patient Demographics**: Complete demographic information including residence details
- **Injury Information**: Comprehensive injury incident data with ICD-10 coding
- **Pre-hospital Data**: Transport and emergency care information
- **Emergency Department**: Initial assessment and vital signs
- **Diagnoses**: ICD-10 diagnoses with AIS coding
- **Pre-existing Conditions**: Complete medical history
- **Hospital Events**: Complications and adverse events tracking
- **Procedures**: Hospital procedures with ICD-10 coding
- **Outcomes**: Length of stay, discharge disposition, and TQIP measures
- **Financial**: Payment information

## Technology Stack

- **Framework**: Grails 5.3.2
- **Language**: Groovy 3.0.11
- **Database**: MySQL 8.0
- **ORM**: Hibernate 5 (GORM)
- **Build Tool**: Gradle 7.6
- **Java Version**: JDK 11 or higher

## Prerequisites

- JDK 11 or higher
- MySQL 8.0 or higher
- Gradle 7.6 (or use included wrapper)

## Database Setup

### 1. Create MySQL Databases

```sql
-- Create databases for different environments
CREATE DATABASE tigerpt_dev CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE DATABASE tigerpt_test CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE DATABASE tigerpt_prod CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- Create user (optional, for production)
CREATE USER 'tigerpt_user'@'localhost' IDENTIFIED BY 'your_secure_password';
GRANT ALL PRIVILEGES ON tigerpt_prod.* TO 'tigerpt_user'@'localhost';
FLUSH PRIVILEGES;
```

### 2. Update Database Configuration

Edit `grails-app/conf/application.yml` and update the database credentials:

```yaml
environments:
    development:
        dataSource:
            url: jdbc:mysql://localhost:3306/tigerpt_dev?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
            username: root
            password: your_password
```

## Installation & Running

### 1. Clone or Extract the Project

```bash
cd tigerpt
```

### 2. Build the Project

```bash
./gradlew clean build
```

### 3. Run the Application

```bash
./gradlew bootRun
```

The application will start on `http://localhost:8080`

## Database Schema

The application automatically creates the following tables based on the NTDS data dictionary:

- **patients**: Core patient demographic information
- **injuries**: Injury incident and emergency department information
- **diagnoses**: ICD-10 and AIS coded diagnoses
- **pre_existing_conditions**: Patient medical history
- **hospital_events**: Complications and adverse events
- **hospital_procedures**: Surgical and medical procedures
- **outcomes**: Patient outcomes and TQIP measures

## Features

### Patient Management
- Create, read, update, and delete patient records
- Search patients by name or medical record number
- View complete patient profiles with all associated data

### Injury Tracking
- Record detailed injury information
- ICD-10 external cause coding
- Pre-hospital and ED vital signs
- Glasgow Coma Scale (GCS) tracking

### Diagnosis Management
- ICD-10 diagnosis codes
- Abbreviated Injury Scale (AIS) coding
- Body region tracking
- Severity scoring

### Reporting & Analytics
- Patient counts and statistics
- Recent patient listings
- Dashboard overview

## REST API Endpoints

The application provides REST API endpoints for integration:

```
GET    /api/patients          - List all patients
GET    /api/patients/{id}     - Get patient by ID
POST   /api/patients          - Create new patient
PUT    /api/patients/{id}     - Update patient
DELETE /api/patients/{id}     - Delete patient

GET    /api/injuries          - List all injuries
GET    /api/injuries/{id}     - Get injury by ID
POST   /api/injuries          - Create new injury
PUT    /api/injuries/{id}     - Update injury
DELETE /api/injuries/{id}     - Delete injury

Similar endpoints for diagnoses and outcomes
```

## Configuration

### Database Settings

Edit `grails-app/conf/application.yml`:

```yaml
dataSource:
    pooled: true
    jmxExport: true
    driverClassName: com.mysql.cj.jdbc.Driver
    dialect: org.hibernate.dialect.MySQL8Dialect
```

### Environment-Specific Configuration

- **Development**: Auto-creates schema, uses local database
- **Test**: Separate test database
- **Production**: Schema management disabled, uses production credentials

## Sample Data

The application includes a BootStrap loader that creates sample data on first run:
- Sample patient with complete demographic information
- Sample injury record with ED vitals
- Sample diagnosis with ICD-10 and AIS codes
- Sample pre-existing conditions
- Sample outcome data

## Project Structure

```
tigerpt/
├── grails-app/
│   ├── conf/
│   │   └── application.yml          # Configuration
│   ├── controllers/
│   │   └── com/tigerpt/controller/  # Controllers
│   ├── domain/
│   │   └── com/tigerpt/domain/      # Domain models (GORM)
│   ├── init/
│   │   └── com/tigerpt/             # Application startup
│   ├── services/
│   │   └── com/tigerpt/service/     # Business logic
│   └── views/
│       ├── layouts/                  # Page layouts
│       └── home/                     # View templates
├── build.gradle                      # Build configuration
├── gradle.properties                 # Gradle properties
└── README.md                         # This file
```

## Domain Model Overview

### Patient
- Demographic information
- Contact details
- Medical record number

### Injury
- Incident information
- Pre-hospital data
- Emergency department assessment
- Transport details

### Diagnosis
- ICD-10 codes
- AIS codes and severity
- Body region

### PreExistingCondition
- Comprehensive medical history
- Boolean flags for 30+ conditions

### HospitalEvent
- Complications tracking
- Adverse events
- Hospital-acquired conditions

### HospitalProcedure
- ICD-10 procedure codes
- Procedure timing
- Provider information

### Outcome
- Length of stay
- Ventilator days
- Discharge disposition
- TQIP quality measures
- Blood product usage
- Payment information

## Development

### Adding New Domain Classes

1. Create domain class in `grails-app/domain/com/tigerpt/domain/`
2. Define properties and constraints
3. Run application to auto-generate schema

### Creating Controllers

```bash
grails create-controller com.tigerpt.controller.YourController
```

### Creating Services

```bash
grails create-service com.tigerpt.service.YourService
```

## Compliance

This application implements the **National Trauma Data Standard (NTDS) 2023** as published by the American College of Surgeons (ACS) Trauma Programs.

### Standards Implemented:
- Complete NTDS data dictionary
- ICD-10 coding support
- AIS (Abbreviated Injury Scale) coding
- TQIP (Trauma Quality Improvement Program) measures
- Glasgow Coma Scale (GCS) and GCS-40 support

## Security Notes

**Important**: Update the following for production:

1. Change default database passwords
2. Configure SSL/TLS for database connections
3. Implement user authentication and authorization
4. Enable HTTPS
5. Set up proper backup procedures
6. Configure audit logging

## Troubleshooting

### Database Connection Issues

- Verify MySQL is running
- Check database credentials in `application.yml`
- Ensure MySQL user has proper permissions
- Verify database exists

### Build Issues

- Clean build: `./gradlew clean build`
- Clear Gradle cache: `rm -rf ~/.gradle/caches/`

### Port Already in Use

- Change port in `application.yml`:
```yaml
server:
    port: 8081
```

## Support

For issues related to:
- **NTDS Specifications**: Refer to ACS Trauma Programs documentation
- **Grails Framework**: https://grails.org/documentation.html
- **MySQL**: https://dev.mysql.com/doc/

## License

This application is designed to support NTDS compliance. Please ensure compliance with all applicable healthcare data regulations (HIPAA, etc.) when deploying in production.

## Version History

- **0.1**: Initial release with complete NTDS 2023 data dictionary implementation

## Future Enhancements

- User authentication and role-based access control
- Advanced search and filtering
- Report generation and export (CSV, PDF)
- Data import from EMS systems
- Integration with hospital EMR systems
- Advanced analytics and visualization
- Mobile application support
- FHIR API support

## Contributing

When contributing, please ensure:
- Code follows Groovy/Grails conventions
- All domain classes include proper constraints
- Changes maintain NTDS compliance
- Documentation is updated

---

**Note**: This system is designed for NTDS-compliant trauma data collection. Ensure proper IRB approval and HIPAA compliance before using with real patient data.
