package useCases.Tasks;

import entities.Task;
import gateways.Tasks.TaskDatbaseGateway;
import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;

/***
 * A use case which adds a collaborator to a User's Task
 */
public class RemoveCollaborator implements RemoveCollaboratorInputBoundary {

    private final TaskDatbaseGateway taskDatbaseGateway;

    public RemoveCollaborator(TaskDatbaseGateway taskDatbaseGateway) {
        this.taskDatbaseGateway = taskDatbaseGateway;
    }

    @Override
    public TaskResponseModel removeCollaborator(TaskRequestModel taskRequestModel) {
        Task task = taskDatbaseGateway.get(taskRequestModel.getName());
        task.removeCollaborator(taskRequestModel.getCollaborator());
        taskDatbaseGateway.update(task);
        return new TaskResponseModel(true, "Collaborated removed successfully");
    }
}
