package entities.dataObjects;

import java.time.LocalDateTime;
import java.util.List;

public abstract class EventDataObject {

    // basically an event but with no tags.

    public LocalDateTime getEndTime() {
        return end_time;
    }

    public LocalDateTime getStartTime() {
        return start_time;
    }

    LocalDateTime start_time;
    LocalDateTime end_time;

    public String getEventName() {
        return eventName;
    }

    public String getSelectedTaskName() {
        return selectedTaskName;
    }

    String selectedTaskName;
    String eventName;

        public EventDataObject(String eventName, LocalDateTime start_time,
                                         LocalDateTime end_time,
                                         String selectedTaskName
        ) {
            this.start_time = start_time;
            this.end_time = end_time;
            this.selectedTaskName = selectedTaskName;
            this.eventName = eventName;
        }

    }

