package toastytdb

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TraumaAdmissionController {

    TraumaAdmissionService traumaAdmissionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond traumaAdmissionService.list(params), model:[traumaAdmissionCount: traumaAdmissionService.count()]
    }

    def show(Long id) {
        respond traumaAdmissionService.get(id)
    }

    def create() {
        respond new TraumaAdmission(params)
    }

    def save(TraumaAdmission traumaAdmission) {
        if (traumaAdmission == null) {
            notFound()
            return
        }

        try {
            traumaAdmissionService.save(traumaAdmission)
        } catch (ValidationException e) {
            respond traumaAdmission.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'traumaAdmission.label', default: 'TraumaAdmission'), traumaAdmission.id])
                redirect traumaAdmission
            }
            '*' { respond traumaAdmission, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond traumaAdmissionService.get(id)
    }

    def update(TraumaAdmission traumaAdmission) {
        if (traumaAdmission == null) {
            notFound()
            return
        }

        try {
            traumaAdmissionService.save(traumaAdmission)
        } catch (ValidationException e) {
            respond traumaAdmission.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'traumaAdmission.label', default: 'TraumaAdmission'), traumaAdmission.id])
                redirect traumaAdmission
            }
            '*'{ respond traumaAdmission, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        traumaAdmissionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'traumaAdmission.label', default: 'TraumaAdmission'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'traumaAdmission.label', default: 'TraumaAdmission'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
