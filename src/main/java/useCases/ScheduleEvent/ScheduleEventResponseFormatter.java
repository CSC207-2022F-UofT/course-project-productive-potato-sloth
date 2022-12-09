package useCases.ScheduleEvent;

import screens.ScheduleEvent.EventCreationFailed;
import screens.ScheduleEvent.ScheduleEventResponseModel;

/**
 * A response formatter that implements the presenter interface.
 */
public class ScheduleEventResponseFormatter implements ScheduleEventPresenter {
    /**
     * A method to return a response model that presents a success view to the user
     * @param event_creation_response the response model for the presenter to operate on.
     * @return a response model with the ameliorated response.
     */
    @Override
    public ScheduleEventResponseModel prepareSuccessView(ScheduleEventResponseModel event_creation_response) {
        return event_creation_response;
    }

    /**
     * A method to return a response model that presents a success view to the user
     * @param error the error message for the failure view.
     * @return a response model with the ameliorated response.
     */
    @Override
    public ScheduleEventResponseModel prepareFailView(String error) {
        throw new EventCreationFailed(error);
    }
}