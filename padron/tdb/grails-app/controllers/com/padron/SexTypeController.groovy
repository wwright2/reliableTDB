package com.padron

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SexTypeController {

    SexTypeService sexTypeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sexTypeService.list(params), model:[sexTypeCount: sexTypeService.count()]
    }

    def show(Long id) {
        respond sexTypeService.get(id)
    }

    def create() {
        respond new SexType(params)
    }

    def save(SexType sexType) {
        if (sexType == null) {
            notFound()
            return
        }

        try {
            sexTypeService.save(sexType)
        } catch (ValidationException e) {
            respond sexType.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sexType.label', default: 'SexType'), sexType.id])
                redirect sexType
            }
            '*' { respond sexType, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sexTypeService.get(id)
    }

    def update(SexType sexType) {
        if (sexType == null) {
            notFound()
            return
        }

        try {
            sexTypeService.save(sexType)
        } catch (ValidationException e) {
            respond sexType.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sexType.label', default: 'SexType'), sexType.id])
                redirect sexType
            }
            '*'{ respond sexType, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sexTypeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sexType.label', default: 'SexType'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sexType.label', default: 'SexType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
