package screens.TaskList;

import gateways.Tasks.TaskInfoResponseModel;

/**
 * An interface which represents the Observer in the Observer Design Pattern
 */
public interface Observer {

    /**
     * Updates the implementing class given a view model
     *
     * @param viewModel The updated view model
     */
    void update(TaskInfoResponseModel viewModel);
}
