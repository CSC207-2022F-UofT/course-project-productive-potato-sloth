package controllers.Events;

import useCases.ViewCalendar.ViewCalendarInputBoundary;

/**
 * A controller to relay information from the ViewCalendarScreen
 * to the ViewCalendarInteractor.
 */
public class ViewCalendarController {

    /**
     * The interactor that implements the input boundary.
     */
    ViewCalendarInputBoundary viewCalendarInteractor;

    /**
     * A constructor for the controller that takes in the following:
     * @param viewCalendarInteractor an interactor to initialize this controller.
     */
    public ViewCalendarController(ViewCalendarInputBoundary viewCalendarInteractor){
        this.viewCalendarInteractor = viewCalendarInteractor;
    }

    /**
     * Load all events using the interactor.
     */
    public void loadEvents(){
        // doesn't return anything as the presenter updates the view model, which
        // the view listens to.
        viewCalendarInteractor.loadAllEvents();
    }

}
