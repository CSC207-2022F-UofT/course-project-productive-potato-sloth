package presenters;

import gateways.Tasks.TaskResponseModel;
import screens.TaskList.TaskError;

/**
 * A presenter which formats the Tag response into a view model
 */
public class TaskResponseFormatter implements TaskPresenter {

    /**
     * Prepares a successful view model for Tasks
     *
     * @param taskResponseModel The response from the output boundary
     * @return The view model
     */
    @Override
    public TaskResponseModel prepareSuccessView(TaskResponseModel taskResponseModel) {
        return taskResponseModel;
    }

    /**
     * Prepares a failure view model for Tasks
     *
     * @param errorMessage The details of the error
     * @return The view model
     */
    @Override
    public TaskResponseModel prepareFailView(String errorMessage) {
        throw new TaskError(errorMessage);
    }
}
