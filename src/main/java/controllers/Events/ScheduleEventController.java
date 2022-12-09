package controllers.Events;

import screens.ScheduleEvent.ScheduleEventResponseModel;
import useCases.ScheduleEvent.ScheduleEventInputBoundary;
import useCases.ScheduleEvent.ScheduleEventRequestModel;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * A controller to relay information from the ScheduleEventScreen to the ScheduleEventInteractor.
 */
public class ScheduleEventController {

    /**
     * The interactor that implements the input boundary.
     */
    final ScheduleEventInputBoundary eventScheduler;


    /**
     * A constructor for the controller that takes in the following:
     * @param eventScheduler an interactor to initialize this controller.
     */
    public ScheduleEventController(ScheduleEventInputBoundary eventScheduler) {
        this.eventScheduler = eventScheduler;
    }

    /**
     * Execute the ScheduleEvent use case of the interactor given input parameters.
     * Build a request model and pass it into the interactor.
     * @param start_time the start time of the new event.
     * @param end_time the end time of the new event.
     * @param taskName the name of the task linked to this event.
     * @param name the name of the event.
     * @param tagNames a list of names of the tags linked to this event.
     * @return a response model containing the response for a success or failure view.
     */
    public ScheduleEventResponseModel scheduleEvent(LocalDateTime start_time,
                                                    LocalDateTime end_time,
                                                    String taskName,
                                                    String name,
                                                    List<String> tagNames
    ){

        ScheduleEventRequestModel requestModel = new ScheduleEventRequestModel(
                name, start_time,
                end_time,
                taskName,
                tagNames
        );
        return eventScheduler.scheduleEvent(requestModel);
    }
}
