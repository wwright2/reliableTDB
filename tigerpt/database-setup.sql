-- TigerPT Database Setup Script
-- National Trauma Data Standard (NTDS) 2023 Compliant Database
-- MySQL 8.0+

-- ==============================================
-- 1. CREATE DATABASES
-- ==============================================

CREATE DATABASE IF NOT EXISTS tigerpt_dev 
    CHARACTER SET utf8mb4 
    COLLATE utf8mb4_unicode_ci;

CREATE DATABASE IF NOT EXISTS tigerpt_test 
    CHARACTER SET utf8mb4 
    COLLATE utf8mb4_unicode_ci;

CREATE DATABASE IF NOT EXISTS tigerpt_prod 
    CHARACTER SET utf8mb4 
    COLLATE utf8mb4_unicode_ci;

-- ==============================================
-- 2. CREATE DATABASE USER (Optional for Production)
-- ==============================================

-- For production, create a dedicated user
-- Replace 'P@assword1' with a secure password

CREATE USER IF NOT EXISTS 'tigerpt_user'@'localhost' 
    IDENTIFIED BY 'P@assword1';

-- Grant privileges on production database
GRANT ALL PRIVILEGES ON tigerpt_prod.* TO 'tigerpt_user'@'localhost';

-- For development (if using separate user)
GRANT ALL PRIVILEGES ON tigerpt_dev.* TO 'tigerpt_user'@'localhost';

-- For test environment (if using separate user)
GRANT ALL PRIVILEGES ON tigerpt_test.* TO 'tigerpt_user'@'localhost';

FLUSH PRIVILEGES;

-- ==============================================
-- 3. VERIFY DATABASE CREATION
-- ==============================================

SHOW DATABASES LIKE 'tigerpt%';

-- ==============================================
-- 4. USE DEVELOPMENT DATABASE
-- ==============================================

USE tigerpt_dev;

-- ==============================================
-- 5. NOTES
-- ==============================================

/*
The actual table schema will be created automatically by Grails/GORM
when the application starts for the first time.

The following tables will be created:
- patients
- injuries
- diagnoses
- pre_existing_conditions
- hospital_events
- hospital_procedures
- outcomes

Database Configuration Notes:
1. Character Set: UTF-8 (utf8mb4) for full Unicode support
2. Collation: utf8mb4_unicode_ci for case-insensitive comparison
3. InnoDB engine will be used by default (GORM default)
4. Foreign keys will be automatically created for relationships

For Production Deployment:
1. Change the default password
2. Configure backup procedures
3. Set up replication if needed
4. Configure SSL/TLS connections
5. Implement proper monitoring
6. Set up audit logging

Connection String Format:
jdbc:mysql://localhost:3306/tigerpt_dev?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true

Security Checklist:
[ ] Change default passwords
[ ] Enable SSL/TLS
[ ] Configure firewall rules
[ ] Set up backup procedures
[ ] Configure audit logging
[ ] Implement user access controls
[ ] Review security group settings
[ ] Set up monitoring and alerts
*/

-- ==============================================
-- 6. OPTIONAL: CREATE ADDITIONAL INDEXES
-- ==============================================

-- These will be created automatically by GORM, but you can add custom ones here
-- Example:
-- USE tigerpt_prod;
-- CREATE INDEX idx_patient_mrn ON patients(medical_record_number);
-- CREATE INDEX idx_patient_name ON patients(last_name, first_name);
-- CREATE INDEX idx_injury_date ON injuries(injury_incident_date);

-- ==============================================
-- 7. DATABASE CONFIGURATION VERIFICATION
-- ==============================================

-- Check MySQL version (should be 8.0+)
SELECT VERSION();

-- Check character set settings
SHOW VARIABLES LIKE 'character_set%';

-- Check collation settings
SHOW VARIABLES LIKE 'collation%';

-- Check max connections
SHOW VARIABLES LIKE 'max_connections';

-- Check InnoDB settings
SHOW VARIABLES LIKE 'innodb%';

-- ==============================================
-- END OF SETUP SCRIPT
-- ==============================================

SELECT 'TigerPT Database Setup Complete!' AS Status;
SELECT 'Run the Grails application to auto-generate tables' AS NextStep;
