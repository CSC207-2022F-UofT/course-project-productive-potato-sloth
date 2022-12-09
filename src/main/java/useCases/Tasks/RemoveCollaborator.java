package useCases.Tasks;

import entities.Task;
import entities.User;
import gateways.Tasks.TaskDataAccessInterface;
import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;
import gateways.UserDataAccessInterface;
import gateways.UserDatabaseGateway;
import presenters.TaskPresenter;

/***
 * A use case which removes a collaborator from a User's Task
 */
public class RemoveCollaborator implements RemoveCollaboratorInputBoundary {

    /**
     * The interface which allows access to the TaskDatabase
     */
    private final TaskDataAccessInterface taskDatabaseGateway;

    /**
     * The interface which allows access to the UserDatabase
     */
    private final UserDatabaseGateway userDatabaseGateway;

    /**
     * The presenter for Tasks
     */
    private final TaskPresenter taskPresenter;

    /**
     * Creates an instance of RemoveCollaborator with the required fields
     *
     * @param taskDatabaseGateway Interface for accessing Tasks
     * @param userDatabaseGateway Interface for accessing Users
     * @param taskPresenter       Presenter for Tasks
     */
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
        String collaboratorName = "";
        for (User collaborator : task.getCollaborator()) {
            if (collaborator.getUsername().equals(taskRequestModel.getCollaborator())) {
                task.removeCollaborator(collaborator);
                collaboratorName = collaborator.getUsername();
                break;
            }
        }

        taskDatabaseGateway.update(task);
        TaskResponseModel response = new TaskResponseModel(
                null,
                null,
                null,
                null,
                null,
                collaboratorName,
                true,
                "Collaborated removed successfully"
        );
        return taskPresenter.prepareSuccessView(response);
    }
}
