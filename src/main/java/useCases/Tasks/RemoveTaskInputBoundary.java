package useCases.Tasks;

import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;

/**
 * An interface which hides the details of how a Task is removed from a User's list
 */
public interface RemoveTaskInputBoundary {

    /**
     * The method which removes a Task from a User's list
     *
     * @param taskRequestModel Contains the name of the Task to be removed
     * @return The Response Model containing information about the Task removed
     */
    TaskResponseModel removeTask(TaskRequestModel taskRequestModel);

}
