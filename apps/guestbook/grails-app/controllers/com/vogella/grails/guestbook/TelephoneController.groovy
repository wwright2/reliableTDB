package com.vogella.grails.guestbook

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TelephoneController {

    TelephoneService phoneService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        if (phoneService != null) {
            respond phoneService.list(params), model: [phoneCount: phoneService.count()]
        }
    }

    def show(Long id) {
        respond phoneService.get(id)
    }

    def create() {
        print("create Telephone =>",params.all)
        respond new Telephone(params)
    }

    def save(Telephone phone) {
        if (phone == null) {
            notFound()
            return
        }

        try {
            phoneService.save(phone)
        } catch (ValidationException e) {
            respond phone.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'phone.label', default: 'Telephone'), phone.id])
                redirect phone
            }
            '*' { respond phone, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond phoneService.get(id)
    }

    def update(Telephone phone) {
        if (phone == null) {
            notFound()
            return
        }

        try {
            phoneService.save(phone)
        } catch (ValidationException e) {
            respond phone.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'phone.label', default: 'Phone'), phone.id])
                redirect phone
            }
            '*'{ respond phone, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        phoneService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'phone.label', default: 'Telephone'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'phone.label', default: 'Telephone'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
