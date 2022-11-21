package useCases.ScheduleEvent;

import entities.Tag;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class ScheduleEventInputData {

    LocalDateTime start_time;
    LocalDateTime end_time;
    String taskName;
    String name;
    boolean repeats;
    LocalTime frequency;
    List<String> tagNames;

    public ScheduleEventInputData(LocalDateTime start_time,
                                  LocalDateTime end_time,
                                  String taskName,
                                  String name,
                                  boolean repeats,
                                  LocalTime frequency,
                                  List<String> tagNames
                                  ) {
        this.start_time = start_time;
        this.end_time = end_time;
        this.taskName = taskName;
        this.name = name;
        this.repeats = repeats;
        this.frequency = frequency;
        this.tagNames = tagNames;
    }
}
