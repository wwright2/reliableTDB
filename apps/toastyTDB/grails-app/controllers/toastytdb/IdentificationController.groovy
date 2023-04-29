package toastytdb

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class IdentificationController {

    IdentificationService identificationService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond identificationService.list(params), model:[identificationCount: identificationService.count()]
    }

    def show(Long id) {
        respond identificationService.get(id)
    }

    def create() {
        respond new Identification(params)
    }

    def save(Identification identification) {
        if (identification == null) {
            notFound()
            return
        }

        try {
            identificationService.save(identification)
        } catch (ValidationException e) {
            respond identification.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'identification.label', default: 'Identification'), identification.id])
                redirect identification
            }
            '*' { respond identification, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond identificationService.get(id)
    }

    def update(Identification identification) {
        if (identification == null) {
            notFound()
            return
        }

        try {
            identificationService.save(identification)
        } catch (ValidationException e) {
            respond identification.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'identification.label', default: 'Identification'), identification.id])
                redirect identification
            }
            '*'{ respond identification, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        identificationService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'identification.label', default: 'Identification'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'identification.label', default: 'Identification'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
