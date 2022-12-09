package screens.ViewCalendar;

import useCases.ViewCalendar.ViewCalendarInputBoundary;

public class ViewCalendarController {

    ViewCalendarInputBoundary viewCalendarInteractor;

    public ViewCalendarController(ViewCalendarInputBoundary viewCalendarInteractor){
        this.viewCalendarInteractor = viewCalendarInteractor;
    }

    public void loadEvents(){
        // doesn't return anything as the presenter updates the view model, which
        // the view listens to.
        viewCalendarInteractor.loadAllEvents();
    }

}
