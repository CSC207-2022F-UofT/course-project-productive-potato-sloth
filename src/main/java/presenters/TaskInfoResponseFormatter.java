package presenters;

import gateways.Tasks.TaskInfoResponseModel;
import screens.TaskList.TaskError;

/**
 * A presenter which formats the Tag response into a view model
 */
public class TaskInfoResponseFormatter implements TaskInfoPresenter {

    /**
     * Prepares a successful view model for Task info
     *
     * @param taskInfoResponseModel The response from the output boundary
     * @return The view model
     */
    @Override
    public TaskInfoResponseModel prepareSuccessView(TaskInfoResponseModel taskInfoResponseModel) {
        return taskInfoResponseModel;

    }

    /**
     * Prepares a failure view model for Task info
     *
     * @param errorMessage The details of the error
     * @return The view model
     */
    @Override
    public TaskInfoResponseModel prepareFailView(String errorMessage) {
        throw new TaskError(errorMessage);
    }
}
