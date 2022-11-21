package useCases.ScheduleEvent;

import entities.Event;
import entities.User;
import gateways.DataAccessInterface;
import services.CurrentUserService;

// TODO: document this class
public class ScheduleEventInteractor {

    CurrentUserService currentUserService;
    DataAccessInterface<User> database;

    ScheduleEventInteractor(CurrentUserService currentUserService, DataAccessInterface<User> database){
        this.currentUserService = currentUserService;
        this.database = database;
    }

//    public Event scheduleEvent(ScheduleEventInputData inputData){
//
//        User user = currentUserService.getCurrentUser();
//
//         check that the collaborator usernames are all valid
//        for(String username: inputData.collaborator_usernames){
//            User corresponding_user = database.get(user);
//        }
//        user.getTa
//
//        Event newEvent = new Event(
//                inputData.start_time,
//                inputData.end_time,
//                inputData.collaborator_usernames,
//                inputData.task
//        );
//
//    }
}
