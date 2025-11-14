package com.tigerpt.domain

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class HospitalProcedureController {

    HospitalProcedureService hospitalProcedureService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond hospitalProcedureService.list(params), model:[hospitalProcedureCount: hospitalProcedureService.count()]
    }

    def show(Long id) {
        respond hospitalProcedureService.get(id)
    }

    def create() {
        respond new HospitalProcedure(params)
    }

    def save(HospitalProcedure hospitalProcedure) {
        if (hospitalProcedure == null) {
            notFound()
            return
        }

        try {
            hospitalProcedureService.save(hospitalProcedure)
        } catch (ValidationException e) {
            respond hospitalProcedure.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'hospitalProcedure.label', default: 'HospitalProcedure'), hospitalProcedure.id])
                redirect hospitalProcedure
            }
            '*' { respond hospitalProcedure, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond hospitalProcedureService.get(id)
    }

    def update(HospitalProcedure hospitalProcedure) {
        if (hospitalProcedure == null) {
            notFound()
            return
        }

        try {
            hospitalProcedureService.save(hospitalProcedure)
        } catch (ValidationException e) {
            respond hospitalProcedure.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'hospitalProcedure.label', default: 'HospitalProcedure'), hospitalProcedure.id])
                redirect hospitalProcedure
            }
            '*'{ respond hospitalProcedure, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        hospitalProcedureService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'hospitalProcedure.label', default: 'HospitalProcedure'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'hospitalProcedure.label', default: 'HospitalProcedure'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
