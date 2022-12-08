package useCases.Tasks;

import entities.Task;
import entities.TaskFactory;
import gateways.Tasks.TaskDataAccessInterface;
import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;
import gateways.UserDatabaseGateway;
import presenters.TaskPresenter;
import services.CurrentUserService;

/**
 * A use case which adds a new Task to the User's list
 */
public class CreateTask implements CreateTaskInputBoundary {

    /**
     * The interface which allows access to the TaskDatabase
     */
    private final TaskDataAccessInterface taskDatabaseGateway;

    /**
     * The service allowing access to the current user
     */
    private final CurrentUserService currentUserService;

    /**
     * The required factory for creating Tasks
     */
    private final TaskFactory taskFactory;

    /**
     * The presenter for Tasks
     */
    private final TaskPresenter taskPresenter;

    /**
     * Creates an instance of CreateTask with the required fields
     *
     * @param taskDatabaseGateway Interface for accessing Tasks
     * @param userDatabaseGateway Interface for accessing Users
     * @param currentUserService  Service for accessing the logged-in user
     * @param taskFactory         Factory for creating Tasks
     * @param taskPresenter       Presenter for Tasks
     */
    public CreateTask(
            TaskDataAccessInterface taskDatabaseGateway,
            UserDatabaseGateway userDatabaseGateway,
            CurrentUserService currentUserService,
            TaskFactory taskFactory,
            TaskPresenter taskPresenter
    ) {
        this.taskDatabaseGateway = taskDatabaseGateway;
        /**
         * The interface which allows access to the UserDatabase
         */
        this.currentUserService = currentUserService;
        this.taskFactory = taskFactory;
        this.taskPresenter = taskPresenter;
    }

    /**
     * Creates a new Task with the fields specified in the Request model
     * Calling this method will persist the data: no additional calls to DataInterfaces are necessary
     *
     * @param taskRequestModel Contains all the fields required for creating a Task
     * @return A Response Model containing the information about the new Task
     */
    @Override
    public TaskResponseModel create(TaskRequestModel taskRequestModel) {

        if (taskDatabaseGateway.contains(taskRequestModel.getName())) {
            return taskPresenter.prepareFailView("Task already exists!");
        }

        Task newTask = taskFactory.create(taskRequestModel.getName(), currentUserService.getCurrentUser());

        taskDatabaseGateway.insert(newTask);

        TaskResponseModel response = new TaskResponseModel(
                newTask.getName(),
                null,
                newTask.getDescription(),
                newTask.getCompleted(),
                null,
                null,
                true,
                null
        );
        return taskPresenter.prepareSuccessView(response);
    }
}
