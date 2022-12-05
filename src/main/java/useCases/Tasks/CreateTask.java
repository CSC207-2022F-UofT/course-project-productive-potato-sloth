package useCases.Tasks;

import entities.Task;
import entities.TaskFactory;
import gateways.Tasks.TaskDataAccessInterface;
import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;
import gateways.UserDatabaseGateway;
import presenters.TaskPresenter;
import services.CurrentUserService;

public class CreateTask implements CreateTaskInputBoundary {

    private TaskDataAccessInterface taskDatabaseGateway;
    private UserDatabaseGateway userDatabaseGateway;
    private CurrentUserService currentUserService;
    private TaskFactory taskFactory;
    private TaskPresenter taskPresenter;

    public CreateTask(
            TaskDataAccessInterface taskDataAccessInterface,
            UserDatabaseGateway userDatabaseGateway,
            CurrentUserService currentUserService,
            TaskFactory taskFactory,
            TaskPresenter taskPresenter
    ) {
        this.taskDatabaseGateway = taskDataAccessInterface;
        this.userDatabaseGateway = userDatabaseGateway;
        this.currentUserService = currentUserService;
        this.taskFactory = taskFactory;
        this.taskPresenter = taskPresenter;
    }

    @Override
    public TaskResponseModel create(TaskRequestModel taskRequestModel) {

        if (taskDatabaseGateway.contains(taskRequestModel.getNewName()) && !(taskRequestModel.getName().equals(taskRequestModel.getNewName()))) {
            return taskPresenter.prepareFailView("Task already exists!");
        }

        Task newTask = taskFactory.create(taskRequestModel.getName(), currentUserService.getCurrentUser());
        currentUserService.getCurrentUser().addTask(newTask);
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
