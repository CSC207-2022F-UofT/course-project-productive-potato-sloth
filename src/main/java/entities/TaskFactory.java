package entities;

/**
 * A Factory Pattern that creates a task
 * <p>
 * This class abstracts away the details of creating a task,
 * changing the constructor only require changes in this class
 */
public class TaskFactory {

    /**
     * Creates a Task with a name
     *
     * @param name The name of the Task
     * @param user The User creating the Task
     * @return The new Task
     */
    public Task create(String name, User user) {
        return new Task(name, user);
    }

    /**
     * Creates a Task with a name and a description
     *
     * @param name        The name of the Task
     * @param user        The User creating the Task
     * @param description The description of the Task
     * @return The new Task
     */
    public Task create(String name, User user, String description) {
        return new Task(name, user, description);
    }

}
