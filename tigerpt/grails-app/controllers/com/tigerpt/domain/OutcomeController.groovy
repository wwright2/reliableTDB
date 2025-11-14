package com.tigerpt.domain

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class OutcomeController {

    OutcomeService outcomeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond outcomeService.list(params), model:[outcomeCount: outcomeService.count()]
    }

    def show(Long id) {
        respond outcomeService.get(id)
    }

    def create() {
        respond new Outcome(params)
    }

    def save(Outcome outcome) {
        if (outcome == null) {
            notFound()
            return
        }

        try {
            outcomeService.save(outcome)
        } catch (ValidationException e) {
            respond outcome.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'outcome.label', default: 'Outcome'), outcome.id])
                redirect outcome
            }
            '*' { respond outcome, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond outcomeService.get(id)
    }

    def update(Outcome outcome) {
        if (outcome == null) {
            notFound()
            return
        }

        try {
            outcomeService.save(outcome)
        } catch (ValidationException e) {
            respond outcome.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'outcome.label', default: 'Outcome'), outcome.id])
                redirect outcome
            }
            '*'{ respond outcome, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        outcomeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'outcome.label', default: 'Outcome'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'outcome.label', default: 'Outcome'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
