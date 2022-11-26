package useCases.ScheduleEvent;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class ScheduleEventRequestModel {

    LocalDateTime start_time;
    LocalDateTime end_time;
    String taskName;
    String name;
    List<String> tagNames;

    public ScheduleEventRequestModel(String name, LocalDateTime start_time,
                                     LocalDateTime end_time,
                                     String taskName,
                                     List<String> tagNames
                                  ) {
        this.start_time = start_time;
        this.end_time = end_time;
        this.taskName = taskName;
        this.name = name;
        this.tagNames = tagNames;
    }
}
