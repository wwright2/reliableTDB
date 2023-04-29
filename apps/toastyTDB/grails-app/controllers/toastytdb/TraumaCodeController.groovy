package toastytdb

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TraumaCodeController {

    TraumaCodeService traumaCodeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond traumaCodeService.list(params), model:[traumaCodeCount: traumaCodeService.count()]
    }

    def show(Long id) {
        respond traumaCodeService.get(id)
    }

    def create() {
        respond new TraumaCode(params)
    }

    def save(TraumaCode traumaCode) {
        if (traumaCode == null) {
            notFound()
            return
        }

        try {
            traumaCodeService.save(traumaCode)
        } catch (ValidationException e) {
            respond traumaCode.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'traumaCode.label', default: 'TraumaCode'), traumaCode.id])
                redirect traumaCode
            }
            '*' { respond traumaCode, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond traumaCodeService.get(id)
    }

    def update(TraumaCode traumaCode) {
        if (traumaCode == null) {
            notFound()
            return
        }

        try {
            traumaCodeService.save(traumaCode)
        } catch (ValidationException e) {
            respond traumaCode.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'traumaCode.label', default: 'TraumaCode'), traumaCode.id])
                redirect traumaCode
            }
            '*'{ respond traumaCode, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        traumaCodeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'traumaCode.label', default: 'TraumaCode'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'traumaCode.label', default: 'TraumaCode'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
