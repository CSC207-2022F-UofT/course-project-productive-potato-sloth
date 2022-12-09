package usecases.Tasks;

import entities.Tag;
import entities.Task;

/***
 * A use case that removes a tag from a Task
 */
public class RemoveTag {

    private final Task task;

    /**
     * Constructs a RemoveTag use case given a task
     *
     * @param task The task to be modified
     */
    public RemoveTag(Task task) {
        this.task = task;
    }

    /**
     * Removes a tag from a task
     *
     * @param tag The tag to be added
     */
    public void removeTag(Tag tag) {
        task.removeTag(tag);
    }

}
