package useCases.ViewCalendar;

import entities.dataObjects.EventDataObject;
import entities.dataObjects.EventDataResponseObject;

import java.util.ArrayList;
import java.util.List;

public class ViewCalendarResponseModel {

    List<EventDataResponseObject> eventList;

    public ViewCalendarResponseModel(){
        this.eventList = new ArrayList<>();
    }

    public void addEventResponseObject(EventDataResponseObject eventDataResponseObject){
        eventList.add(eventDataResponseObject);
    }

    public List<EventDataResponseObject> getEventList(){
        return eventList;
    }
}
