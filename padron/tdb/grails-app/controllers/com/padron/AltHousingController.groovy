package com.padron

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class AltHousingController {

    AltHousingService altHousingService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond altHousingService.list(params), model:[altHousingCount: altHousingService.count()]
    }

    def show(Long id) {
        respond altHousingService.get(id)
    }

    def create() {
        respond new AltHousing(params)
    }

    def save(AltHousing altHousing) {
        if (altHousing == null) {
            notFound()
            return
        }

        try {
            altHousingService.save(altHousing)
        } catch (ValidationException e) {
            respond altHousing.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'altHousing.label', default: 'AltHousing'), altHousing.id])
                redirect altHousing
            }
            '*' { respond altHousing, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond altHousingService.get(id)
    }

    def update(AltHousing altHousing) {
        if (altHousing == null) {
            notFound()
            return
        }

        try {
            altHousingService.save(altHousing)
        } catch (ValidationException e) {
            respond altHousing.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'altHousing.label', default: 'AltHousing'), altHousing.id])
                redirect altHousing
            }
            '*'{ respond altHousing, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        altHousingService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'altHousing.label', default: 'AltHousing'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'altHousing.label', default: 'AltHousing'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
