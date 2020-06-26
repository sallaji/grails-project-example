package exercise

import grails.gorm.transactions.Transactional


@Transactional
class GetAnnouncementByIdService {


    def serviceMethod() {

    }

    def devuelveId(Announcement announcement) {
        return announcement.id + 1000
    }

    def errorMessages = [
            "the name must contain between 5 and 100 characters",
            "the description must contain between 5 and 255 characters",
            "Only 1 to 100 articles allowed",
            "the address must contain between 5 and 150 characters",
            "please enter a valid email address",
            "the username must contain 5 to 100 characters",
            "the phone number must contain 6 to 20 characters",
            "the date must be between today and 1 year"]
}
