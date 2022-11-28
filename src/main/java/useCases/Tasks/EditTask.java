package useCases.Tasks;

import entities.Task;
import gateways.Tasks.TaskDataAccessInterface;
import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;

/**
 * A use case which edits the attributes of a Task
 */
public class EditTask implements EditTaskInputBoundary {

    private final TaskDataAccessInterface taskDatabaseGateway;

    public EditTask(TaskDataAccessInterface taskDatabaseGateway) {
        this.taskDatabaseGateway = taskDatabaseGateway;
    }


    @Override
    public TaskResponseModel editName(TaskRequestModel taskRequestModel) {
        Task task = taskDatabaseGateway.get(taskRequestModel.getName());
        task.setName(taskRequestModel.getName());
        taskDatabaseGateway.update(task);
        return new TaskResponseModel(true, "Name changed successfully");
    }

    @Override
    public TaskResponseModel editDescription(TaskRequestModel taskRequestModel) {
        Task task = taskDatabaseGateway.get(taskRequestModel.getName());
        task.setDescription(taskRequestModel.getDescription());
        taskDatabaseGateway.update(task);
        return new TaskResponseModel(true, "Description changed successfully");
    }
}



