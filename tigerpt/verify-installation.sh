#!/bin/bash
# TigerPT Installation Verification Script
# Run this script to verify your installation is ready

echo "╔════════════════════════════════════════════════════════════╗"
echo "║        TigerPT Installation Verification Script           ║"
echo "║        Trauma Registry System - NTDS 2023                  ║"
echo "╚════════════════════════════════════════════════════════════╝"
echo ""

# Color codes
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

# Counters
PASSED=0
FAILED=0

# Function to check command
check_command() {
    if command -v $1 &> /dev/null; then
        echo -e "${GREEN}✓${NC} $2 is installed"
        ((PASSED++))
        return 0
    else
        echo -e "${RED}✗${NC} $2 is NOT installed"
        ((FAILED++))
        return 1
    fi
}

# Function to check version
check_version() {
    local version=$($1 2>&1)
    echo -e "${GREEN}  → Version: ${NC}$version"
}

echo "Checking prerequisites..."
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo ""

# Check Java
echo "1. Checking Java..."
if check_command java "Java"; then
    check_version "java -version"
    
    # Check Java version is 11+
    JAVA_VERSION=$(java -version 2>&1 | awk -F '"' '/version/ {print $2}' | cut -d'.' -f1)
    if [ "$JAVA_VERSION" -ge 11 ]; then
        echo -e "${GREEN}  → Java version is compatible (11+)${NC}"
    else
        echo -e "${RED}  → Java version is too old. Need Java 11+${NC}"
        ((FAILED++))
        ((PASSED--))
    fi
fi
echo ""

# Check MySQL
echo "2. Checking MySQL..."
if check_command mysql "MySQL Client"; then
    check_version "mysql --version"
    
    # Try to connect to MySQL
    if mysql -u root --password="" -e "SELECT 1" &> /dev/null || \
       mysql -u root -e "SELECT 1" &> /dev/null; then
        echo -e "${GREEN}  → Can connect to MySQL${NC}"
        
        # Check if database exists
        if mysql -u root -e "USE tigerpt_dev" &> /dev/null; then
            echo -e "${GREEN}  → tigerpt_dev database exists${NC}"
        else
            echo -e "${YELLOW}  → tigerpt_dev database not found (will be created)${NC}"
        fi
    else
        echo -e "${YELLOW}  → Cannot connect to MySQL (may need password)${NC}"
    fi
fi
echo ""

# Check Gradle wrapper
echo "3. Checking Gradle..."
if [ -f "./gradlew" ]; then
    echo -e "${GREEN}✓${NC} Gradle wrapper found"
    ((PASSED++))
    if [ -x "./gradlew" ]; then
        echo -e "${GREEN}  → Gradle wrapper is executable${NC}"
    else
        echo -e "${YELLOW}  → Gradle wrapper needs execute permission${NC}"
        echo -e "${YELLOW}  → Run: chmod +x gradlew${NC}"
    fi
else
    echo -e "${RED}✗${NC} Gradle wrapper NOT found"
    ((FAILED++))
fi
echo ""

# Check project structure
echo "4. Checking project structure..."
REQUIRED_DIRS=(
    "grails-app/domain/com/tigerpt"
    "grails-app/controllers/com/tigerpt"
    "grails-app/services/com/tigerpt"
    "grails-app/conf"
    "database"
)

ALL_DIRS_EXIST=true
for dir in "${REQUIRED_DIRS[@]}"; do
    if [ -d "$dir" ]; then
        echo -e "${GREEN}✓${NC} $dir exists"
    else
        echo -e "${RED}✗${NC} $dir NOT found"
        ALL_DIRS_EXIST=false
    fi
done

if [ "$ALL_DIRS_EXIST" = true ]; then
    ((PASSED++))
else
    ((FAILED++))
fi
echo ""

# Check configuration files
echo "5. Checking configuration files..."
CONFIG_FILES=(
    "build.gradle"
    "grails-app/conf/application.yml"
    "gradle.properties"
)

ALL_FILES_EXIST=true
for file in "${CONFIG_FILES[@]}"; do
    if [ -f "$file" ]; then
        echo -e "${GREEN}✓${NC} $file exists"
    else
        echo -e "${RED}✗${NC} $file NOT found"
        ALL_FILES_EXIST=false
    fi
done

