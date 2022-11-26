package useCases.Tasks;

import entities.Task;
import gateways.Tasks.TaskDatbaseGateway;
import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;

/**
 * A use case which deletes a Task from a Users task list
 */
public class RemoveTask implements RemoveTaskInputBoundary {

    private final TaskDatbaseGateway taskDatbaseGateway;

    public RemoveTask(TaskDatbaseGateway taskDatbaseGateway) {
        this.taskDatbaseGateway = taskDatbaseGateway;
    }

    @Override
    public TaskResponseModel removeTask(TaskRequestModel taskRequestModel) {
        Task task = taskDatbaseGateway.get(taskRequestModel.getName());
        taskDatbaseGateway.delete(task);
        return new TaskResponseModel(true, "Task removed successfully");
    }
}
