package screens.TaskList;

import java.util.ArrayList;
import java.util.List;

/**
 * A View Model containing all the tasks and tags of the current user, along with the selected task
 */
public class TaskListViewModel {

    private final List<String> taskList;
    private final List<String> tagList;
    private String selectedTask;

    public TaskListViewModel() {
        taskList = new ArrayList<>();
        tagList = new ArrayList<>();
    }

    public void addTask(String name) {
        this.taskList.add(name);
    }

    public void addTag(String name) {
        this.tagList.add(name);
    }

    public void replaceTask(String name, String newName) {
        int index = taskList.indexOf(name);
        this.taskList.remove(name);
        this.taskList.add(index, newName);
    }

    public List<String> getTasks() {
        return taskList;
    }

    public List<String> getTags() {
        return tagList;
    }

    public void removeTask(String name) {
        this.taskList.remove(name);
    }

    public String getSelectedTask() {
        return selectedTask;
    }

    public void setSelectedTask(String task) {
        this.selectedTask = task;
    }
}
