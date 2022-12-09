package useCases.Tasks;

import entities.Task;
import entities.User;
import gateways.Tasks.TaskDataAccessInterface;
import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;
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
     * The presenter for Tasks
     */
    private final TaskPresenter taskPresenter;

    /**
     * Creates an instance of RemoveCollaborator with the required fields
     *
     * @param taskDatabaseGateway Interface for accessing Tasks
     * @param taskPresenter       Presenter for Tasks
     */
    public RemoveCollaborator(
            TaskDataAccessInterface taskDatabaseGateway,
            TaskPresenter taskPresenter
    ) {
        this.taskDatabaseGateway = taskDatabaseGateway;
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
                collaboratorName
        );
        return taskPresenter.prepareSuccessView(response);
    }
}
