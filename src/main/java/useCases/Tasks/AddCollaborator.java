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

    private final TaskDataAccessInterface taskDatbaseGateway;
    private final UserDatabaseGateway userDatabaseGateway;
    private final TaskPresenter taskPresenter;

    public AddCollaborator(
            TaskDataAccessInterface taskDatbaseGateway,
            UserDatabaseGateway userDatabaseGateway,
            TaskPresenter taskPresenter
    ) {
        this.taskDatbaseGateway = taskDatbaseGateway;
        this.userDatabaseGateway = userDatabaseGateway;
        this.taskPresenter = taskPresenter;
    }

    @Override
    public TaskResponseModel addCollaborator(TaskRequestModel taskRequestModel) {
        Task task = taskDatbaseGateway.get(taskRequestModel.getName());
        User collaborator = userDatabaseGateway.get(taskRequestModel.getCollaborator());
        task.addCollaborator(collaborator);
        taskDatbaseGateway.update(task);
        TaskResponseModel response = new TaskResponseModel(
                null,
                null,
                null,
                null,
                null,
                collaborator.getUsername(),
                true,
                "Collaborated added successfully"
        );
        return taskPresenter.prepareSuccessView(response);
    }
}
