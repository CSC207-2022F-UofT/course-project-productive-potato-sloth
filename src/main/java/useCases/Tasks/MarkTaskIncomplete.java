package useCases.Tasks;

import entities.Task;

/**
 * A use case which marks a target task as incomplete
 */
public class MarkTaskIncomplete {

    private final Task task;

    /**
     * Instantiates MarkTaskComplete with a target task
     *
     * @param task The target task
     */
    public MarkTaskIncomplete(Task task) {
        this.task = task;
    }


    /**
     * Sets the task as complete
     */
    public void setIncomplete() {
        this.task.setIncompleted();
    }
}
