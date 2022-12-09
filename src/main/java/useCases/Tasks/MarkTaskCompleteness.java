package useCases.Tasks;

import entities.Task;
import gateways.Tasks.TaskDataAccessInterface;
import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;
import presenters.TaskPresenter;

/**
 * A use case which marks a target task as complete or incomplete
 */
public class MarkTaskCompleteness implements MarkTaskCompletenessInputBoundary {

    /**
     * The interface which allows access to the TaskDatabase
     */
    private final TaskDataAccessInterface taskDatabaseGateway;

    /**
     * The presenter for Tasks
     */
    private final TaskPresenter taskPresenter;

    /**
     * Creates an instance of MarkTaskCompleteness with the required fields
     *
     * @param taskDatabaseGateway Interface for accessing Tasks
     * @param taskPresenter       Presenter for Tasks
     */
    public MarkTaskCompleteness(TaskDataAccessInterface taskDatabaseGateway, TaskPresenter taskPresenter) {
        this.taskDatabaseGateway = taskDatabaseGateway;
        this.taskPresenter = taskPresenter;
    }

    /**
     * Sets the completeness of the Task specified in the Request with the fields in the Request
     * Calling this method will persist the data: no additional calls to DataInterfaces are necessary
     *
     * @param taskRequestModel Contains all the fields required for the completeness of a Task
     * @return A Response Model containing the completeness of the Task
     */
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
