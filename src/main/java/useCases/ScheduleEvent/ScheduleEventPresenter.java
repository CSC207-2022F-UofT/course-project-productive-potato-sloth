package useCases.ScheduleEvent;

import screens.ScheduleEvent.ScheduleEventResponseModel;

public interface ScheduleEventPresenter {

    ScheduleEventResponseModel prepareSuccessView(ScheduleEventResponseModel event_creation_response);

    ScheduleEventResponseModel prepareFailView(String error);
}