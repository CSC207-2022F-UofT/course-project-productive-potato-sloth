package screens.TaskList;

import entities.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskListViewModel {

    private List<String> taskList;
    private List<String> tagList;
    private String selectedTask;

    public TaskListViewModel() {
        taskList = new ArrayList<String>();
        tagList = new ArrayList<String>();
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
