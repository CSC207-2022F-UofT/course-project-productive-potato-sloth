package entities;

import entities.dataObjects.EventDataResponseObject;
import entities.dataObjects.TagDataObject;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/*
An entity class representing an Event.
 */
public class Event implements Serializable {

    /**
     * The LocalDateTime object representing the time
     * that the event starts at.
     */
    private LocalDateTime start_time;

    /**
     * The LocalDateTime object representing the time
     * that the event ends at.
     */
    private LocalDateTime end_time;


    /**
     * Gets the task associated with the event.
     */
    public Task getTask() {
        return task;
    }

    /**
     * Sets the task associated with the event.
     * @param task the new task associated with this event.
     */
    public void setTask(Task task) {
        this.task = task;
    }

    /**
     * The task associated with this event.
     */
    private Task task; // optional, will be null if no task

    /**
     * Gets the name associated with the event.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the name associated with the event.
     * @param name the new name of the event.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The name associated with this event.
     */
    private String name;

    /**
     * Gets the end time associated with the event.
     */
    public LocalDateTime getEndTime() {
        return end_time;
    }

    /**
     * Sets the end time associated with the event.
     * @param end_time: the new end time of the event.
     */
    public void setEndTime(LocalDateTime end_time) {
        this.end_time = end_time;
    }

    /**
     * Gets the start time associated with the event.
     */
    public LocalDateTime getStartTime() {
        return start_time;
    }

    /**
     * Sets the end time associated with the event.
     * @param start_time the new start time of the event.
     */
    public void setStartTime(LocalDateTime start_time) {
        this.start_time = start_time;
    }

    /**
     * Gets the tags associated with the event.
     */
    public List<Tag> getTags(){
        return tags;
    }

    /**
     * Adds a tag to this event.
     * @param tag the new tag for this event.
     */
    public void addTag(Tag tag){
        tags.add(tag);
    }

    /**
     * A list of Tags for this event.
     */
    private List<Tag> tags;

    /**
     * Constructs an event given the following parameters.
     * @param start_time the start time of the event.
     * @param end_time the end time of the event.
     * @param task the task object associated with the event
     * @param name the name of the event
     * @param tags a list of tags associated with the event
     */
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

    /**
     * Prepares an EventDataResponseObject, a pure data object
     * containing the vital information about this object
     * intended for travelling up the layers of the clean architecture
     * @return the response object
     */
    public EventDataResponseObject prepareDataResponseObject() {

        List<TagDataObject> tagDataObjects = new ArrayList<>();

        for(Tag tag: this.getTags()){
            TagDataObject tagDataObject = new TagDataObject(tag.getName(), tag.getColor());
            tagDataObjects.add(tagDataObject);
        }

        EventDataResponseObject dataResponseObject = new EventDataResponseObject(
                this.getName(),
                this.getStartTime(),
                this.getEndTime(),
                this.getTask().getName(),
                tagDataObjects
        );

        return dataResponseObject;

    }
}
