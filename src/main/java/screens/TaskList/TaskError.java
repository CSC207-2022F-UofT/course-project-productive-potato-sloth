package screens.TaskList;

/**
 * An Exception which represents a Task-related error
 */
public class TaskError extends RuntimeException {

    /**
     * Instantiates a TaskError with a detailed message
     *
     * @param error The error message
     */
    public TaskError(String error) {
        super(error);
    }
}
