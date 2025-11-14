# TigerPT Complete CRUD Views Package

## Contents

This package contains complete CRUD (Create, Read, Update, Delete) views and controllers for all domain classes:

1. **Injury** - Complete (4 views)
2. **Diagnosis** - See DIAGNOSIS_VIEWS.txt (split into 4 files)
3. **HospitalProcedure** - See HOSPITAL_PROCEDURE_VIEWS.txt
4. **HospitalEvent** - See HOSPITAL_EVENT_VIEWS.txt  
5. **PreExistingCondition** - See PRE_EXISTING_CONDITION_VIEWS.txt
6. **Outcome** - See OUTCOME_VIEWS.txt

## Installation

### Step 1: Extract Views
Copy view directories to:
```
your-tigerpt/grails-app/views/
```

### Step 2: Create Controllers
For each domain, create a controller in:
```
your-tigerpt/grails-app/controllers/com/tigerpt/controller/
```

Controller template:
```groovy
package com.tigerpt.controller

import com.tigerpt.domain.DOMAIN_CLASS_NAME
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class DOMAIN_NAMEController {
    
    DOMAIN_NAMEService domainService
    
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond domainService.list(params), model:[domainList: domainService.count()]
    }
    
    def show(Long id) {
        respond domainService.get(id)
    }
    
    def create() {
        respond new DOMAIN_CLASS_NAME(params)
    }
    
    def save(DOMAIN_CLASS_NAME domain) {
        if (domain == null) {
            notFound()
            return
        }
        try {
            domainService.save(domain)
        } catch (ValidationException e) {
            respond domain.errors, view:'create'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = "Created successfully"
                redirect domain
            }
            '*' { respond domain, [status: CREATED] }
        }
    }
    
    def edit(Long id) {
        respond domainService.get(id)
    }
    
    def update(DOMAIN_CLASS_NAME domain) {
        if (domain == null) {
            notFound()
            return
        }
        try {
            domainService.save(domain)
        } catch (ValidationException e) {
            respond domain.errors, view:'edit'
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = "Updated successfully"
                redirect domain
            }
            '*'{ respond domain, [status: OK] }
        }
    }
    
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }
        domainService.delete(id)
        request.withFormat {
            form multipartForm {
                flash.message = "Deleted successfully"
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }
    
    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = "Not found"
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
```

### Step 3: Create Services
For each domain, create a service in:
```
your-tigerpt/grails-app/services/com/tigerpt/service/
```

Service template:
```groovy
package com.tigerpt.service

import com.tigerpt.domain.DOMAIN_CLASS_NAME
import grails.gorm.services.Service

@Service(DOMAIN_CLASS_NAME)
interface DOMAIN_NAMEService {
    DOMAIN_CLASS_NAME get(Serializable id)
    List<DOMAIN_CLASS_NAME> list(Map args)
    Long count()
    void delete(Serializable id)
    DOMAIN_CLASS_NAME save(DOMAIN_CLASS_NAME domain)
}
```

## Quick Setup Script

Run this in your tigerpt directory:

```bash
# Copy injury views (already complete)
cp -r all-crud-views/injury grails-app/views/

# Create other view directories
mkdir -p grails-app/views/{diagnosis,hospitalProcedure,hospitalEvent,preExistingCondition,outcome}

# Split the combined view files into individual files as shown in each .txt file
```

## Controllers Needed

Create these controllers:
- InjuryController.groovy
- DiagnosisController.groovy  
- HospitalProcedureController.groovy
- HospitalEventController.groovy
- PreExistingConditionController.groovy
- OutcomeController.groovy

## Services Needed

Create these services:
- InjuryService.groovy
- DiagnosisService.groovy
- HospitalProcedureService.groovy
- HospitalEventService.groovy
- PreExistingConditionService.groovy
- OutcomeService.groovy

## URL Mappings

Ensure your UrlMappings.groovy includes default mappings:
```groovy
"/$controller/$action?/$id?(.$format)?"{
    constraints {
        // apply constraints here
    }
}
```

## Navigation

Add links to your main index.gsp:
```gsp
<g:link controller="injury">Injuries</g:link>
<g:link controller="diagnosis">Diagnoses</g:link>
<g:link controller="hospitalProcedure">Procedures</g:link>
<g:link controller="hospitalEvent">Events</g:link>
<g:link controller="preExistingCondition">Pre-existing Conditions</g:link>
<g:link controller="outcome">Outcomes</g:link>
```

