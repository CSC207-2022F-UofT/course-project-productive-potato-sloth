package useCases.ViewCalendar;

import entities.Event;
import entities.User;
import entities.dataObjects.EventDataResponseObject;
import gateways.DataAccessInterface;
import services.CurrentUserService;

public class ViewCalendarInteractor implements ViewCalendarInputBoundary {

    DataAccessInterface<User> gateway;

    CurrentUserService currentUserService;
    ViewCalendarPresenter presenter;

    public ViewCalendarInteractor(DataAccessInterface<User> gateway, CurrentUserService currentUserService, ViewCalendarPresenter presenter){
        this.gateway = gateway;
        this.presenter = presenter;
        this.currentUserService = currentUserService;
    }

    @Override
    public ViewCalendarResponseModel getAllEvents() {
        ViewCalendarResponseModel response = new ViewCalendarResponseModel();

        User currentUser = currentUserService.getCurrentUser();

        if(currentUser == null){
            return presenter.prepareFailView("User not logged in.");
        }

        for(Event event: currentUser.getEvents()){
            EventDataResponseObject eventDataResponseObject = event.prepareDataResponseObject();

            response.addEventResponseObject(eventDataResponseObject);
        }

        return presenter.prepareSuccessView(response);

    }
}
