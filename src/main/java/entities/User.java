package entities;

import java.util.ArrayList;
import java.util.List;

public class User {
    String username;
    String password;
    List<Tag> tags;
    List<Event> events;
    List<Task> tasks;
    List<Timer> timers;
//    List<Invitation> incomingInvitations;
//    List<Invitation> outgoingInvitations;

    /**
     * Stores whether the Calendar shows weekends (1) or not (0)
     */
    boolean calendarView;

    /**
     * Initiaties a new User
     */
    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.tags = new ArrayList<Tag>();
        this.events = new ArrayList<Event>();
        this.tasks = new ArrayList<Task>();
        this.timers = new ArrayList<Timer>();
//        this.incomingInvitations = new ArrayList<Invitation>();
//        this.outgoingInvitations = new ArrayList<Invitiation>();
    }

    /**
     * Sets the username of this User
     * @param username The new username of the User
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the username of the User
     *
     * @return username The string storing the username of the User
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets the password of this User
     * @param password The new password of the User
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Checks whether the password inputted is the same as that of the User
     * @param user The user corresponding to the username inputted
     * @return whether the password inputted is that of user
     */
    public boolean checkCredential(User user) {
        return this.password.equals(user.password);
    }

    public String getPassword() {return this.password;}

    /**
     * Adds a tag to this User
     * @param tag The new tag to add
     */
    public void addTag(Tag tag) {
        this.tags.add(tag);
    }

    /**
     * Removes a tag from this User
     * @param tag The new tag to remove
     */
    public void removeTag(Tag tag) {
        this.tags.remove(tag);
    }

    /**
     * Gets a list of tags associated with this User
     * @return tags A list of tags associated with this User
     */
    public List<Tag> getTags() {
        return this.tags;
    }

    /**
     * Returns the tag corresponding to the tagName
     * @param tagName The name of the tag to be returned
     * @return tag The tag corresponding to tagName, else null
     */
    public Tag getTagByName(String tagName) {
        for (Tag tag : this.tags) {
            if (tag.getName().equals(tagName)){
                return tag;}
        }
        return null;
    }

    /**
     * Adds an event to this User
     * @param event The new event to add
     */
    public void addEvent(Event event) {
        this.events.add(event);
    }

    /**
     * Removes an event from this User
     * @param event The new event to remove
     */
    public void removeEvent(Event event) {
        this.events.remove(event);
    }

    /**
     * Gets the list of events associated with this User
     * @return events A list of events associated with this User
     */
    public List<Event> getEvents() {
        return this.events;
    }

    /**
     * Adds a task to this User
     * @param task The new task to add
     */
    public void addTask(Task task) {
        this.tasks.add(task);
    }

    /**
     * Removes a task from this User
     * @param task The new task to remove
     */
    public void removeTask(Task task) {
        this.tasks.remove(task);
    }

    /**
     * Gets the list of tasks associated with this User
     * @return tasks A list of tasks associated with this User
     */
    public List<Task> getTasks() {
        return this.tasks;
    }

    /**
     * Returns the task corresponding to the taskName
     * @param taskName The name of the task to be returned
     * @return task The task corresponding to taskName, else null
     */
    public Task getTaskByName(String taskName) {
        for (Task task : this.tasks) {
            if (task.getName().equals(taskName)){
            return task;}
        }
        return null;
    }

    /**
     * Adds a timer to this User
     * @param timer The new timer to add
     */
    public void addTimer(Timer timer) {
        this.timers.add(timer);
    }

    /**
     * Removes a timer from this User
     * @param timer The new timer to remove
     */
    public void removeTimer(Timer timer) {
        this.timers.remove(timer);
    }

    /**
     * Gets the list of timers associated with this User
     * @return timers A list of timers associated with this User
     */
    public List<Timer> getTimers() {
        return this.timers;
    }

    /**
     * Adds an invitation to this User's outgoingInvitations
     * @param invitation The new invitation to add
     */
//    public void addOutgoingInvitation(Invitation invitation) {
//        this.outgoingInvitations.add(invitation);
//    }

    /**
     * Removes an invitation from this User's outgoingInvitations
     * @param invitation The new invitation to remove
     */
//    public void removeOutgoingInvitation(Invitation invitation) {
//        this.outgoingInvitations.remove(invitation);
//    }

    /**
     * Gets the list of outgoingInvitations associated with this User
     *
     * @return outgoingInvitations A list of outgoingInvitations associated with this User
     */
 //   public List<Invitation> getOutgoingInvitations() {
 //       return this.outgoingInvitations;
 //   }

    /**
     * Adds an invitation to this User's incomingInvitations
     * @param invitation The new invitation to add
     */
//    public void addIncomingInvitation(Invitation invitation) {
//        this.incomingInvitations.add(invitation);
//    }

    /**
     * Removes an invitation from this User's incomingInvitations
     * @param invitation The new invitation to remove
     */
//    public void removeIncomingInvitation(Invitation invitation) {
//        this.incomingInvitations.remove(invitation);
//    }

    /**
     * Gets the list of incomingInvitations associated with this User
     *
     * @return incomingInvitations A list of incomingInvitations associated with this User
     */
//    public List<Invitation> getIncomingInvitations() {
//        return this.incomingInvitations;
//    }

    public void setCalendarView(boolean calendarView) {this.calendarView = calendarView;}

}