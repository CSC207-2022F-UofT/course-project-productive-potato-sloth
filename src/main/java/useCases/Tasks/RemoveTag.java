package useCases.Tasks;

import entities.Task;
import gateways.Tasks.TaskDataAccessInterface;
import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;

/***
 * A use case that removes a tag from a Task
 */
public class RemoveTag implements RemoveTagInputBoundary {

    private final TaskDataAccessInterface taskDatabaseGateway;

    public RemoveTag(TaskDataAccessInterface taskDatabaseGateway) {
        this.taskDatabaseGateway = taskDatabaseGateway;
    }

    /**
     * Adds a tag to a task
     *
     * @param taskRequestModel Contains tag to be added
     */
    @Override
    public TaskResponseModel removeTag(TaskRequestModel taskRequestModel) {
        Task task = taskDatabaseGateway.get(taskRequestModel.getName());
        task.removeTag(taskRequestModel.getTag());
        taskDatabaseGateway.update(task);
        return new TaskResponseModel(true, "Tag removed successfully");
    }

}
