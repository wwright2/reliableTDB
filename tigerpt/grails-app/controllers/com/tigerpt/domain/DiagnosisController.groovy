package com.tigerpt.domain

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class DiagnosisController {

    DiagnosisService diagnosisService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond diagnosisService.list(params), model:[diagnosisCount: diagnosisService.count()]
    }

    def show(Long id) {
        respond diagnosisService.get(id)
    }

    def create() {
        respond new Diagnosis(params)
    }

    def save(Diagnosis diagnosis) {
        if (diagnosis == null) {
            notFound()
            return
        }

        try {
            diagnosisService.save(diagnosis)
        } catch (ValidationException e) {
            respond diagnosis.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'diagnosis.label', default: 'Diagnosis'), diagnosis.id])
                redirect diagnosis
            }
            '*' { respond diagnosis, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond diagnosisService.get(id)
    }

    def update(Diagnosis diagnosis) {
        if (diagnosis == null) {
            notFound()
            return
        }

        try {
            diagnosisService.save(diagnosis)
        } catch (ValidationException e) {
            respond diagnosis.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'diagnosis.label', default: 'Diagnosis'), diagnosis.id])
                redirect diagnosis
            }
            '*'{ respond diagnosis, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        diagnosisService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'diagnosis.label', default: 'Diagnosis'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'diagnosis.label', default: 'Diagnosis'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
