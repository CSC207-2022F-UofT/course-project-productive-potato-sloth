package useCases.ScheduleEvent;

import entities.Tag;
import entities.Task;
import entities.User;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class ScheduleEventInputData {

    LocalDateTime start_time;
    LocalDateTime end_time;
    List<String> collaborator_usernames;
    String taskName;
    String name;
    boolean repeats;
    LocalTime frequency;
    List<Tag> tags;

    public ScheduleEventInputData(LocalDateTime start_time,
                                  LocalDateTime end_time,
                                  List<String> collaborator_usernames,
                                  String taskName,
                                  String name,
                                  boolean repeats,
                                  LocalTime frequency,
                                  List<Tag> tags
                                  ) {
        this.start_time = start_time;
        this.end_time = end_time;
        this.collaborator_usernames = collaborator_usernames;
        this.taskName = taskName;
        this.name = name;
        this.repeats = repeats;
        this.frequency = frequency;
        this.tags = tags;
    }
}
