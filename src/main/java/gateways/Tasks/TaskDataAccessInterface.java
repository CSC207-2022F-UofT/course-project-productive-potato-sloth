package gateways.Tasks;

import entities.Task;
import gateways.DataAccessInterface;

/**
 * An interface which hides the implementation details of the connection to the database
 */
public interface TaskDataAccessInterface extends DataAccessInterface<Task> {

    /**
     * Checks if a Task exists in the currently logged-in user's Tasks
     *
     * @param name The name of the Task to be checked
     * @return A boolean representing if the Task already exists
     */
    boolean contains(String name);
}
