package useCases.Tasks;

import entities.Task;
import entities.User;
import gateways.Tasks.TaskDataAccessInterface;
import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;
import gateways.UserDatabaseGateway;
import presenters.TaskPresenter;

/***
 * A use case which adds a collaborator to a User's Task
 */
public class RemoveCollaborator implements RemoveCollaboratorInputBoundary {

    private final TaskDataAccessInterface taskDatabaseGateway;
    private final UserDatabaseGateway userDatabaseGateway;
    private final TaskPresenter taskPresenter;

    public RemoveCollaborator(
            TaskDataAccessInterface taskDatabaseGateway,
            UserDatabaseGateway userDatabaseGateway,
            TaskPresenter taskPresenter
    ) {
        this.taskDatabaseGateway = taskDatabaseGateway;
        this.userDatabaseGateway = userDatabaseGateway;
        this.taskPresenter = taskPresenter;
    }

    @Override
    public TaskResponseModel removeCollaborator(TaskRequestModel taskRequestModel) {
        Task task = taskDatabaseGateway.get(taskRequestModel.getName());
        User collaborator = userDatabaseGateway.get(taskRequestModel.getCollaborator());
        task.removeCollaborator(collaborator);
        taskDatabaseGateway.update(task);
        TaskResponseModel response = new TaskResponseModel(
                null,
                null,
                null,
                null,
                null,
                collaborator.getUsername(),
                true,
                "Collaborated removed successfully"
        );
        return taskPresenter.prepareSuccessView(response);
    }
}
