package useCases.ViewCalendar;

import entities.Event;
import entities.User;
import entities.dataObjects.EventDataResponseObject;
import gateways.DataAccessInterface;
import services.CurrentUserService;

/**
 * An interactor class that implements the input boundary interface.
 */
public class ViewCalendarInteractor implements ViewCalendarInputBoundary {

    /**
     * the current user service.
     */
    CurrentUserService currentUserService;
    /**
     * The presenter associated with this interactor.
     */
    ViewCalendarPresenter presenter;

    /**
     * Constructs an interactor that fetches all events.
     * @param currentUserService the current user service to get the current user from.
     */
    public ViewCalendarInteractor(CurrentUserService currentUserService, ViewCalendarPresenter presenter){
        this.presenter = presenter;
        this.currentUserService = currentUserService;
    }

    /**
     * Load all events from this user's calendar and update
     * the ViewModel through the presenter.
     */
    @Override
    public void loadAllEvents() {
        ViewCalendarResponseModel response = new ViewCalendarResponseModel();

        User currentUser = currentUserService.getCurrentUser();

        if(currentUser == null){
            presenter.prepareFailView("User not logged in.");
            return;
        }

        for(Event event: currentUser.getEvents()){
            EventDataResponseObject eventDataResponseObject = event.prepareDataResponseObject();

            response.addEventResponseObject(eventDataResponseObject);
        }

        presenter.prepareSuccessView(response);
    }
}