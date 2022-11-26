package useCases.Tasks;

import entities.Task;
import gateways.Tasks.TaskDatbaseGateway;
import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;

/***
 * A use case that adds a tag to a Task
 */
public class AddTag implements AddTagInputBoundary {

    private final TaskDatbaseGateway taskDatbaseGateway;

    public AddTag(TaskDatbaseGateway taskDatbaseGateway) {
        this.taskDatbaseGateway = taskDatbaseGateway;
    }

    /**
     * Adds a tag to a task
     *
     * @param taskRequestModel Contains tag to be added
     */
    @Override
    public TaskResponseModel addTag(TaskRequestModel taskRequestModel) {
        Task task = taskDatbaseGateway.get(taskRequestModel.getName());
        task.addTag(taskRequestModel.getTag());
        taskDatbaseGateway.update(task);
        return new TaskResponseModel(true, "Tag added successfully");
    }
}
