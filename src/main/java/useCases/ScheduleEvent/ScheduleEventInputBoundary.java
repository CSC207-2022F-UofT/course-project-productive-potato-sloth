package useCases.ScheduleEvent;

import screens.ScheduleEvent.ScheduleEventResponseModel;

/**
 * The input boundary that the interactor implements.
 */
public interface ScheduleEventInputBoundary {

    /**
     * The Schedules a new event with the parameters in request model
     * @param requestModel the parameters to create the new event.
     * @return a response model for the view to present to the user.
     */
    ScheduleEventResponseModel scheduleEvent(ScheduleEventRequestModel requestModel);

}