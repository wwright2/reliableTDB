// Configuration for plugin and custom bean definitions

grails.gorm.default.mapping = {
    id generator: 'identity'
}

// CORS configuration for REST API
grails.cors.enabled = true
grails.cors.allowedOrigins = ['*']
grails.cors.allowedMethods = ['GET', 'POST', 'PUT', 'DELETE', 'OPTIONS']
grails.cors.allowedHeaders = ['*']

// Hibernate configuration
grails.gorm.failOnError = true
grails.gorm.autoFlush = false
