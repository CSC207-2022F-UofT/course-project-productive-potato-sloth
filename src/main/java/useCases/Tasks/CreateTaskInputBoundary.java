package useCases.Tasks;

import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;

/**
 * An interface which hides the details of how a Task is created
 */
public interface CreateTaskInputBoundary {

    /**
     * The method which creates a Task
     *
     * @param taskRequestModel The information necessary to create a Task
     * @return The Response Model containing information about the Task
     */
    TaskResponseModel create(TaskRequestModel taskRequestModel);
}
