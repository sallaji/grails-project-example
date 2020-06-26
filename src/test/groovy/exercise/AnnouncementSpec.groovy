package exercise

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class AnnouncementSpec extends Specification implements DomainUnitTest<Announcement> {

    def setup() {
    }

    def cleanup() {
    }

    void 'test articleName cannot be null'() {
        when:
        domain.articleName = null

        then:
        !domain.validate(['articleName'])
        domain.errors['articleName'].code == 'nullable'
    }

    void 'test name cannot be blank'() {
        when:
        domain.articleName = ''

        then:
        !domain.validate(['articleName'])
    }

    void 'test articleName can have a maximum of 100 characters'() {
        when: 'for a string of 100 characters'
        String str = 's' * 101
        domain.articleName = str

        then: 'articleName validation fails'
        !domain.validate(['articleName'])
        domain.errors['articleName'].code == 'size.toobig'

        when: 'for a string of 100 characters'
        str = 's' * 100
        domain.articleName = str

        then: 'name validation passes'
        domain.validate(['articleName'])
    }

    void 'test articleName cannot have less than 5 characters'() {
        when: 'for a string of 4 characters'
        String str = 's' * 4
        domain.articleName = str

        then: 'articleName validation fails'
        !domain.validate(['articleName'])
        domain.errors['articleName'].code == 'size.toosmall'

        when: 'for a string of 5 characters'
        str = 's' * 5
        domain.articleName = str

        then: 'name validation passes'
        domain.validate(['articleName'])
    }


    void 'test quantity cannot be 0'() {
        when:
        domain.quantity = 0

        then:
        !domain.validate(['quantity'])
    }

    void 'test quantity cannot be greather than 1000'() {
        when:
        domain.quantity = 1001

        then:
        !domain.validate(['quantity'])
    }

    void 'test articleDescription can have a maximum of 255 characters'() {
        when: 'for a string of 100 characters'
        String str = 's' * 256
        domain.articleDescription = str

        then: 'articleDescription validation fails'
        !domain.validate(['articleDescription'])
        domain.errors['articleDescription'].code == 'size.toobig'

        when: 'for a string of 255 characters'
        str = 's' * 255
        domain.articleDescription = str

        then: 'articleDescription validation passes'
        domain.validate(['articleDescription'])
    }

    void 'test username can have a maximum of 100 characters'() {
        when: 'for a string of 100 characters'
        String str = 's' * 101
        domain.username = str

        then: 'username validation fails'
        !domain.validate(['username'])
        domain.errors['username'].code == 'size.toobig'

        when: 'for a string of 100 characters'
        str = 's' * 100
        domain.username = str

        then: 'username validation passes'
        domain.validate(['username'])
    }

    void 'test username can have a minimum of 5 characters'() {
        when: 'for a string of 4 characters'
        String str = 's' * 4
        domain.username = str

        then: 'username validation fails'
        !domain.validate(['username'])
        domain.errors['username'].code == 'size.toosmall'

        when: 'for a string of 5 characters'
        str = 's' * 5
        domain.username = str

        then: 'username validation passes'
        domain.validate(['username'])
    }


    void 'test email cannot be null'() {
        when:
        domain.email = null

        then:
        !domain.validate(['email'])
        domain.errors['email'].code == 'nullable'
    }

    void 'test email cannot be blank'() {
        when:
        domain.email = ''

        then:
        !domain.validate(['email'])
    }

}
