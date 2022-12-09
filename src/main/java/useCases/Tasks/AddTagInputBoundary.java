package useCases.Tasks;

import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;

/**
 * An interface which hides the details of how a Tag is added to a task
 */
public interface AddTagInputBoundary {

    /**
     * The method which adds a Tag to a task
     *
     * @param taskRequestModel The information necessary to add a Tag
     * @return The Response Model containing information about the Tag
     */
    TaskResponseModel addTag(TaskRequestModel taskRequestModel);
}
