package screens.ScheduleEvent;

import useCases.ScheduleEvent.ScheduleEventInputBoundary;
import useCases.ScheduleEvent.ScheduleEventRequestModel;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class ScheduleEventController {

    final ScheduleEventInputBoundary eventScheduler;


    public ScheduleEventController(ScheduleEventInputBoundary eventScheduler) {
        this.eventScheduler = eventScheduler;
    }

    ScheduleEventResponseModel scheduleEvent(LocalDateTime start_time,
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
