package com.vogella.grails.guestbook


import grails.gorm.transactions.Transactional
import grails.validation.ValidationException

import static org.springframework.http.HttpStatus.*

@Transactional(readOnly = true)
class FeedbackController {

    FeedbackService feedbackService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond feedbackService.list(params), model:[feedbackCount: feedbackService.count()]
    }

    def show(Long id) {
        respond feedbackService.get(id)
    }

    def create() {
        respond new Feedback(params)
    }

    @Transactional
    def save(Feedback feedback) {
        if (feedback == null) {
            notFound()
            return
        }

        try {
            feedbackService.save(feedback)
        } catch (ValidationException e) {
            respond feedback.errors, view: 'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message',
                        args: [message(code: 'feedback.label',
                                default: 'Feedback'), feedback.id])
                redirect feedback
            }
            '*' { respond feedback, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond feedbackService.get(id)
    }

    @Transactional
    def update(Feedback feedback) {
        if (feedback == null) {
            notFound()
            return
        }

        try {
            feedbackService.save(feedback)
        } catch (ValidationException e) {
            respond feedback.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'feedback.label', default: 'Feedback'), feedback.id])
                redirect feedback
            }
            '*'{ respond feedback, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        feedbackService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'feedback.label', default: 'Feedback'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'feedback.label', default: 'Feedback'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
