package useCases.Tasks;

import entities.Task;
import gateways.Tasks.TaskDataAccessInterface;
import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;

/***
 * A use case which adds a collaborator to a User's Task
 */
public class RemoveCollaborator implements RemoveCollaboratorInputBoundary {

    private final TaskDataAccessInterface taskDatabaseGateway;

    public RemoveCollaborator(TaskDataAccessInterface taskDatabaseGateway) {
        this.taskDatabaseGateway = taskDatabaseGateway;
    }

    @Override
    public TaskResponseModel removeCollaborator(TaskRequestModel taskRequestModel) {
        Task task = taskDatabaseGateway.get(taskRequestModel.getName());
        task.removeCollaborator(taskRequestModel.getCollaborator());
        taskDatabaseGateway.update(task);
        return new TaskResponseModel(true, "Collaborated removed successfully");
    }
}
