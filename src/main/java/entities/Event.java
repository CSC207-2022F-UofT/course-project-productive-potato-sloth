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

    private List<Tag> tags;

    public Event(LocalDateTime start_time,
                 LocalDateTime end_time,
                 Task task,
                 String name,
                 List<Tag> tags
    ) {
        this.start_time = start_time;
        this.end_time = end_time;
        this.task = task;
        this.name = name;
        this.tags = tags;
    }
}
