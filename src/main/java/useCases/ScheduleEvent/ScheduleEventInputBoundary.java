package useCases.ScheduleEvent;

import screens.ScheduleEvent.ScheduleEventResponseModel;

public interface ScheduleEventInputBoundary {

    ScheduleEventResponseModel scheduleEvent(ScheduleEventRequestModel requestModel);

}
