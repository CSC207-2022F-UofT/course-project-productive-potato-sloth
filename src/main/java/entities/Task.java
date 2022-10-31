package entities;

import java.util.ArrayList;

/**
 * An entity class representing a Task
 */
public class Task {

    /**
     * The name of the Task
     */
    String name;

    /**
     * The description of the Task
     */
    String description;

    /**
     * A boolean indicating if the Task is completed
     */
    Boolean completed;

    /**
     * A list of the associated tags of this Task
     */
    ArrayList<Tag> tags;

    /**
     * The User that this Task belongs to
     */
//    final User user;

    /**
     * A list of the associated events of this Task
     */
//    ArrayList<Event> events;

    /**
     * A list of the collaborators of this Task
     */
//    ArrayList<User> collaborators; User not yet implemented

    /**
     * The ChatRoom associated with this Task
     */
//     ChatRoom chatRoom; ChatRoom not yet implemented

    /**
     * Constructs a Task given the name of the new Task
     * @param name The name of the Task
     * // @param user The owner (User) of the Task
     */
    public Task(String name /* User user */) {
        this.name = name;
        // this.user = user;
    }

    /**
     * Constructs a Task given the name and description of the new Task
     * @param name The name of the Task
     * // @param user The owner (User) of the Task
     * @param description The description of the Task
     */
    public Task(String name, /* User user */ String description) {
        this.name = name;
        //this.user = user;
    }

    /**
     * Gets the name of the Task
     * @return The name of the Task
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Task
     * @param name The new name of the Task
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of the Task
     * @return The description of the Task
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the Task
     * @param description The new description of the Task
     */
    public void setDescription(String description) {
        this.description = description;
    }

    // getters and setters for other events
    /**
     * Adds a tag to this Task
     * @param tag The new tag to add
     */
    public void addTag(Tag tag) {
        this.tags.add(tag);
    }

    /**
     * Removes a tag from this Task
     * @param tag The new tag to add
     */
    public void removeTag(Tag tag) {
        this.tags.remove(tag);
    }

    /**
     * Gets a list of tags associated with this Task
     * @return tags A list of tags associated with this Task
     */
    public ArrayList<Tag> getTags() {
        return this.tags;
    }

    /**
     * Gets the User of this Task
     */
//    public User getUser() {
//        return this.user;
//    }


    /**
     * Sets this task as completed
     */
    public void setCompleted() {
        this.completed = true;
    }

    /**
     * Sets this task as incompleted
     */
    public void setIncompleted() {
        this.completed = false;
    }

    /**
     * Gets the completion status of this task
     * @return If the task is completed
     */
    public Boolean getCompleted() {
        return this.completed;
    }

    //    Event not yet implemented
//    /**
//     * Adds an event to this Task
//     * @param tag The new tag to add
//     */
//    public void addEvent(Event event) {
//        this.events.add(tag);
//    }
//
//    /**
//     * Removes an event from this Task
//     * @param tag The new tag to add
//     */
//    public void removeEvent(Event event) {
//        this.events.remove(tag);
//    }
//
//    /**
//     * Gets a list of events associated with this Task
//     * @return events A list of events associated with this Task
//     */
//    public ArrayList<Tag> getEvents() {
//        return this.events;
//    }
//

    //    Collaborator not yet implemented
//    /**
//     * Adds a collaborator to this Task
//     * @param collaborator The collaborator to add to this task
//     */
//    public void addCollaborator(User collaborator) {
//        this.collaborators.add(collaborator);
//    }
//
//    /**
//     * Removes a collaborator to this Task
//     * @param collaborator The collaborator to remove from this task
//     */
//    public void removeCollaborator(User collaborator) {
//        this.collaborators.remove(collaborator);
//    }
//
//    /**
//     * Gets the collaborators of this Task
//     * @return
//     */
//    public ArrayList<User> addCollaborator(User collaborator) {
//        return this.collaborators;
//    }

}

