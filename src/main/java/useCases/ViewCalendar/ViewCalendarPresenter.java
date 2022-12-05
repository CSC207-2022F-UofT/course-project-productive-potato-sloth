package useCases.ViewCalendar;

public interface ViewCalendarPresenter {

    void prepareSuccessView(ViewCalendarResponseModel response);

    void prepareFailView(String error);

}
