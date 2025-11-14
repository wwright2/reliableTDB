package com.tigerpt.domain

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PreExistingConditionController {

    PreExistingConditionService preExistingConditionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond preExistingConditionService.list(params), model:[preExistingConditionCount: preExistingConditionService.count()]
    }

    def show(Long id) {
        respond preExistingConditionService.get(id)
    }

    def create() {
        respond new PreExistingCondition(params)
    }

    def save(PreExistingCondition preExistingCondition) {
        if (preExistingCondition == null) {
            notFound()
            return
        }

        try {
            preExistingConditionService.save(preExistingCondition)
        } catch (ValidationException e) {
            respond preExistingCondition.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'preExistingCondition.label', default: 'PreExistingCondition'), preExistingCondition.id])
                redirect preExistingCondition
            }
            '*' { respond preExistingCondition, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond preExistingConditionService.get(id)
    }

    def update(PreExistingCondition preExistingCondition) {
        if (preExistingCondition == null) {
            notFound()
            return
        }

        try {
            preExistingConditionService.save(preExistingCondition)
        } catch (ValidationException e) {
            respond preExistingCondition.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'preExistingCondition.label', default: 'PreExistingCondition'), preExistingCondition.id])
                redirect preExistingCondition
            }
            '*'{ respond preExistingCondition, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        preExistingConditionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'preExistingCondition.label', default: 'PreExistingCondition'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'preExistingCondition.label', default: 'PreExistingCondition'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
