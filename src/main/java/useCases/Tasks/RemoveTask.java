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

    private final TaskDataAccessInterface taskDatabaseGateway;
    private final TaskPresenter taskPresenter;

    public RemoveTask(TaskDataAccessInterface taskDatabaseGateway, TaskPresenter taskPresenter) {
        this.taskDatabaseGateway = taskDatabaseGateway;
        this.taskPresenter = taskPresenter;
    }

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
