package presenters;

import gateways.Tags.TagResponseModel;

/**
 * An interface which hides the details of creating a viewModel for Tags
 */
public interface TagPresenter {

    /**
     * A method which prepares a successful view model for Tags
     *
     * @param tagResponseModel The response from the output boundary
     * @return The view model
     */
    TagResponseModel prepareSuccessView(TagResponseModel tagResponseModel);

    /**
     * A method which prepares a failure view model for Tags
     *
     * @param errorMessage The details of the error
     * @return The view model
     */
    TagResponseModel prepareFailView(String errorMessage);
}
