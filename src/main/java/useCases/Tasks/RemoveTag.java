package useCases.Tasks;

import entities.Task;
import gateways.Tasks.TaskDatbaseGateway;
import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;

/***
 * A use case that removes a tag from a Task
 */
public class RemoveTag implements RemoveTagInputBoundary {

    private final TaskDatbaseGateway taskDatbaseGateway;

    public RemoveTag(TaskDatbaseGateway taskDatbaseGateway) {
        this.taskDatbaseGateway = taskDatbaseGateway;
    }

    /**
     * Adds a tag to a task
     *
     * @param taskRequestModel Contains tag to be added
     */
    @Override
    public TaskResponseModel removeTag(TaskRequestModel taskRequestModel) {
        Task task = taskDatbaseGateway.get(taskRequestModel.getName());
        task.removeTag(taskRequestModel.getTag());
        taskDatbaseGateway.update(task);
        return new TaskResponseModel(true, "Tag removed successfully");
    }

}
