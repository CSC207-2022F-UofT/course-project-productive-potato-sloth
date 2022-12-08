package gateways.Tasks;

import java.util.List;

/**
 * A class which is returned from the GetTaskInfo use case as a Response
 */
public class TaskInfoResponseModel {

    final String name;
    final String description;
    final Boolean completed;
    final List<String> events;
    final List<String> collaborators;
    final List<String> allTasks;
    List<String> tags;
    String chatRoom;

    public TaskInfoResponseModel(
            String name,
            String description,
            Boolean completed,
            List<String> tags,
            List<String> events,
            List<String> collaborators,
            List<String> allTasks
    ) {
        this.name = name;
        this.description = description;
        this.completed = completed;
        this.tags = tags;
        this.events = events;
        this.collaborators = collaborators;
        this.allTasks = allTasks;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getCollaborators() {
        return collaborators;
    }

    public List<String> getAllTasks() {
        return allTasks;
    }

    public void removeTask(String task) {
        this.allTasks.remove(task);
    }

}
