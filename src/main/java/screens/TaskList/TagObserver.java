package screens.TaskList;

import gateways.Tags.TagInfoResponseModel;

public interface TagObserver {

    /**
     * Updates the implementing class given a view model
     *
     * @param viewModel The updated view model
     */
    void update(TagInfoResponseModel viewModel);

}
