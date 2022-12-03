package useCases.ViewCalendar;

public interface ViewCalendarPresenter {

    ViewCalendarResponseModel prepareSuccessView(ViewCalendarResponseModel response);

    ViewCalendarResponseModel prepareFailView(String error);

}
