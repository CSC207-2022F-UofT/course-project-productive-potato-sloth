package useCases.Tasks;

import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;

/**
 * An interface which hides the details of how a Task is edited
 */
public interface EditTaskInputBoundary {

    /**
     * The method which edits the name of the Task
     *
     * @param taskRequestModel The information necessary to edit the name
     * @return The Response Model containing the new name
     */
    TaskResponseModel editName(TaskRequestModel taskRequestModel);

    /**
     * The method which edits the description of the Task
     *
     * @param taskRequestModel The information necessary to edit the description
     * @return The Response Model containing the new description
     */
    TaskResponseModel editDescription(TaskRequestModel taskRequestModel);
}
