package gateways.Tasks;

import entities.Tag;
import entities.Task;
import entities.User;

public class TaskRequestModel {

    private final User user;
    private final String name;
    private final String description;
    private final boolean completed;
    private final Tag tag;
    private final User collaborator;

    public TaskRequestModel(
            User user,
            String name,
            String description,
            boolean completed,
            Tag tag,
            User collaborator) {
        this.user = user;
        this.name = name;
        this.description = description;
        this.completed = completed;
        this.tag = tag;
        this.collaborator = collaborator;
    }

    public User getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean getCompleted() {
        return completed;
    }

    public Tag getTag() {
        return tag;
    }

    public User getCollaborator() {
        return collaborator;
    }
}
