package gateways.Tasks;

import entities.User;

import java.util.List;
import java.util.Stack;

/**
 * A class which is returned from the GetTaskInfo use case as a Response
 */
public class TaskInfoResponseModel {

    String name;
    String description;
    Boolean completed;
    List<String> tags;
    List<String> events;
    List<String> collaborators;
    String chatRoom;
    List<String> allTasks;

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
