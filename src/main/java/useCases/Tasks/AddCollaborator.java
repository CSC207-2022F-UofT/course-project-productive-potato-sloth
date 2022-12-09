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
public class AddCollaborator implements AddCollaboratorInputBoundary {

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
     * Creates an instance of AddCollaborator with the required fields
     *
     * @param taskDatabaseGateway Interface for accessing Tasks
     * @param userDatabaseGateway Interface for accessing Users
     * @param taskPresenter       Presenter for Tasks
     */
    public AddCollaborator(
            TaskDataAccessInterface taskDatabaseGateway,
            UserDatabaseGateway userDatabaseGateway,
            TaskPresenter taskPresenter
    ) {
        this.taskDatabaseGateway = taskDatabaseGateway;
        this.userDatabaseGateway = userDatabaseGateway;
        this.taskPresenter = taskPresenter;
    }

    /**
     * Adds the collaborator specified in the Request to the Task specified in the Request
     * Calling this method will persist the data: no additional calls to DataInterfaces are necessary
     *
     * @param taskRequestModel Contains all the fields required for creating a Task
     * @return A Response Model containing information about the collaborator
     */
    @Override
    public TaskResponseModel addCollaborator(TaskRequestModel taskRequestModel) {
        Task task = taskDatabaseGateway.get(taskRequestModel.getName());
        User collaborator = userDatabaseGateway.get(taskRequestModel.getCollaborator());
        task.addCollaborator(collaborator);
        taskDatabaseGateway.update(task);
        TaskResponseModel response = new TaskResponseModel(
                null,
                null,
                null,
                null,
                null,
                collaborator.getUsername()
        );
        return taskPresenter.prepareSuccessView(response);
    }
}
