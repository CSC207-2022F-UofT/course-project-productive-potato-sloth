package useCases.Tasks;

import entities.Task;
import gateways.Tasks.TaskDatbaseGateway;
import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;

/**
 * A use case which marks a target task as complete
 */
public class MarkTaskCompleteness implements MarkTaskCompletenessInputBoundary {

    private final TaskDatbaseGateway taskDatbaseGateway;

    public MarkTaskCompleteness(TaskDatbaseGateway taskDatbaseGateway) {
        this.taskDatbaseGateway = taskDatbaseGateway;
    }


    @Override
    public TaskResponseModel setCompleteness(TaskRequestModel taskRequestModel) {
        Task task = taskDatbaseGateway.get(taskRequestModel.getName());
        if (taskRequestModel.getCompleted()) {
            task.setCompleted();
            taskDatbaseGateway.update(task);
            return new TaskResponseModel(true, "Task completed!");

        } else {
            task.setIncompleted();
            taskDatbaseGateway.update(task);
            return new TaskResponseModel(true, "Task incomplete!");
        }
    }
}
