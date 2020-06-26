package exercise

import grails.validation.Validateable

class Announcement implements Validateable {

    String articleName
    String articleDescription
    int quantity
    String address
    String email
    String username
    String phoneNumber
    byte[] featuredImageBytes
    String featuredImageContentType

    Date finalizationDate

    static constraints = {

        articleName size: 5..100, blank: false, nullable: false
        articleDescription size: 5..255, blank: true, nullable: true
        quantity min: 1, max: 1000, blank: false, nullable: false
        address size: 5..150, blank: true, nullable: true
        email email: true, blank: false, nullable: false
        username size: 5..100, blank: true, nullable: true
        phoneNumber size: 6..20, blank: true, nullable: true
        finalizationDate min: new Date().clearTime(), max: new Date().plus(360), blank: false, nullable: false
        featuredImageBytes nullable: true
        featuredImageContentType nullable: true
    }

    Announcement() {
        finalizationDate = new Date().plus(30)
        quantity = 1
    }
    static mapping = {
        featuredImageBytes column: 'featured_image_bytes', sqlType: 'longblob'
    }
}
