package com.tigerpt.domain

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class InjuryController {

    InjuryService injuryService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond injuryService.list(params), model:[injuryCount: injuryService.count()]
    }

    def show(Long id) {
        respond injuryService.get(id)
    }

    def create() {
        respond new Injury(params)
    }

    def save(Injury injury) {
        if (injury == null) {
            notFound()
            return
        }

        try {
            injuryService.save(injury)
        } catch (ValidationException e) {
            respond injury.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'injury.label', default: 'Injury'), injury.id])
                redirect injury
            }
            '*' { respond injury, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond injuryService.get(id)
    }

    def update(Injury injury) {
        if (injury == null) {
            notFound()
            return
        }

        try {
            injuryService.save(injury)
        } catch (ValidationException e) {
            respond injury.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'injury.label', default: 'Injury'), injury.id])
                redirect injury
            }
            '*'{ respond injury, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        injuryService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'injury.label', default: 'Injury'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'injury.label', default: 'Injury'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
