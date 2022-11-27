package useCases.ScheduleEvent;

import java.time.LocalDateTime;
import java.util.List;

public class ScheduleEventRequestModel {

    LocalDateTime start_time;
    LocalDateTime end_time;
    String selectedTaskName;
    String eventName;
    List<String> selectedTagNames;

    public ScheduleEventRequestModel(String eventName, LocalDateTime start_time,
                                     LocalDateTime end_time,
                                     String selectedTaskName,
                                     List<String> selectedTagNames
                                  ) {
        this.start_time = start_time;
        this.end_time = end_time;
        this.selectedTaskName = selectedTaskName;
        this.eventName = eventName;
        this.selectedTagNames = selectedTagNames;
    }
}
