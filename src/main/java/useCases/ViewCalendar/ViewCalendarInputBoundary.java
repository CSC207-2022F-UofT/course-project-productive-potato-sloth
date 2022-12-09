package useCases.ViewCalendar;

public interface ViewCalendarInputBoundary {

    /**
     * The single method that the interactor is responsible
     * for implementing; load all events in this user's
     * calendar.
     */
    void loadAllEvents();

}