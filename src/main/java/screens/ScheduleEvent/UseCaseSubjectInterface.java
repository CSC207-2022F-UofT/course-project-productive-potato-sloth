package screens.ScheduleEvent;

public interface UseCaseSubjectInterface {

    public void addUseCaseObserver(UseCaseObserver observer);

    public void removeUseCaseObserver(UseCaseObserver observer);

    public void updateUseCaseObservers();
}
