package com.padron

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class StateController {

    StateService stateService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond stateService.list(params), model:[stateCount: stateService.count()]
    }

    def show(Long id) {
        respond stateService.get(id)
    }

    def create() {
        respond new State(params)
    }

    def save(State state) {
        if (state == null) {
            notFound()
            return
        }

        try {
            stateService.save(state)
        } catch (ValidationException e) {
            respond state.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'state.label', default: 'State'), state.id])
                redirect state
            }
            '*' { respond state, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond stateService.get(id)
    }

    def update(State state) {
        if (state == null) {
            notFound()
            return
        }

        try {
            stateService.save(state)
        } catch (ValidationException e) {
            respond state.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'state.label', default: 'State'), state.id])
                redirect state
            }
            '*'{ respond state, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        stateService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'state.label', default: 'State'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'state.label', default: 'State'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
