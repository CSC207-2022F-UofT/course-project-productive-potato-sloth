package useCases.Tasks;

import entities.Task;
import gateways.Tasks.TaskDataAccessInterface;
import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;

/**
 * A use case which deletes a Task from a Users task list
 */
public class RemoveTask implements RemoveTaskInputBoundary {

    private final TaskDataAccessInterface taskDatabaseGateway;

    public RemoveTask(TaskDataAccessInterface taskDatabaseGateway) {
        this.taskDatabaseGateway = taskDatabaseGateway;
    }

    @Override
    public TaskResponseModel removeTask(TaskRequestModel taskRequestModel) {
        Task task = taskDatabaseGateway.get(taskRequestModel.getName());
        taskDatabaseGateway.delete(task);
        return new TaskResponseModel(true, "Task removed successfully");
    }
}
