package screens.TaskList;

public class TaskError extends RuntimeException {

    public TaskError(String error) {
        super(error);
    }
}
