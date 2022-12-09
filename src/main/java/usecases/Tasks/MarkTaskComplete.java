package usecases.Tasks;

import entities.Task;

/**
 * A use case which marks a target task as complete
 */
public class MarkTaskComplete {

    private final Task task;

    /**
     * Instantiates MarkTaskComplete with a target task
     *
     * @param task The target task
     */
    public MarkTaskComplete(Task task) {
        this.task = task;
    }


    /**
     * Sets the task as complete
     */
    public void setComplete() {
        this.task.setCompleted();
    }
}
