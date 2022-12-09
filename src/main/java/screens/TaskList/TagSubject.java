package screens.TaskList;

import gateways.Tags.TagInfoResponseModel;

public interface TagSubject {

    /**
     * Register an observer to receive updates
     *
     * @param o The new observer
     */
    void registerObserver(TagObserver o);

    /**
     * Removes an observer from receiving updates
     *
     * @param o The observer to remove
     */
    void removeObserver(TagObserver o);

    /**
     * Updates all observers which are registered
     *
     * @param viewModel The view model that is updated
     */
    void updateObservers(TagInfoResponseModel viewModel);
}
