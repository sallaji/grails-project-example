package exercise

class UploadAnnouncementFeaturedImageService {

    def announcementGormService

    Announcement uploadFeatureImage(FeaturedImageCommand cmd) {
        byte[] bytes = cmd.featuredImageFile.bytes
        String contentType = cmd.featuredImageFile.contentType
        announcementGormService.updateAnnouncementFeaturedImage(cmd.id, cmd.version, bytes, contentType)
    }
}