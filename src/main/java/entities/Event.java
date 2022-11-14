package entities;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/*
An entity class representing an Event
TODO: document this class
 */
public class Event {
    private LocalDateTime start_time;
    private LocalDateTime end_time;
    private List<User> collaborators;
    private Task task;
    private String name;
    private boolean repeats;
    private LocalTime frequency;
    private List<Tag> tags;

    public Event(LocalDateTime start_time,
                 LocalDateTime end_time,
                 List<User> collaborators,
                 Task task,
                 String name,
                 boolean repeats,
                 LocalTime frequency,
                 List<Tag> tags
    ) {
        this.start_time = start_time;
        this.end_time = end_time;
        this.collaborators = collaborators;
        this.task = task;
        this.name = name;
        this.repeats = repeats;
        this.frequency = frequency;
        this.tags = tags;
    }
}
