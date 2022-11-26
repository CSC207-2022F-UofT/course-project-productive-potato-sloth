package useCases.Tasks;

import entities.Task;
import gateways.Tasks.TaskDatbaseGateway;
import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;

/**
 * A use case which edits the attributes of a Task
 */
public class EditTask implements EditTaskInputBoundary {

    private final TaskDatbaseGateway taskDatbaseGateway;

    public EditTask(TaskDatbaseGateway taskDatbaseGateway) {
        this.taskDatbaseGateway = taskDatbaseGateway;
    }


    @Override
    public TaskResponseModel editName(TaskRequestModel taskRequestModel) {
        Task task = taskDatbaseGateway.get(taskRequestModel.getName());
        task.setName(taskRequestModel.getName());
        taskDatbaseGateway.update(task);
        return new TaskResponseModel(true, "Name changed successfully");
    }

    @Override
    public TaskResponseModel editDescription(TaskRequestModel taskRequestModel) {
        Task task = taskDatbaseGateway.get(taskRequestModel.getName());
        task.setDescription(taskRequestModel.getDescription());
        taskDatbaseGateway.update(task);
        return new TaskResponseModel(true, "Description changed successfully");
    }
}



