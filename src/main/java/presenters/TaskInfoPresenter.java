package presenters;

import gateways.Tasks.TaskInfoResponseModel;

/**
 * An interface which hides the details of creating a viewModel for Task info
 */
public interface TaskInfoPresenter {

    /**
     * A method which prepares a successful view model for Task info
     *
     * @param taskInfoResponseModel The response from the output boundary
     * @return The view model
     */
    TaskInfoResponseModel prepareSuccessView(TaskInfoResponseModel taskInfoResponseModel);

    /**
     * A method which prepares a failure view model for Task info
     *
     * @param errorMessage The details of the error
     * @return The view model
     */
    TaskInfoResponseModel prepareFailView(String errorMessage);
}
