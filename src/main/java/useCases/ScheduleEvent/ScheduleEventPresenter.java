package useCases.ScheduleEvent;

import screens.ScheduleEvent.ScheduleEventResponseModel;

/**
 * An interface that a response formatter object implements.
 */
public interface ScheduleEventPresenter {

    /**
     * Prepare the response model so that a success view is shown
     * @param event_creation_response the response model for the presenter to operate on.
     * @return a more presentable response model
     */
    ScheduleEventResponseModel prepareSuccessView(ScheduleEventResponseModel event_creation_response);

    /**
     * Prepare the response model so that a failure view is shown
     * @param error the error in creating the event
     * @returna a presentable response model
     */
    ScheduleEventResponseModel prepareFailView(String error);
}