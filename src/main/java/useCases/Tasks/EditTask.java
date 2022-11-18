package useCases.Tasks;

import entities.Task;

/**
 * A use case which edits the attributes of a Task
 */
public class EditTask {

    /**
     * The task to be edited
     */
    private final Task task;

    /**
     * Instantiates EditTask with a target task for editing
     *
     * @param task The task to be edited
     */
    public EditTask(Task task) {
        this.task = task;
    }

    /**
     * Edits the name of the target task
     *
     * @param name The new name of the task
     */
    public void editName(String name) {
        task.setName(name);
    }

    /**
     * Edits the description of the target task
     *
     * @param description The new description of the task
     */
    public void editDescription(String description) {
        task.setDescription(description);
    }
}



