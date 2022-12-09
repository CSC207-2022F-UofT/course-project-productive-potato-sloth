package screens.ViewCalendar;

public interface ViewModelSubjectInterface {

    /**
     * A method to add an observer for the view model.
     * @param observer a new observer of the view mdoel
     */
    public void addObserver(ViewModelObserver observer);

    /**
     * A method to remove an observer from the view model.
     * @param observer an observer of the view mdoel
     */
    public void removeObserver(ViewModelObserver observer);

    /**
     * A method to update all observers listening to the view model.
     */
    public void updateObservers();

}
