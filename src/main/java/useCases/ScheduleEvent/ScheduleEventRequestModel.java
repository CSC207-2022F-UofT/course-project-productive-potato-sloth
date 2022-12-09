package useCases.ScheduleEvent;

import entities.dataObjects.EventDataRequestObject;

import java.time.LocalDateTime;
import java.util.List;

/**
 * A request model that contains the vital information
 * for scheduling a new event.
 */
public class ScheduleEventRequestModel {

    /**
     * a pure data object containing the main parameters.
     */
    EventDataRequestObject eventDataObject;

    /**
     * Create a request model.
     * @param eventName the name of the new event.
     * @param start_time the start time of the new event.
     * @param end_time the end time of the new event.
     * @param selectedTaskName the selected taks name of the new event.
     * @param selectedTagNames the selected tag names of the new event.
     */
    public ScheduleEventRequestModel(String eventName, LocalDateTime start_time,
                                     LocalDateTime end_time,
                                     String selectedTaskName,
                                     List<String> selectedTagNames
    ) {
        eventDataObject = new EventDataRequestObject(eventName, start_time, end_time, selectedTaskName, selectedTagNames);
    }

    /**
     * Get the event name of the data object
     * @return the event name of the data object
     */
    public String getEventName(){
        return eventDataObject.getEventName();
    }

    /**
     * Get the start time of the data object
     * @return the start time of the data object
     */
    public LocalDateTime getStartTime(){
        return eventDataObject.getStartTime();
    }

    /**
     * Get the end time of the data object
     * @return the end time of the data object
     */
    public LocalDateTime getEndTime(){
        return eventDataObject.getEndTime();
    }

    /**
     * Get the selected task name of the data object
     * @return the selected task name of the data object
     */
    public String getSelectedTaskName(){
        return eventDataObject.getSelectedTaskName();
    }

    /**
     * Get the selected tag names of the data object
     * @return the selected tag names of the data object
     */
    public List<String> getSelectedTagNames(){
        return eventDataObject.getSelectedTagNames();
    }
}