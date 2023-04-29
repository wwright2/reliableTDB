package toastytdb

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CaseProcedureController {

    CaseProcedureService caseProcedureService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond caseProcedureService.list(params), model:[caseProcedureCount: caseProcedureService.count()]
    }

    def show(Long id) {
        respond caseProcedureService.get(id)
    }

    def create() {
        respond new CaseProcedure(params)
    }

    def save(CaseProcedure caseProcedure) {
        if (caseProcedure == null) {
            notFound()
            return
        }

        try {
            caseProcedureService.save(caseProcedure)
        } catch (ValidationException e) {
            respond caseProcedure.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'caseProcedure.label', default: 'CaseProcedure'), caseProcedure.id])
                redirect caseProcedure
            }
            '*' { respond caseProcedure, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond caseProcedureService.get(id)
    }

    def update(CaseProcedure caseProcedure) {
        if (caseProcedure == null) {
            notFound()
            return
        }

        try {
            caseProcedureService.save(caseProcedure)
        } catch (ValidationException e) {
            respond caseProcedure.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'caseProcedure.label', default: 'CaseProcedure'), caseProcedure.id])
                redirect caseProcedure
            }
            '*'{ respond caseProcedure, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        caseProcedureService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'caseProcedure.label', default: 'CaseProcedure'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'caseProcedure.label', default: 'CaseProcedure'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
