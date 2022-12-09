package useCases.ViewCalendar;

import entities.Event;
import entities.User;
import entities.dataObjects.EventDataResponseObject;
import gateways.DataAccessInterface;
import services.CurrentUserService;

public class ViewCalendarInteractor implements ViewCalendarInputBoundary {

    CurrentUserService currentUserService;
    ViewCalendarPresenter presenter;

    public ViewCalendarInteractor(CurrentUserService currentUserService, ViewCalendarPresenter presenter){
        this.presenter = presenter;
        this.currentUserService = currentUserService;
    }

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