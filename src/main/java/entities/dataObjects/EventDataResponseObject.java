package entities.dataObjects;

import java.time.LocalDateTime;
import java.util.List;

public class EventDataResponseObject extends EventDataObject {

    // stores TagDataObject(s).
    List<TagDataObject> tagDataObjects;

    public EventDataResponseObject(
            String eventName,
            LocalDateTime start_time,
            LocalDateTime end_time,
            String selectedTaskName,
            List<TagDataObject> tagDataObjects
    ) {
        super(eventName, start_time, end_time, selectedTaskName);
        this.tagDataObjects = tagDataObjects;
    }

    public List<TagDataObject> getTagDataObjects() {
        return tagDataObjects;
    }
}