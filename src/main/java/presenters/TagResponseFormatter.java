package presenters;

import gateways.Tags.TagResponseModel;
import screens.TaskList.TagError;

/**
 * A presenter which formats the Tag response into a view model
 */
public class TagResponseFormatter implements TagPresenter {

    /**
     * Prepares a successful view model for Tags
     *
     * @param tagResponseModel The response from the output boundary
     * @return The view model
     */
    @Override
    public TagResponseModel prepareSuccessView(TagResponseModel tagResponseModel) {

        return tagResponseModel;
    }

    /**
     * Prepares a failure view model for Tags
     *
     * @param errorMessage The details of the error
     * @return The view model
     */
    @Override
    public TagResponseModel prepareFailView(String errorMessage) {
        throw new TagError(errorMessage);
    }
}
