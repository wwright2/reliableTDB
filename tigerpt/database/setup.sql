-- TigerPT Database Setup Script
-- National Trauma Data Standard (NTDS) 2023
-- MySQL 8.0+

-- ==============================================
-- DEVELOPMENT ENVIRONMENT SETUP
-- ==============================================

-- Create development database
CREATE DATABASE IF NOT EXISTS tigerpt_dev 
    CHARACTER SET utf8mb4 
    COLLATE utf8mb4_unicode_ci;

-- Create development user
CREATE USER IF NOT EXISTS 'root'@'localhost' IDENTIFIED BY 'password';

-- Grant privileges
GRANT ALL PRIVILEGES ON tigerpt_dev.* TO 'root'@'localhost';

-- ==============================================
-- PRODUCTION ENVIRONMENT SETUP
-- ==============================================

-- Create production database
CREATE DATABASE IF NOT EXISTS tigerpt_prod 
    CHARACTER SET utf8mb4 
    COLLATE utf8mb4_unicode_ci;

-- Create production user with strong password
CREATE USER IF NOT EXISTS 'tigerpt_user'@'localhost' IDENTIFIED BY 'CHANGE_THIS_PASSWORD_123!';

-- Grant privileges (minimal required for production)
GRANT SELECT, INSERT, UPDATE, DELETE ON tigerpt_prod.* TO 'tigerpt_user'@'localhost';

-- ==============================================
-- FLUSH PRIVILEGES
-- ==============================================
FLUSH PRIVILEGES;

-- ==============================================
-- VERIFY SETUP
-- ==============================================

-- Show databases
SHOW DATABASES LIKE 'tigerpt%';

-- Show users
SELECT User, Host FROM mysql.user WHERE User LIKE 'tigerpt%' OR User = 'root';

-- Use development database
USE tigerpt_dev;

-- Show tables (will be empty until Grails creates them)
SHOW TABLES;

-- ==============================================
-- OPTIONAL: CREATE BACKUP USER
-- ==============================================

CREATE USER IF NOT EXISTS 'tigerpt_backup'@'localhost' IDENTIFIED BY 'BACKUP_PASSWORD_HERE';
GRANT SELECT, LOCK TABLES, SHOW VIEW ON tigerpt_prod.* TO 'tigerpt_backup'@'localhost';
GRANT SELECT, LOCK TABLES, SHOW VIEW ON tigerpt_dev.* TO 'tigerpt_backup'@'localhost';
FLUSH PRIVILEGES;

-- ==============================================
-- NOTES
-- ==============================================
-- 1. Change all passwords before production use
-- 2. Grails will automatically create tables via GORM
-- 3. For production, consider using environment variables for passwords
-- 4. Implement regular backups for PHI data
-- 5. Enable MySQL binary logging for point-in-time recovery
-- 6. Configure MySQL for SSL/TLS connections
-- 7. Implement audit logging for HIPAA compliance
