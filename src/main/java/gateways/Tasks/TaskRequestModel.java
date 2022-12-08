package gateways.Tasks;

/**
 * A class which is passed into Task-relevant use cases as a Request
 */
public class TaskRequestModel {

    private final String name;

    private final String newName;
    private final String description;
    private final Boolean completed;
    private final String tagName;
    private final String collaboratorUsername;

    public TaskRequestModel(
            String name,
            String newName,
            String description,
            Boolean completed,
            String tagName,
            String collaboratorUsername) {
        this.name = name;
        this.newName = newName;
        this.description = description;
        this.completed = completed;
        this.tagName = tagName;
        this.collaboratorUsername = collaboratorUsername;
    }


    public String getName() {
        return name;
    }

    public String getNewName() {
        return newName;
    }

    public String getDescription() {
        return description;
    }

    public boolean getCompleted() {
        return completed;
    }

    public String getTagName() {
        return tagName;
    }

    public String getCollaborator() {
        return collaboratorUsername;
    }
}
