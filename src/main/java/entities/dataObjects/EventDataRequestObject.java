package entities.dataObjects;

import java.time.LocalDateTime;
import java.util.List;

public class EventDataRequestObject extends EventDataObject {

    // ˀonly stores the tag names instead of TagDataObject(s).

    List<String> selectedTagNames;

    public EventDataRequestObject(
            String eventName,
            LocalDateTime start_time,
            LocalDateTime end_time,
            String selectedTaskName,
            List<String> selectedTagNames
    ) {
        super(eventName, start_time, end_time, selectedTaskName);
        this.selectedTagNames = selectedTagNames;
    }

    public List<String> getSelectedTagNames(){
        return selectedTagNames;
    }


}
