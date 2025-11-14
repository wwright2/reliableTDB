# TigerPT Setup Guide

Complete setup instructions for the TigerPT Trauma Patient Tracking System.

## Table of Contents
1. [Prerequisites](#prerequisites)
2. [Database Setup](#database-setup)
3. [Application Configuration](#application-configuration)
4. [Building and Running](#building-and-running)
5. [Verification](#verification)
6. [Troubleshooting](#troubleshooting)

---

## Prerequisites

### Required Software

1. **Java Development Kit (JDK) 11 or higher**
   ```bash
   # Check Java version
   java -version
   
   # Should show version 11 or higher
   # Example output: openjdk version "11.0.xx"
   ```
   
   Download from: https://adoptium.net/

2. **MySQL 8.0 or higher**
   ```bash
   # Check MySQL version
   mysql --version
   
   # Should show version 8.0 or higher
   ```
   
   Download from: https://dev.mysql.com/downloads/mysql/

3. **Gradle 7.6** (Optional - project includes wrapper)
   ```bash
   # Check Gradle version
   gradle --version
   ```

### System Requirements

- **RAM**: Minimum 4GB, Recommended 8GB
- **Disk Space**: Minimum 500MB for application, 1GB+ for database
- **OS**: Windows 10+, macOS 10.14+, Linux (Ubuntu 20.04+)

---

## Database Setup

### Step 1: Start MySQL Server

**Windows:**
```cmd
# Start MySQL service
net start MySQL80
```

**macOS:**
```bash
# Start MySQL
brew services start mysql
# or
mysql.server start
```

**Linux:**
```bash
# Start MySQL service
sudo systemctl start mysql
# or
sudo service mysql start
```

### Step 2: Connect to MySQL

```bash
# Connect as root user
mysql -u root -p

# Enter your MySQL root password when prompted
```

### Step 3: Run Database Setup Script

Option A: Execute the provided SQL script
```bash
# From the tigerpt directory
mysql -u root -p < database-setup.sql
```

Option B: Manual setup in MySQL console
```sql
-- Create databases
CREATE DATABASE tigerpt_dev CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE DATABASE tigerpt_test CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE DATABASE tigerpt_prod CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- Verify creation
SHOW DATABASES LIKE 'tigerpt%';

-- Exit MySQL
EXIT;
```

### Step 4: Configure Database User (Optional)

For production deployments, create a dedicated user:

```sql
-- In MySQL console
CREATE USER 'tigerpt_user'@'localhost' IDENTIFIED BY 'YOUR_SECURE_PASSWORD';
GRANT ALL PRIVILEGES ON tigerpt_dev.* TO 'tigerpt_user'@'localhost';
GRANT ALL PRIVILEGES ON tigerpt_test.* TO 'tigerpt_user'@'localhost';
GRANT ALL PRIVILEGES ON tigerpt_prod.* TO 'tigerpt_user'@'localhost';
FLUSH PRIVILEGES;
```

---

## Application Configuration

### Step 1: Configure Database Connection

Edit `grails-app/conf/application.yml`:

```yaml
environments:
    development:
        dataSource:
            url: jdbc:mysql://localhost:3306/tigerpt_dev?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
            username: root          # Change to your MySQL username
            password: your_password # Change to your MySQL password
```

### Step 2: Verify Configuration Files

Ensure these files exist:
- ✓ `build.gradle`
- ✓ `gradle.properties`
- ✓ `settings.gradle`
- ✓ `grails-app/conf/application.yml`
- ✓ `grails-app/conf/application.groovy`
- ✓ `grails-app/conf/logback.groovy`

---

## Building and Running

### Step 1: Navigate to Project Directory

```bash
cd /path/to/tigerpt
```

### Step 2: Make Gradle Wrapper Executable (Unix/Mac only)

```bash
chmod +x gradlew
```

### Step 3: Clean and Build

```bash
# Windows
gradlew.bat clean build

# Unix/Mac
./gradlew clean build
```

Expected output:
```
BUILD SUCCESSFUL in XXs
```

### Step 4: Run the Application

```bash
# Windows
gradlew.bat bootRun

# Unix/Mac
./gradlew bootRun
```

Wait for the message:
```
Grails application running at http://localhost:8080 in environment: development
```

### Step 5: Access the Application

Open your web browser and navigate to:
```
http://localhost:8080
```

You should see the TigerPT home page with the dashboard.

---

## Verification

### 1. Check Database Tables

```bash
# Connect to MySQL
mysql -u root -p tigerpt_dev

# List tables
SHOW TABLES;
```

Expected tables:
- patients
- injuries
- diagnoses
- pre_existing_conditions
- hospital_events
- hospital_procedures
- outcomes

### 2. Verify Sample Data

```sql
-- Check patient count
SELECT COUNT(*) FROM patients;

-- Should return at least 1 (sample patient)

-- View sample patient
SELECT * FROM patients LIMIT 1;
```

### 3. Test Web Interface

Visit these URLs in your browser:

1. **Home Page**: http://localhost:8080
   - Should show dashboard with patient count
   
2. **Patients List**: http://localhost:8080/patient
   - Should show list of patients
   
3. **Patient Details**: http://localhost:8080/patient/show/1
   - Should show details of first patient

### 4. Test REST API

Using curl or Postman:

```bash
# Get all patients
curl http://localhost:8080/api/patients

# Get specific patient
curl http://localhost:8080/api/patients/1
```

---

## Troubleshooting

### Problem: Port 8080 Already in Use

**Solution 1**: Stop other applications using port 8080

**Solution 2**: Change application port

Edit `grails-app/conf/application.yml`:
```yaml
server:
    port: 8081
```

Then access at: http://localhost:8081

### Problem: Database Connection Failed

**Error**: `Communications link failure` or `Access denied`

**Solutions**:

1. Verify MySQL is running:
   ```bash
   # Check MySQL status
   mysql -u root -p -e "SELECT 1"
   ```

2. Check credentials in `application.yml`

3. Verify database exists:
   ```bash
   mysql -u root -p -e "SHOW DATABASES LIKE 'tigerpt%'"
   ```

4. Check MySQL port (default 3306):
   ```bash
   mysql -u root -p -e "SHOW VARIABLES LIKE 'port'"
   ```

### Problem: Build Failed

**Error**: `Could not resolve dependencies`

**Solutions**:

1. Check internet connection

2. Clear Gradle cache:
   ```bash
   # Unix/Mac
   rm -rf ~/.gradle/caches/
   
   # Windows
   rmdir /s %USERPROFILE%\.gradle\caches
   ```

3. Retry build:
   ```bash
   ./gradlew clean build --refresh-dependencies
   ```

### Problem: Java Version Mismatch

**Error**: `Unsupported class file major version`

**Solution**: Verify Java version
```bash
java -version
# Must be 11 or higher

# Set JAVA_HOME if needed
export JAVA_HOME=/path/to/jdk11
```

### Problem: Sample Data Not Loading

**Solution**: Check BootStrap.groovy execution

View logs in console output, should see:
```
Loading sample trauma data...
Sample trauma data loaded successfully
```

If not appearing, check database permissions and constraints.

### Problem: Views Not Loading

**Error**: `404 Not Found` or blank pages

**Solutions**:

1. Verify view files exist in `grails-app/views/`

2. Clear cache and restart:
   ```bash
   ./gradlew clean bootRun
   ```

3. Check logs for errors

---

## Advanced Configuration

### Production Deployment

1. **Update application.yml for production**:
   ```yaml
   environments:
       production:
           dataSource:
               dbCreate: none  # Don't auto-create schema
               url: jdbc:mysql://your-server:3306/tigerpt_prod?useSSL=true
               username: tigerpt_user
               password: ${DB_PASSWORD}  # Use environment variable
   ```

2. **Build WAR file**:
   ```bash
   ./gradlew assemble
   ```
   
   WAR file location: `build/libs/tigerpt-0.1.war`

3. **Set environment variables**:
   ```bash
   export DB_PASSWORD=your_secure_password
   ```

4. **Deploy to Tomcat or run standalone**:
   ```bash
   java -jar build/libs/tigerpt-0.1.war
   ```

### SSL/TLS Configuration

Edit `application.yml`:
```yaml
server:
    ssl:
        enabled: true
        key-store: classpath:keystore.p12
        key-store-password: password
        key-store-type: PKCS12
```

### Enable HTTPS for MySQL

Update connection URL:
```yaml
url: jdbc:mysql://localhost:3306/tigerpt_dev?useSSL=true&requireSSL=true
```

---

## Next Steps

1. **Explore the Application**: Navigate through patients, injuries, and outcomes

2. **Add Real Data**: Replace sample data with actual trauma records

3. **Customize**: Modify domain classes to fit specific requirements

4. **Secure**: Implement authentication and authorization

5. **Backup**: Set up regular database backups

6. **Monitor**: Configure logging and monitoring

7. **Scale**: Consider clustering for high-availability

---

## Getting Help

- **Grails Documentation**: https://docs.grails.org/
- **MySQL Documentation**: https://dev.mysql.com/doc/
- **NTDS Documentation**: ACS Trauma Programs
- **Project Issues**: Check README.md for known issues

---

## Quick Reference Commands

```bash
# Start application
./gradlew bootRun

# Run tests
./gradlew test

# Create WAR file
./gradlew assemble

# Clean build
./gradlew clean

# View dependencies
./gradlew dependencies

# Generate database schema
./gradlew dbm-gorm-diff

# Access console
./gradlew console
```

---

**Setup Complete!** You now have a fully functional NTDS-compliant trauma tracking system.
