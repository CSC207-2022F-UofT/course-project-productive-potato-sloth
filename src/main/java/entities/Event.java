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
    private List<String> collaborator_usernames;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    private Task task; // optional, will be null if no task

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public boolean getRepeats() {
        return repeats;
    }

    public void setRepeatFrequency(LocalTime repeatFrequency) {
        this.repeats = true;
        this.repeatFrequency = repeatFrequency;
    }

    public void clearRepeatFrequency(){
        this.repeats = false;
        this.repeatFrequency = null;
    }

    private boolean repeats;

    public LocalDateTime getEndTime() {
        return end_time;
    }

    public void setEndTime(LocalDateTime end_time) {
        this.end_time = end_time;
    }

    public LocalDateTime getStartTime() {
        return start_time;
    }

    public void setStartTime(LocalDateTime start_time) {
        this.start_time = start_time;
    }

    private LocalTime repeatFrequency;
    private List<Tag> tags;

    public Event(LocalDateTime start_time,
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
        this.repeatFrequency = frequency;
        this.tags = tags;
    }
}
