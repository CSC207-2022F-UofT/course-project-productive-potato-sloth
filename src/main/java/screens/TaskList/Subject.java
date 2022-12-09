package screens.TaskList;

import gateways.Tasks.TaskInfoResponseModel;

/**
 * An interface which represents the Subject in the Observer Design Pattern
 */
public interface Subject {

    /**
     * Register an observer to receive updates
     *
     * @param o The new observer
     */
    void registerObserver(Observer o);

    /**
     * Removes an observer from receiving updates
     *
     * @param o The observer to remove
     */
    void removeObserver(Observer o);

    /**
     * Updates all observers which are registered
     *
     * @param viewModel The view model that is updated
     */
    void updateObservers(TaskInfoResponseModel viewModel);
}
