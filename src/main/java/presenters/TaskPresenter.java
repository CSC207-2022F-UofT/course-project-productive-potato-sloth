package presenters;

import gateways.Tasks.TaskResponseModel;

/**
 * An interface which hides the details of creating a viewModel for Task
 */
public interface TaskPresenter {

    /**
     * A method which prepares a successful view model for Tasks
     *
     * @param taskResponseModel The response from the output boundary
     * @return The view model
     */
    TaskResponseModel prepareSuccessView(TaskResponseModel taskResponseModel);

    /**
     * A method which prepares a failure view model for Tasks
     *
     * @param errorMessage The details of the error
     * @return The view model
     */
    TaskResponseModel prepareFailView(String errorMessage);
}
