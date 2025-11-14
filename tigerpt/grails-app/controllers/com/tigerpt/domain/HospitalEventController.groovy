package com.tigerpt.domain

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class HospitalEventController {

    HospitalEventService hospitalEventService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond hospitalEventService.list(params), model:[hospitalEventCount: hospitalEventService.count()]
    }

    def show(Long id) {
        respond hospitalEventService.get(id)
    }

    def create() {
        respond new HospitalEvent(params)
    }

    def save(HospitalEvent hospitalEvent) {
        if (hospitalEvent == null) {
            notFound()
            return
        }

        try {
            hospitalEventService.save(hospitalEvent)
        } catch (ValidationException e) {
            respond hospitalEvent.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'hospitalEvent.label', default: 'HospitalEvent'), hospitalEvent.id])
                redirect hospitalEvent
            }
            '*' { respond hospitalEvent, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond hospitalEventService.get(id)
    }

    def update(HospitalEvent hospitalEvent) {
        if (hospitalEvent == null) {
            notFound()
            return
        }

        try {
            hospitalEventService.save(hospitalEvent)
        } catch (ValidationException e) {
            respond hospitalEvent.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'hospitalEvent.label', default: 'HospitalEvent'), hospitalEvent.id])
                redirect hospitalEvent
            }
            '*'{ respond hospitalEvent, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        hospitalEventService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'hospitalEvent.label', default: 'HospitalEvent'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'hospitalEvent.label', default: 'HospitalEvent'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
