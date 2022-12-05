package useCases.Tasks;

import entities.Task;
import gateways.Tasks.TaskDataAccessInterface;
import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;
import presenters.TaskPresenter;
import presenters.TaskResponseFormatter;

/**
 * A use case which edits the attributes of a Task
 */
public class EditTask implements EditTaskInputBoundary {

    private final TaskDataAccessInterface taskDatabaseGateway;
    private final TaskPresenter taskPresenter;

    public EditTask(TaskDataAccessInterface taskDatabaseGateway, TaskPresenter taskPresenter) {
        this.taskDatabaseGateway = taskDatabaseGateway;
        this.taskPresenter = taskPresenter;
    }


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



