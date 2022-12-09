package useCases.Tasks;

import entities.Task;
import gateways.Tasks.TaskDataAccessInterface;
import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;
import presenters.TaskPresenter;

/**
 * A use case which edits the attributes of a Task
 */
public class EditTask implements EditTaskInputBoundary {

    /**
     * The interface which allows access to the TaskDatabase
     */
    private final TaskDataAccessInterface taskDatabaseGateway;

    /**
     * The presenter for Tasks
     */
    private final TaskPresenter taskPresenter;

    /**
     * Creates an instance of EditTask with the required fields
     *
     * @param taskDatabaseGateway Interface for accessing Tasks
     * @param taskPresenter       Presenter for Tasks
     */
    public EditTask(TaskDataAccessInterface taskDatabaseGateway, TaskPresenter taskPresenter) {
        this.taskDatabaseGateway = taskDatabaseGateway;
        this.taskPresenter = taskPresenter;
    }


    /**
     * Edits the name of the task with the fields specified in the Request
     * Calling this method will persist the data: no additional calls to DataInterfaces are necessary
     *
     * @param taskRequestModel Contains all the fields required for editing the name of a Task
     * @return A Response Model containing the new name
     */
    @Override
    public TaskResponseModel editName(TaskRequestModel taskRequestModel) {
        Task task = taskDatabaseGateway.get(taskRequestModel.getName());

        if (taskDatabaseGateway.contains(taskRequestModel.getNewName()) && !(taskRequestModel.getName().equals(taskRequestModel.getNewName()))) {
            return taskPresenter.prepareFailView("Task already exists!");
        }

        if (!(taskRequestModel.getNewName().equals(task.getName()))) {
            task.setName(taskRequestModel.getNewName());
            taskDatabaseGateway.update(task);
        }

        TaskResponseModel response = new TaskResponseModel(
                null,
                task.getName(),
                null,
                null,
                null,
                null,
                true,
                "Name changed successfully"
        );
        return taskPresenter.prepareSuccessView(response);

    }

    /**
     * Edits the description of the task with the fields specified in the Request
     * Calling this method will persist the data: no additional calls to DataInterfaces are necessary
     *
     * @param taskRequestModel Contains all the fields required for editing the description of a Task
     * @return A Response Model containing the new description
     */
    @Override
    public TaskResponseModel editDescription(TaskRequestModel taskRequestModel) {
        Task task = taskDatabaseGateway.get(taskRequestModel.getName());
        task.setDescription(taskRequestModel.getDescription());
        taskDatabaseGateway.update(task);
        TaskResponseModel response = new TaskResponseModel(
                null,
                null,
                task.getDescription(),
                null,
                null,
                null,
                true,
                "Description changed successfully"
        );
        return taskPresenter.prepareSuccessView(response);
    }
}



