package useCases.Tasks;

import entities.Task;
import gateways.Tasks.TaskDataAccessInterface;
import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;
import presenters.TaskPresenter;

/**
 * A use case which deletes a Task from a Users task list
 */
public class RemoveTask implements RemoveTaskInputBoundary {

    /**
     * The interface which allows access to the TaskDatabase
     */
    private final TaskDataAccessInterface taskDatabaseGateway;

    /**
     * The presenter for Tasks
     */
    private final TaskPresenter taskPresenter;

    /**
     * Creates an instance of RemoveTask with the required fields
     *
     * @param taskDatabaseGateway Interface for accessing Tasks
     * @param taskPresenter       Presenter for Tasks
     */
    public RemoveTask(TaskDataAccessInterface taskDatabaseGateway, TaskPresenter taskPresenter) {
        this.taskDatabaseGateway = taskDatabaseGateway;
        this.taskPresenter = taskPresenter;
    }

    /**
     * Removes a Task from a User's list
     *
     * @param taskRequestModel Contains information about the task to be removed
     * @return A Response Model containing the name of the task removed
     */
    @Override
    public TaskResponseModel removeTask(TaskRequestModel taskRequestModel) {
        Task task = taskDatabaseGateway.get(taskRequestModel.getName());
        taskDatabaseGateway.delete(task);
        TaskResponseModel response = new TaskResponseModel(
                task.getName(),
                null,
                null,
                null,
                null,
                null,
                true,
                "Task removed successfully"
        );
        return taskPresenter.prepareSuccessView(response);
    }
}
