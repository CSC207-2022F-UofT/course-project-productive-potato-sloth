package screens.ScheduleEvent;

public interface UseCaseSubjectInterface {

    /**
     * Add a use case observer that observes this use case.
     * @param observer another use case that observes this one.
     */
    public void addUseCaseObserver(UseCaseObserver observer);

    /**
     * Remove a use case that observes this one.
     * @param observer a use case that is currently observing this one.
     */
    public void removeUseCaseObserver(UseCaseObserver observer);

    /**
     * Update all use cases observing this use case.
     */
    public void updateUseCaseObservers();
}
