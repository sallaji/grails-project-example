package exercise

import grails.gorm.services.Service
import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.collections.transformation.FilteredList
import javafx.collections.transformation.SortedList

@Service(Announcement)
interface AnnouncementService {

    Announcement get(Serializable id)

    List<Announcement> list(Map args)

    Long count()

    void delete(Serializable id)

    Announcement save(Announcement announcement)

}