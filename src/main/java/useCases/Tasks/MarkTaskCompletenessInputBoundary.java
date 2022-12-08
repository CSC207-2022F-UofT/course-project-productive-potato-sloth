package useCases.Tasks;

import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;

/**
 * An interface which hides the details of how a Task is marked as complete/incomplete
 */
public interface MarkTaskCompletenessInputBoundary {

    /**
     * Sets the Task in the Request as complete/incomplete based on the Request
     *
     * @param taskRequestModel The information about the completeness of a Task
     * @return The Response Model containing information about Task completeness
     */
    TaskResponseModel setCompleteness(TaskRequestModel taskRequestModel);
}
