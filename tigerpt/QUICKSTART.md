# TigerPT Quick Start Guide

Get your trauma registry system up and running in minutes!

## Prerequisites Check

Before starting, ensure you have:

- [ ] Java 11 or higher installed
- [ ] MySQL 8.0+ installed and running
- [ ] Git (optional, for version control)

### Verify Java Installation

```bash
java -version
# Should show version 11 or higher
```

### Verify MySQL Installation

```bash
mysql --version
# Should show MySQL 8.0 or higher
```

## Step 1: Database Setup (5 minutes)

### Option A: Using the SQL Script

```bash
# Navigate to the database folder
cd tigerpt/database

# Run the setup script
mysql -u root -p < setup.sql

# Enter your MySQL root password when prompted
```

### Option B: Manual Setup

```bash
# Login to MySQL
mysql -u root -p

# Run these commands:
CREATE DATABASE tigerpt_dev CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER 'root'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON tigerpt_dev.* TO 'root'@'localhost';
FLUSH PRIVILEGES;
exit;
```

## Step 2: Configure Database Connection (2 minutes)

Edit `grails-app/conf/application.yml`:

```yaml
environments:
    development:
        dataSource:
            url: jdbc:mysql://localhost:3306/tigerpt_dev?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC
            username: root
            password: YOUR_PASSWORD_HERE  # Change this!
```

## Step 3: Build the Application (5 minutes)

```bash
# Navigate to project root
cd tigerpt

# Make gradlew executable (Linux/Mac only)
chmod +x gradlew

# Build the project
./gradlew clean build

# On Windows, use:
# gradlew.bat clean build
```

**Note**: First build will download dependencies (~200MB). This is normal.

## Step 4: Run the Application (1 minute)

```bash
# Start the application
./gradlew bootRun

# On Windows:
# gradlew.bat bootRun
```

Wait for this message:
```
Grails application running at http://localhost:8080 in environment: development
```

## Step 5: Access the Application

Open your browser and go to:
```
http://localhost:8080
```

You should see the TigerPT patient list page.

## Step 6: Load Sample Data (Optional)

```bash
# In a new terminal, while the app is running
cd tigerpt/database
mysql -u root -p tigerpt_dev < sample-data.sql
```

Refresh your browser to see the sample patients.

## Common URLs

- **Home Page**: http://localhost:8080
- **Patient List**: http://localhost:8080/patient/index
- **Create Patient**: http://localhost:8080/patient/create

## Basic Operations

### View All Patients

```
GET http://localhost:8080/patient/index
```

### View Single Patient

```
GET http://localhost:8080/patient/show/1
```

### Create New Patient

1. Go to http://localhost:8080/patient/create
2. Fill in the form
3. Click "Create"

### Search Patients

```
GET http://localhost:8080/patient/search?homeState=Texas&sex=Male
```

## Troubleshooting

### Application Won't Start

**Problem**: Port 8080 already in use

**Solution**: 
```bash
# Stop process using port 8080
# Linux/Mac:
lsof -ti:8080 | xargs kill -9

# Windows:
netstat -ano | findstr :8080
taskkill /PID <PID_NUMBER> /F
```

### Database Connection Failed

**Problem**: "Access denied for user"

**Solution**: 
1. Check username/password in `application.yml`
2. Verify MySQL user exists:
```sql
mysql -u root -p
SELECT User, Host FROM mysql.user;
```

### Tables Not Created

**Problem**: Database is empty

**Solution**:
1. Check `application.yml` has `dbCreate: update`
2. Check MySQL user has CREATE privileges
3. Restart application

### Build Failures

**Problem**: Dependencies won't download

**Solution**:
```bash
# Clear Gradle cache
rm -rf ~/.gradle/caches

# Rebuild
./gradlew clean build --refresh-dependencies
```

## Configuration Options

### Change Port

Edit `grails-app/conf/application.yml`:

```yaml
server:
    port: 9090
```

### Change Database

```yaml
dataSource:
    url: jdbc:mysql://your-server:3306/your-database
    username: your-username
    password: your-password
```

### Enable SQL Logging

```yaml
hibernate:
    show_sql: true
    format_sql: true
```

## Next Steps

1. **Read the Full Documentation**: See [README.md](README.md)
2. **Review NTDS Mapping**: See [NTDS_MAPPING.md](NTDS_MAPPING.md)
3. **Customize the Application**: Add your facility's specific needs
4. **Set Up Production**: Follow production deployment guide in README
5. **Implement Security**: Add authentication and authorization

## Development Tips

### Auto-Reload

The application automatically reloads when you change files. No need to restart!

### View Logs

```bash
# Application logs
tail -f build/test-results/*/logs/*.log

# Or check console output
```

### Run Tests

```bash
./gradlew test
```

### Create WAR for Deployment

```bash
./gradlew war
# Output: build/libs/tigerpt-1.0.0-SNAPSHOT.war
```

## Getting Help

### Check Logs

Most errors are explained in the console output or logs.

### Common Issues

1. **MySQL not running**: `sudo systemctl start mysql` (Linux)
2. **Wrong Java version**: Update JAVA_HOME environment variable
3. **Permissions**: Ensure MySQL user has proper privileges

### Documentation

- Grails: https://docs.grails.org
- MySQL: https://dev.mysql.com/doc/
- NTDS: American College of Surgeons website

## Sample API Calls

### Using cURL

```bash
# List patients
curl http://localhost:8080/patient/index

# Get patient details
curl http://localhost:8080/patient/show/1

# Create patient (form data)
curl -X POST http://localhost:8080/patient/save \
  -d "age=45" \
  -d "sex=Male" \
  -d "homeState=Texas" \
  -d "homeCity=Richardson"

# Search
curl "http://localhost:8080/patient/search?homeState=Texas"
```

### Using Browser Developer Tools

Open browser console (F12) and try:

```javascript
// Fetch patient list
fetch('/patient/index')
  .then(r => r.text())
  .then(html => console.log(html));

// Get JSON data
fetch('/patient/search?homeState=Texas', {
  headers: { 'Accept': 'application/json' }
})
  .then(r => r.json())
  .then(data => console.log(data));
```

## Stopping the Application

Press `Ctrl+C` in the terminal where the application is running.

## Uninstall/Clean Up

```bash
# Stop application (Ctrl+C)

# Remove database
mysql -u root -p
DROP DATABASE tigerpt_dev;
DROP USER 'root'@'localhost';
exit;

# Remove application files
cd ..
rm -rf tigerpt
```

## Success Checklist

- [ ] MySQL installed and running
- [ ] Database created
- [ ] Application builds without errors
- [ ] Application starts successfully
- [ ] Can access http://localhost:8080
- [ ] Can view patient list
- [ ] Sample data loads correctly

## What You've Accomplished

✅ Set up a complete trauma registry system
✅ Connected to MySQL database
✅ Created NTDS-compliant data model
✅ Ready to start entering patient data
✅ Foundation for full trauma program tracking

**Congratulations!** Your TigerPT trauma registry is now running!

---

**Need more help?** Check the [README.md](README.md) for detailed information or the [NTDS_MAPPING.md](NTDS_MAPPING.md) for data structure details.
