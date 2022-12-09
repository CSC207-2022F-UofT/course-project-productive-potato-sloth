package usecases.ScheduleEvent;

import entities.dataObjects.EventDataRequestObject;

import java.time.LocalDateTime;
import java.util.List;

public class ScheduleEventRequestModel {

    EventDataRequestObject eventDataObject;

    public ScheduleEventRequestModel(String eventName, LocalDateTime start_time,
                                     LocalDateTime end_time,
                                     String selectedTaskName,
                                     List<String> selectedTagNames
                                  ) {
        eventDataObject = new EventDataRequestObject(eventName, start_time, end_time, selectedTaskName, selectedTagNames);
    }

    public String getEventName(){
        return eventDataObject.getEventName();
    }

    public LocalDateTime getStartTime(){
        return eventDataObject.getStartTime();
    }

    public LocalDateTime getEndTime(){
        return eventDataObject.getEndTime();
    }

    public String getSelectedTaskName(){
        return eventDataObject.getSelectedTaskName();
    }

    public List<String> getSelectedTagNames(){
        return eventDataObject.getSelectedTagNames();
    }
}
