package screens.ScheduleEvent;

/**
 * A pure data object representing the vital information about
 * a newly created event, intended for travelling up the
 * layers of the clean architecture.
 */
public class ScheduleEventResponseModel {

    /**
     * Gets the name associated with the event response model.
     * @return the event name.
     */
    public String getEventName() {
        return event_name;
    }

    /**
     * The event name associated with this response model object.
     */
    final String event_name;


    /**
     * Constructs the response model.
     * @param event_name the name of the newly scheduled event
     */
    public ScheduleEventResponseModel(String event_name){
        this.event_name = event_name;
    }
}
