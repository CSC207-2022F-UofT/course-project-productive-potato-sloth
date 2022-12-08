package useCases.Tasks;

import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;

/**
 * An interface which hides the details of how a Tag is removed from a task
 */
public interface RemoveTagInputBoundary {

    /**
     * The method which removes a Tag from a Task
     *
     * @param taskRequestModel Contains the name of the Tag to be removed
     * @return The Response Model containing the name of the Tag removed
     */
    TaskResponseModel removeTag(TaskRequestModel taskRequestModel);

}
