package useCases.ViewCalendar;

public interface ViewCalendarPresenter {

    /**
     * Prepare the ViewModel to contain the information for
     * a success view to be shown.
     * @param response a response model for updating the view model
     */
    void prepareSuccessView(ViewCalendarResponseModel response);

    /**
     * Prepare the view model to contain the information for a
     * failure view to be shown.
     * @param error an error to add into the view model
     */
    void prepareFailView(String error);

}