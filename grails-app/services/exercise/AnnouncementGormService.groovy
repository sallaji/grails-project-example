package exercise

import grails.gorm.transactions.Transactional

@Transactional
class AnnouncementGormService {
     Announcement updateAnnouncementFeaturedImage(Long announcementId, Integer version, byte[] bytes, String contentType) {
        Announcement announcement = Announcement.get(announcementId)
        if ( !announcement ) {
            return null
        }
        announcement.version = version
        announcement.featuredImageBytes = bytes
        announcement.featuredImageContentType = contentType
        announcement.save()
        announcement
    }
}