if [ "$ALL_FILES_EXIST" = true ]; then
    ((PASSED++))
else
    ((FAILED++))
fi
echo ""

# Check domain classes
echo "6. Checking domain classes..."
DOMAIN_CLASSES=(
    "grails-app/domain/com/tigerpt/Patient.groovy"
    "grails-app/domain/com/tigerpt/InjuryInformation.groovy"
    "grails-app/domain/com/tigerpt/EmergencyDepartmentInfo.groovy"
    "grails-app/domain/com/tigerpt/Disposition.groovy"
    "grails-app/domain/com/tigerpt/HospitalProcedure.groovy"
)

DOMAIN_COUNT=0
for class in "${DOMAIN_CLASSES[@]}"; do
    if [ -f "$class" ]; then
        ((DOMAIN_COUNT++))
    fi
done

echo -e "${GREEN}✓${NC} Found $DOMAIN_COUNT/5 domain classes"
if [ $DOMAIN_COUNT -eq 5 ]; then
    ((PASSED++))
else
    ((FAILED++))
fi
echo ""

# Check database scripts
echo "7. Checking database scripts..."
if [ -f "database/setup.sql" ]; then
    echo -e "${GREEN}✓${NC} Database setup script found"
    ((PASSED++))
else
    echo -e "${RED}✗${NC} Database setup script NOT found"
    ((FAILED++))
fi

if [ -f "database/sample-data.sql" ]; then
    echo -e "${GREEN}✓${NC} Sample data script found"
else
    echo -e "${YELLOW}⚠${NC} Sample data script not found (optional)"
fi
echo ""

# Check documentation
echo "8. Checking documentation..."
DOC_FILES=(
    "README.md"
    "QUICKSTART.md"
    "NTDS_MAPPING.md"
)

DOC_COUNT=0
for doc in "${DOC_FILES[@]}"; do
    if [ -f "$doc" ]; then
        ((DOC_COUNT++))
        echo -e "${GREEN}✓${NC} $doc exists"
    fi
done

if [ $DOC_COUNT -eq 3 ]; then
    ((PASSED++))
else
    ((FAILED++))
fi
echo ""

# Port check
echo "9. Checking if port 8080 is available..."
if command -v lsof &> /dev/null; then
    if lsof -Pi :8080 -sTCP:LISTEN -t >/dev/null 2>&1; then
        echo -e "${YELLOW}⚠${NC} Port 8080 is in use"
        echo -e "${YELLOW}  → You may need to stop the service or use a different port${NC}"
    else
        echo -e "${GREEN}✓${NC} Port 8080 is available"
        ((PASSED++))
    fi
else
    echo -e "${YELLOW}⚠${NC} Cannot check port (lsof not available)"
fi
echo ""

# Summary
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo "VERIFICATION SUMMARY"
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo ""
echo -e "Tests Passed: ${GREEN}$PASSED${NC}"
echo -e "Tests Failed: ${RED}$FAILED${NC}"
echo ""

if [ $FAILED -eq 0 ]; then
    echo -e "${GREEN}╔════════════════════════════════════════════════════════════╗${NC}"
    echo -e "${GREEN}║  ✓ All checks passed! Your installation looks good.       ║${NC}"
    echo -e "${GREEN}╚════════════════════════════════════════════════════════════╝${NC}"
    echo ""
    echo "Next steps:"
    echo "1. Review configuration in grails-app/conf/application.yml"
    echo "2. Set up MySQL database: mysql -u root -p < database/setup.sql"
    echo "3. Build the project: ./gradlew clean build"
    echo "4. Run the application: ./gradlew bootRun"
    echo "5. Access at: http://localhost:8080"
    echo ""
    echo "For detailed instructions, see QUICKSTART.md"
    exit 0
else
    echo -e "${RED}╔════════════════════════════════════════════════════════════╗${NC}"
    echo -e "${RED}║  ✗ Some checks failed. Please review the errors above.    ║${NC}"
    echo -e "${RED}╚════════════════════════════════════════════════════════════╝${NC}"
    echo ""
    echo "Common fixes:"
    echo "- Install Java 11+: sudo apt install openjdk-11-jdk"
    echo "- Install MySQL: sudo apt install mysql-server"
    echo "- Make gradlew executable: chmod +x gradlew"
    echo ""
    echo "For detailed instructions, see README.md"
    exit 1
fi
