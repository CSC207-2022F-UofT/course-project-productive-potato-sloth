package useCases.ScheduleEvent;

import entities.Event;
import entities.User;
import services.CurrentUserService;

// TODO: document this class
public class ScheduleEventInteractor {

    CurrentUserService currentUserService;

    ScheduleEventInteractor(CurrentUserService currentUserService){
        this.currentUserService = currentUserService;
    }

//    public Event scheduleEvent(ScheduleEventInputData inputData){
//
//        User user = currentUserService.getCurrentUser();
//
//    }
}
