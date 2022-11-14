package entities;

import java.util.ArrayList;
import java.util.List;

/**
 * * An entity class representing a User
 */
public class User {

    /**
     * * The Username of the User
     */
    String username;

    /**
     * * The Password of the User
     */
    String password;

    /**
     * * The list of Tags of the User
     */
//    List<Tag> tags;

    /**
     * * The list of Events of the User
     */
//    List<Event> events;

    /**
     * * The list of Tasks of the User
     */
    List<Task> tasks;

    /**
     * * The list of Users sending Incoming Invitations of the User
     */
//    List<Invitation> incomingInvitations;

    /**
     * * The list of Users the current User has sent Outgoing Invitations
     */
//    List<Invitation> outgoingInvitations;

    /**
     * * Stores whether the Calendar shows weekends (1) or not (0)
     */
    boolean calendarView;

    /**
     * Adds a task to this User
     * @param task The new task to add
     */
    public void addTask(Task task) {
        this.tasks.add(task);
    }

//    /**
//     * Removes a task from this User
//     * @param task The new task to remove
//     */
//    public void removeTask(Task task) {
//        this.tasks.remove(task);
//    }
//
//    /**
//     * Gets the list of tasks associated with this User
//     * @return tasks A list of tasks associated with this User
//     */
//    public ArrayList<Task> getTasks() {
//        return this.tasks;
//    }

    /**
     * Changes the username of this User
     * @param username The new username of the User
     */
    public void changeUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the username of the User
     * @return username The string storing the username of the User
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Changes the password of this User
     * @param password The new password of the User
     */
    public void changePassword(String password) {
        this.password = password;
    }

//    /**
//     * Gets the password of the User
//     * @return password The string storing the password of the User
//     */
//    public String getPassword() {
//        return this.password;
//    }

//    /**
//     * Adds a tag to this User
//     * @param tag The new tag to add
//     */
//    public void addTag(Tag tag) {
//        this.tags.add(tag);
//    }
//
//    /**
//     * Removes a tag from this User
//     * @param tag The new tag to remove
//     */
//    public void removeTag(Tag tag) {
//        this.tags.remove(tag);
//    }
//
//    /**
//     * Gets a list of tags associated with this User
//     * @return tags A list of tags associated with this User
//     */
//    public List<Tag> getTags() {
//        return this.tags;
//    }

//    /**
//     * Adds an event to this User
//     * @param event The new event to add
//     */
//    public void addEvent(Event event) {
//        this.events.add(event);
//    }

//    /**
//     * Removes an event from this User
//     * @param event The new event to remove
//     */
//    public void removeEvent(Event event) {
//        this.events.remove(event);
//    }
//
//    /**
//     * Gets the list of events associated with this User
//     * @return events A list of events associated with this User
//     */
//    public List<Event> getEvents() {
//        return this.events;
//    }

//    /**
//     * Adds an invitation to this User's outgoingInvitations
//     * @param invitation The new invitation to add
//     */
//    public void addOutgoingInvitation(Invitation invitation) {
//        this.outgoingInvitations.add(invitation);
//    }

//    /**
//     * Removes an invitation from this User's outgoingInvitations
//     * @param invitation The new invitation to remove
//     */
//    public void removeOutgoingInvitation(Invitation invitation) {
//        this.outgoingInvitations.remove(invitation);
//    }

    /**
     * Gets the list of outgoingInvitations associated with this User
     * @return outgoingInvitations A list of outgoingInvitations associated with this User
     */
 //   public List<Invitation> getOutgoingInvitations() {
 //       return this.outgoingInvitations;
 //   }

//    /**
//     * Adds an invitation to this User's incomingInvitations
//     * @param invitation The new invitation to add
//     */
//    public void addIncomingInvitation(Invitation invitation) {
//        this.incomingInvitations.add(invitation);
//    }

//    /**
//     * Removes an invitation from this User's incomingInvitations
//     * @param invitation The new invitation to remove
//     */
//    public void removeIncomingInvitation(Invitation invitation) {
//        this.incomingInvitations.remove(invitation);
//    }

//    /**
//     * Gets the list of incomingInvitations associated with this User
//     * @return incomingInvitations A list of incomingInvitations associated with this User
//     */
//    public List<Invitation> getIncomingInvitations() {
//        return this.incomingInvitations;
//    }

}
