package usecases.Tasks;
import entities.Tag;
import entities.Task;

/***
 * A use case that adds a tag to a Task
 */
public class AddTag {

    Task task;

    /**
     * Constructs an AddTag use case given a task
     * @param task The task to be modified
     */
    public AddTag(Task task) {
        this.task = task;
    }

    /**
     * Adds a tag to a task
     * @param tag The tag to be added
     */
    public void addTag(Tag tag) {
        task.addTag(tag);
    }

}
