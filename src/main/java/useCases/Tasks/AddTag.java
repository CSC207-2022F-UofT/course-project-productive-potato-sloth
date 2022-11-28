package useCases.Tasks;

import entities.Task;
import gateways.Tasks.TaskDataAccessInterface;
import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;

/***
 * A use case that adds a tag to a Task
 */
public class AddTag implements AddTagInputBoundary {

    private final TaskDataAccessInterface taskDatabaseGateway;

    public AddTag(TaskDataAccessInterface taskDatabaseGateway) {
        this.taskDatabaseGateway = taskDatabaseGateway;
    }

    /**
     * Adds a tag to a task
     *
     * @param taskRequestModel Contains tag to be added
     */
    @Override
    public TaskResponseModel addTag(TaskRequestModel taskRequestModel) {
        Task task = taskDatabaseGateway.get(taskRequestModel.getName());
        task.addTag(taskRequestModel.getTag());
        taskDatabaseGateway.update(task);
        return new TaskResponseModel(true, "Tag added successfully");
    }
}
