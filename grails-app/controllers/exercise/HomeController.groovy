package exercise

class HomeController {
    //specifies a defaultAction property in the controller:
    // static defaultAction = "homePage"

    def index() {
        /*
        renders some custom content on the home page
        Renders a Groovy map of content to the requestor, containing a name property from the session
         (defaulting to "User" if no session value exists) and the current total of Account instances
         from GORM’s count method.
         */
        respond([name: session.name ?: 'User', announcementTotal: Announcement.count()])
    }

    def updateName(String name) {
        session.name = name
        flash.message = "El nombre ha sido actualizado"
        redirect action: 'index'
    }
}
