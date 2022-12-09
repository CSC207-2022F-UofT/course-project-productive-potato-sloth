package screens.ScheduleEvent;

public interface UseCaseObserver {

    /**
     * Update the use case after a change has been observed in another use
     * case.
     */
    public void useCaseUpdate();

}
