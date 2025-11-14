package com.tigerpt

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: 'home', action: 'index')
        "500"(view:'/error')
        "404"(view:'/notFound')
        
        // REST API endpoints
        "/api/patients"(resources: 'patient')
        "/api/injuries"(resources: 'injury')
        "/api/diagnoses"(resources: 'diagnosis')
        "/api/outcomes"(resources: 'outcome')
    }
}
