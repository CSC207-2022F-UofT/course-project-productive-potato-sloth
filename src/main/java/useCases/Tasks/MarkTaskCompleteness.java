package useCases.Tasks;

import entities.Task;
import gateways.Tasks.TaskDataAccessInterface;
import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;

/**
 * A use case which marks a target task as complete
 */
public class MarkTaskCompleteness implements MarkTaskCompletenessInputBoundary {

    private final TaskDataAccessInterface taskDatabaseGateway;

    public MarkTaskCompleteness(TaskDataAccessInterface taskDatabaseGateway) {
        this.taskDatabaseGateway = taskDatabaseGateway;
    }


    @Override
    public TaskResponseModel setCompleteness(TaskRequestModel taskRequestModel) {
        Task task = taskDatabaseGateway.get(taskRequestModel.getName());
        if (taskRequestModel.getCompleted()) {
            task.setCompleted();
            taskDatabaseGateway.update(task);
            return new TaskResponseModel(true, "Task completed!");

        } else {
            task.setIncompleted();
            taskDatabaseGateway.update(task);
            return new TaskResponseModel(true, "Task incomplete!");
        }
    }
}
