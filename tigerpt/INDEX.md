# TigerPT - Project Index

## Project Overview

**TigerPT** (Trauma Patient Tracking) is a comprehensive Grails-based web application implementing the **National Trauma Data Standard (NTDS) 2023** as published by the American College of Surgeons. It provides a complete solution for managing trauma patient data with MySQL backend.

## Key Features

✅ **NTDS 2023 Compliant**: Implements complete data dictionary  
✅ **MySQL Backend**: Production-ready database configuration  
✅ **RESTful API**: Complete REST endpoints for all entities  
✅ **Web Interface**: User-friendly dashboard and forms  
✅ **Sample Data**: Pre-loaded with example trauma records  
✅ **Comprehensive Documentation**: Setup guides and README  

## Technology Stack

- **Framework**: Grails 5.3.2
- **Language**: Groovy 3.0.11
- **Database**: MySQL 8.0
- **ORM**: Hibernate 5 (GORM)
- **Build**: Gradle 7.6

## Quick Start

1. **Database Setup**
   ```bash
   mysql -u root -p < database-setup.sql
   ```

2. **Configure Database**
   Edit `grails-app/conf/application.yml` with your credentials

3. **Build and Run**
   ```bash
   ./gradlew bootRun
   ```

4. **Access Application**
   ```
   http://localhost:8080
   ```

## Documentation Files

- **README.md** - Complete project documentation
- **SETUP_GUIDE.md** - Step-by-step installation guide
- **INDEX.md** - This overview file
- **database-setup.sql** - MySQL setup script

For detailed information, see **README.md** and **SETUP_GUIDE.md**
