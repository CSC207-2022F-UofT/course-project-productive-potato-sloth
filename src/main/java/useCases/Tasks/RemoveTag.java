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

    /**
     * The interface which allows access to the TaskDatabase
     */
    private final TaskDataAccessInterface taskDatabaseGateway;

    /**
     * The interface which allows access to the TagDatabase
     */
    private final TagDataAccessInterface tagDatabaseGateway;

    /**
     * The presenter for Tasks
     */
    private final TaskPresenter taskPresenter;

    /**
     * Creates an instance of RemoveTag with the required fields
     *
     * @param taskDatabaseGateway Interface for accessing Tasks
     * @param tagDatabaseGateway  Interface for accessing Tags
     * @param taskPresenter       Presenter for Tasks
     */
    public RemoveTag(
            TaskDataAccessInterface taskDatabaseGateway,
            TagDataAccessInterface tagDatabaseGateway,
            TaskPresenter taskPresenter
    ) {
        this.taskDatabaseGateway = taskDatabaseGateway;
        this.tagDatabaseGateway = tagDatabaseGateway;
        this.taskPresenter = taskPresenter;
    }

    /**
     * Removes a Tag from a Task
     *
     * @param taskRequestModel Contains information about the tag to be removed
     * @return A Response Model containing the name of the tag removed
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
                null
        );
        return taskPresenter.prepareSuccessView(response);
    }

}
