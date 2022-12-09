package useCases.Tasks;

import entities.Tag;
import entities.Task;
import gateways.Tags.TagDataAccessInterface;
import gateways.Tasks.TaskDataAccessInterface;
import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;
import presenters.TaskPresenter;

/***
 * A use case that adds a tag to a Task
 */
public class AddTag implements AddTagInputBoundary {

    /**
     * The interface which allows access to the TaskDatabase
     */
    private final TaskDataAccessInterface taskDatabaseGateway;

    /**
     * The interface which allows access to the TagDatabase
     */
    private final TagDataAccessInterface tagDatabaseGateway;

    /**
     * The presenter for Tags
     */
    private final TaskPresenter taskPresenter;

    /**
     * Creates an instance of AddTag with the required fields
     *
     * @param taskDatabaseGateway Interface for accessing Tasks
     * @param tagDatabaseGateway  Interface for accessing Tags
     * @param taskPresenter       Presenter for Tasks
     */
    public AddTag(
            TaskDataAccessInterface taskDatabaseGateway,
            TagDataAccessInterface tagDatabaseGateway,
            TaskPresenter taskPresenter
    ) {
        this.taskDatabaseGateway = taskDatabaseGateway;
        this.tagDatabaseGateway = tagDatabaseGateway;
        this.taskPresenter = taskPresenter;
    }


    /**
     * Adds a tag to a task
     *
     * @param taskRequestModel Contains all fields required for creating a Tag
     * @return A Response Model containing the information about the Tag
     */
    @Override
    public TaskResponseModel addTag(TaskRequestModel taskRequestModel) {
        Task task = taskDatabaseGateway.get(taskRequestModel.getName());
        Tag tag = tagDatabaseGateway.get(taskRequestModel.getTagName());
        task.addTag(tag);
        taskDatabaseGateway.update(task);
        TaskResponseModel response = new TaskResponseModel(
                null,
                null,
                null,
                null,
                tag.getName(),
                null,
                true,
                "Tag added successfully"
        );
        return taskPresenter.prepareSuccessView(response);
    }
}
