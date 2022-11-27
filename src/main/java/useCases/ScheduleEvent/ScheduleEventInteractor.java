package useCases.ScheduleEvent;

import entities.Event;
import entities.Tag;
import entities.Task;
import entities.User;
import gateways.DataAccessInterface;
import screens.ScheduleEvent.ScheduleEventResponseModel;
import services.CurrentUserService;

import java.util.ArrayList;
import java.util.List;

// TODO: document this class
public class ScheduleEventInteractor implements ScheduleEventInputBoundary{

    CurrentUserService currentUserService;
    DataAccessInterface<User> database;

    ScheduleEventPresenter presenter;

    public ScheduleEventInteractor(CurrentUserService currentUserService, DataAccessInterface<User> database, ScheduleEventPresenter scheduleEventPresenter){
        this.currentUserService = currentUserService;
        this.database = database;
        this.presenter = scheduleEventPresenter;
    }

    public ScheduleEventResponseModel scheduleEvent(ScheduleEventRequestModel requestModel){

        User currentUser = currentUserService.getCurrentUser();

        /*
        Check that the task exists, if given. Select it.
        Once the User.getTask(taskName) method is implemented, this code will be
        significantly simplified.
         */

        Task selectedTask = null;

        if(requestModel.taskName != null){
            for(Task task: currentUser.getTasks()){
                if(task.getName().equals(requestModel.taskName)){
                    selectedTask = task;
                    break;
                }
            }
            if(selectedTask == null){
                return presenter.prepareFailView("No task with the given name exists.");
            }
        }

        /*
        Check that the tags exist. Select them into an array.
        Once the User.getTag(tagName) method is implemented, this code will be
        significantly simplified.
         */

        List<Tag> eventTags = new ArrayList<>();
//        for(String tagName: requestModel.tagNames){
//            for(Tag tag: currentUser.getTags()){
//                if(tag.getName().equals(tagName)){
//                    eventTags.add(tag);
//                }
//            }
//        }

        /*
        Check that the times are not null.
        Check that the event ends after it starts.
         */

        if(requestModel.start_time == null){
            return presenter.prepareFailView("No start time provided.");
        }

        if(requestModel.end_time == null){
            return presenter.prepareFailView("No end time provided.");
        }

        if(requestModel.start_time.isAfter(requestModel.end_time)){
            return presenter.prepareFailView("The start time must be before the end time");
        }

        /*
        Add the event.
         */

        Event newEvent = new Event(
                requestModel.start_time,
                requestModel.end_time,
                selectedTask,
                requestModel.name,
                eventTags
        );

        currentUser.addEvent(newEvent);

        ScheduleEventResponseModel response = new ScheduleEventResponseModel(requestModel.name);

        return presenter.prepareSuccessView(response);
    }
}
