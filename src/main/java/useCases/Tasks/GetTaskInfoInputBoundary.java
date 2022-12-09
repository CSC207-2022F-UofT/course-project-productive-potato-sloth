package useCases.Tasks;

import gateways.Tasks.TaskInfoRequestModel;
import gateways.Tasks.TaskInfoResponseModel;

/**
 * An interface which hides the details behind retrieving Task info
 */
public interface GetTaskInfoInputBoundary {

    /**
     * The method which creates retrieves the info of a Task
     *
     * @param taskInfoRequestModel Contains the name of the Task
     * @return The Response Model containing all information about the Task
     */
    TaskInfoResponseModel getInfo(TaskInfoRequestModel taskInfoRequestModel);

}
