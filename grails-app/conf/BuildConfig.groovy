grails.project.work.dir = 'target'

grails.project.dependency.resolution = {

    inherits 'global'
    log 'warn'

    repositories {
        grailsCentral()
    }

    plugins {
        build ':release:2.2.1', ':rest-client-builder:1.0.3', {
            export = false
        }
    }

//    grails.project.repos.default="nexusvirtualsw"
//    grails.project.repos.nexusvirtualsw.url = "http://nexus.virtualsw.es/nexus/content/repositories/grails_virtualsw/"
//    grails.project.repos.nexusvirtualsw.type = "maven"
//    grails.project.repos.nexusvirtualsw.username = "admin"
//    grails.project.repos.nexusvirtualsw.password = "qwe123546"

    // grails.project.repos.nexusvirtualsw.portal = "grailsCentral"
}

grails.project.repos.default = "nexusvirtualswgrails"
