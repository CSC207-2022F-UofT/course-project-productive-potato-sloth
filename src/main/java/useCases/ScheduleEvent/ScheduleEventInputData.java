package useCases.ScheduleEvent;

import entities.Tag;
import entities.Task;
import entities.User;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class ScheduleEventInputData {

    private LocalDateTime start_time;
    private LocalDateTime end_time;
    private List<String> collaborator_usernames;
    private Task task;
    private String name;
    private boolean repeats;
    private LocalTime frequency;
    private List<Tag> tags;

    public ScheduleEventInputData(LocalDateTime start_time,
                                  LocalDateTime end_time,
                                  List<String> collaborator_usernames,
                                  Task task,
                                  String name,
                                  boolean repeats,
                                  LocalTime frequency,
                                  List<Tag> tags
                                  ) {
        this.start_time = start_time;
        this.end_time = end_time;
        this.collaborator_usernames = collaborator_usernames;
        this.task = task;
        this.name = name;
        this.repeats = repeats;
        this.frequency = frequency;
        this.tags = tags;
    }
}
