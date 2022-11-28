package useCases.Tasks;

import entities.Task;
import gateways.Tasks.TaskDataAccessInterface;
import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;

/***
 * A use case which adds a collaborator to a User's Task
 */
public class AddCollaborator implements AddCollaboratorInputBoundary {

    private final TaskDataAccessInterface taskDatbaseGateway;

    public AddCollaborator(TaskDataAccessInterface taskDatbaseGateway) {
        this.taskDatbaseGateway = taskDatbaseGateway;
    }

    @Override
    public TaskResponseModel addCollaborator(TaskRequestModel taskRequestModel) {
        Task task = taskDatbaseGateway.get(taskRequestModel.getName());
        task.addCollaborator(taskRequestModel.getCollaborator());
        taskDatbaseGateway.update(task);
        return new TaskResponseModel(true, "Collaborated added successfully");
    }
}
