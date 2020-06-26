package exercise

/*
transactional manages persistence and other complicated operations that should be completed together
(and potentially rolled-back if any one of the steps fails)
 */
import grails.gorm.transactions.Transactional
import org.apache.commons.lang.time.DateUtils

import java.time.LocalDate
import java.time.Period
import java.time.ZoneId

class AnnouncementController {

    static namespace = 'scaffolding'
    static scaffold = Announcement

    static allowedMethods = [
            save               : 'POST',
            update             : 'PUT',
            uploadFeaturedImage: 'POST',
            delete             : 'DELETE']

    def uploadAnnouncementFeaturedImageService
    def getAnnouncementByIdService
    def announcementService
    def filteredAnnouncements
    List list = ['finalization date (soon)', 'finalization date (farther)']

    def index(Integer max) {
        // params object available to all controllers. Contains a map of any URL parameters on the request
        params.max = Math.min(max ?: 10, 100)

        // takes an object to return to the requestor
        respond Announcement.list(params),
                model: [announcementCount    : Announcement.count(),
                        filteredAnnouncements: Announcement.list().sort { a, b ->
                            b.finalizationDate <=> b.finalizationDate
                        }, list              : list]
    }

    def timesLeft(Date finalizationDate) {
        long estDateInLong = new Date().getTime()
        long currentTimeinLong = finalizationDate.getTime()
        long diff = (long) (currentTimeinLong - estDateInLong);

        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localDate = finalizationDate.toInstant().atZone(defaultZoneId).toLocalDate();
        LocalDate now = LocalDate.now()
        Period period = Period.between(now, localDate)

        long diffDay = diff / (24 * 60 * 60 * 1000)
        diff = diff - (diffDay * 24 * 60 * 60 * 1000)
        //will give you remaining milli seconds relating to hours,minutes and seconds
        long diffHours = diff / (60 * 60 * 1000)
        diff = diff - (diffHours * 60 * 60 * 1000)
        long diffMinutes = diff / (60 * 1000)
        diff = diff - (diffMinutes * 60 * 1000)
        long diffSeconds = diff / 1000
        diff = diff - (diffSeconds * 1000)
        String monthOderMonths = ""
        long sum = (period.getDays() * 24) + finalizationDate.hours - new Date().hours

        if (period.getMonths() <= 0) {
            if (sum <= 24) {
                return "today"
            }
            if (sum > 24 && sum < 48) {
                return "tomorrow"
            }
            return period.getDays() + "d " + diffHours + "h " + diffMinutes + "m "
        }
        return period.getMonths() + "month " + period.getDays() + "d " + diffHours + "h "
    }

    // takes an object to return to the requestor
    def show(Announcement announcement) {
        respond announcement, model: [miIdmasMil: getAnnouncementByIdService.devuelveId(announcement)]
    }

    // takes an object to return to the requestor
    def sendEmail(Announcement announcement) {
        respond announcement
    }

    @SuppressWarnings(['FactoryMethodName', 'GrailsMassAssignment'])
    def create() {
        respond new Announcement(params)
    }

    @Transactional
    def save(Announcement announcement) {
        announcement.finalizationDate = DateUtils.setHours(announcement.finalizationDate, 23)
        announcement.finalizationDate = DateUtils.setMinutes(announcement.finalizationDate, 59)
        announcement.finalizationDate = DateUtils.setSeconds(announcement.finalizationDate, 59)
        announcement.finalizationDate = DateUtils.setMilliseconds(announcement.finalizationDate, 99)

        if (announcement == null) {
            render status: HttpStatus.NOT_FOUND
            return
        }
        if (announcement.hasErrors()) {
            respond announcement.errors, view: 'create', model: [errorMessagess: getAnnouncementByIdService.errorMessages]
            return
        }

        announcement.save flush: true

        // instance of the Servlet API’s HttpServletRequest class
        request.withFormat {
            form multipartForm {
                redirect announcement
            }

            /*
                The render method is a less sophisticated version of respond - it doesn’t perform content negotiation,
                so one has to specify exactly what you want to render. One can render plain text, a view or template,
                an HTTP response code, or any object that has a String representation.
             */
            '*' { respond announcement, [status: CREATED] }
        }
    }

    def edit(Announcement announcement) {
        respond announcement
    }

    @Transactional
    def update(Announcement announcement) {
        if (announcement == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (announcement.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond announcement.errors, view: 'edit', model: [errorMessagess: getAnnouncementByIdService.errorMessages]
            return
        }

        announcement.save flush: true

        request.withFormat {
            form multipartForm {

                flash.message = message(code: 'default.updated.message',
                        args: [message(code: 'announcement.label', default: 'Announcement'), announcement.id])
                redirect announcement
            }
            '*' { respond announcement, [status: OK] }
        }
    }

    @Transactional
    def delete(Announcement announcement) {
        if (announcement == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        announcement.delete flush: true

        request.withFormat {
            form multipartForm {
                //<5>
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'announcement.label', default: 'Announcement'), announcement.id])
                redirect action: 'index', method: 'GET' // <6>
            }
            '*' { render status: NO_CONTENT } // <7>
        }
    }

    def search = {
        render(view: 'index')
    }

    def searchResults = {
        def entryCriteria = Announcement.createCriteria()
        def filteredAnnouncements = entryCriteria.list {
            if (params?.searchfield) {
                ilike("articleName", "%${params.searchfield}%")
            }
        }
        render(view: 'index', model: ['filteredAnnouncements': filteredAnnouncements, 'list': list])
    }

    @Transactional(readOnly = true)
    def editFeaturedImage(Announcement announcement) {
        respond announcement
    }

    @Transactional(readOnly = true)
    def featuredImage(Announcement announcement) {
        if (announcement == null || announcement.featuredImageBytes == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }
        render file: announcement.featuredImageBytes, contentType: announcement.featuredImageContentType
    }

    def uploadFeaturedImage(FeaturedImageCommand cmd) {
        if (cmd == null) {
            notFound()
            return
        }
        if (cmd.hasErrors()) {
            respond(cmd.errors, model: [announcement: cmd], view: 'editFeaturedImage')
            return
        }


        def announcement = uploadAnnouncementFeaturedImageService.uploadFeatureImage(cmd)

        if (announcement == null) {
            println "***** hoo" + announcement.errors.allErrors*.toString().join(" ")
            notFound()
            return
        }

        if (announcement.hasErrors()) {
            respond(announcement.errors, model: [announcement: announcement], view: 'show')
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'announcement.label', default: 'Announcement'), announcement.id])
                redirect announcement
            }
            '*' { respond announcement, [status: OK] }
        }
    }

    def newest() {
        render(view: 'index', model: ['filteredAnnouncements': Announcement.list().sort {
            it.finalizationDate
        }, list                                              : list])
    }

    def oldest() {
        render(view: 'index', model: ['filteredAnnouncements'                   : Announcement.list().
                sort { a, b -> b.finalizationDate <=> a.finalizationDate }, list: list])
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {

                flash.message = message(code: 'default.not.found.message', args: [message(code: 'announcement.label',
                        default: 'Announcement'), params.id])
                redirect action: 'index', method: 'GET'
            }
        }
    }

}