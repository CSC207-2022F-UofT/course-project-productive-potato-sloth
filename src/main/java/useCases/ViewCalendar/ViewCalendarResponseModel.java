package useCases.ViewCalendar;

import entities.dataObjects.EventDataObject;
import entities.dataObjects.EventDataResponseObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A response model for the ViewCalendar use case.
 */
public class ViewCalendarResponseModel {

    /**
     * A list of pure data objects containing information
     * about events in the user's calendar.
     */
    List<EventDataResponseObject> eventList;

    /**
     * Construct an empty response model.
     */
    public ViewCalendarResponseModel(){
        this.eventList = new ArrayList<>();
    }

    /**
     * Add an event response object
     * @param eventDataResponseObject a pure data object containing an event's info
     */
    public void addEventResponseObject(EventDataResponseObject eventDataResponseObject){
        eventList.add(eventDataResponseObject);
    }

    /**
     * Get the list of event data response objects in the response model
     * @return the list of event data response objects
     */
    public List<EventDataResponseObject> getEventList(){
        return eventList;
    }
}