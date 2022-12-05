package useCases.Tasks;

import entities.Task;
import gateways.Tasks.TaskDataAccessInterface;
import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;
import presenters.TaskPresenter;

/**
 * A use case which marks a target task as complete
 */
public class MarkTaskCompleteness implements MarkTaskCompletenessInputBoundary {

    private final TaskDataAccessInterface taskDatabaseGateway;
    private final TaskPresenter taskPresenter;

    public MarkTaskCompleteness(TaskDataAccessInterface taskDatabaseGateway, TaskPresenter taskPresenter) {
        this.taskDatabaseGateway = taskDatabaseGateway;
        this.taskPresenter = taskPresenter;
    }


    @Override
    public TaskResponseModel setCompleteness(TaskRequestModel taskRequestModel) {
        Task task = taskDatabaseGateway.get(taskRequestModel.getName());
        if (taskRequestModel.getCompleted()) {
            task.setCompleted();
            taskDatabaseGateway.update(task);
            TaskResponseModel response = new TaskResponseModel(
                    null,
                    null,
                    null,
                    task.getCompleted(),
                    null,
                    null,
                    true,
                    "Task completed!"
            );
            return taskPresenter.prepareSuccessView(response);

        } else {
            task.setIncompleted();
            taskDatabaseGateway.update(task);
            TaskResponseModel response = new TaskResponseModel(
                    null,
                    null,
                    null,
                    task.getCompleted(),
                    null,
                    null,
                    true,
                    "Task incomplete!"
            );
            return taskPresenter.prepareSuccessView(response);
        }
    }
}
