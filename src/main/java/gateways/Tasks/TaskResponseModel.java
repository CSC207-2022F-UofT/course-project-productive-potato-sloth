package gateways.Tasks;

/**
 * A class which is returned from Task-relevant use cases as a Response
 */
public class TaskResponseModel {

    private final String name;

    private final String newName;
    private final String description;
    private final Boolean completed;
    private final String tagName;
    private final String collaboratorUsername;

    private final boolean success;
    private final String message;

    public TaskResponseModel(
            String name,
            String newName,
            String description,
            Boolean completed,
            String tagName,
            String collaboratorUsername,
            boolean success,
            String message
    ) {
        this.name = name;
        this.newName = newName;
        this.description = description;
        this.completed = completed;
        this.tagName = tagName;
        this.collaboratorUsername = collaboratorUsername;
        this.success = success;
        this.message = message;
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

    public Boolean getCompleted() {
        return completed;
    }

    public String getTagName() {
        return tagName;
    }

    public String getCollaboratorUsername() {
        return collaboratorUsername;
    }

    public boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

}
