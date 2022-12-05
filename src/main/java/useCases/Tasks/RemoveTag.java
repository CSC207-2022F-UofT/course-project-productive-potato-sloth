package useCases.Tasks;

import entities.Tag;
import entities.Task;
import gateways.Tags.TagDataAccessInterface;
import gateways.Tasks.TaskDataAccessInterface;
import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;
import presenters.TaskPresenter;

/***
 * A use case that removes a tag from a Task
 */
public class RemoveTag implements RemoveTagInputBoundary {

    private final TaskDataAccessInterface taskDatabaseGateway;
    private final TagDataAccessInterface tagDatabaseGateway;
    private final TaskPresenter taskPresenter;

    public RemoveTag(
            TaskDataAccessInterface taskDatabaseGateway,
            TagDataAccessInterface tagDataAccessInterface,
            TaskPresenter taskPresenter
    ) {
        this.taskDatabaseGateway = taskDatabaseGateway;
        this.tagDatabaseGateway = tagDataAccessInterface;
        this.taskPresenter = taskPresenter;
    }

    /**
     * Adds a tag to a task
     *
     * @param taskRequestModel Contains tag to be added
     */
    @Override
    public TaskResponseModel removeTag(TaskRequestModel taskRequestModel) {
        Task task = taskDatabaseGateway.get(taskRequestModel.getName());
        Tag tag = tagDatabaseGateway.get(taskRequestModel.getTagName());
        task.removeTag(tag);
        taskDatabaseGateway.update(task);
        TaskResponseModel response = new TaskResponseModel(
                null,
                null,
                null,
                null,
                tag.getName(),
                null,
                true,
                "Tag removed successfully"
        );
        return taskPresenter.prepareSuccessView(response);
    }

}
