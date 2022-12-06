package useCases.ScheduleEvent;

import screens.ScheduleEvent.EventCreationFailed;
import screens.ScheduleEvent.ScheduleEventResponseModel;

public class ScheduleEventResponseFormatter implements ScheduleEventPresenter {
    @Override
    public ScheduleEventResponseModel prepareSuccessView(ScheduleEventResponseModel event_creation_response) {
        return event_creation_response;
    }

    @Override
    public ScheduleEventResponseModel prepareFailView(String error) {
        throw new EventCreationFailed(error);
    }
}
