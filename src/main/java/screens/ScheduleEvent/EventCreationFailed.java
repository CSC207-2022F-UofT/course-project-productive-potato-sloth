package screens.ScheduleEvent;

/**
 * A runtime exception intended to be raised when an event
 * fails to be scheduled during the ScheduleEvent use case.
 */
public class EventCreationFailed extends RuntimeException {

    /**
     * A constructor for this exception.
     * @param error the error message found when scheduling the event
     */
    public EventCreationFailed(String error) {super(error);}

}
