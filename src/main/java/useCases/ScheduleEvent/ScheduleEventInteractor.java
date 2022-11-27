package useCases.ScheduleEvent;

import entities.Event;
import entities.Tag;
import entities.Task;
import entities.User;
import screens.ScheduleEvent.ScheduleEventResponseModel;
import services.CurrentUserService;

import java.util.ArrayList;
import java.util.List;

// TODO: document this class
public class ScheduleEventInteractor implements ScheduleEventInputBoundary{

    CurrentUserService currentUserService;

    ScheduleEventPresenter presenter;

    public ScheduleEventInteractor(CurrentUserService currentUserService, ScheduleEventPresenter scheduleEventPresenter){
        this.currentUserService = currentUserService;
        this.presenter = scheduleEventPresenter;
    }

    public ScheduleEventResponseModel scheduleEvent(ScheduleEventRequestModel requestModel){

        User currentUser = currentUserService.getCurrentUser();

        /*
        Check that the event name is not empty or whitespace.
         */

        if(requestModel.eventName.isBlank()){
            return presenter.prepareFailView("Your event name must not be empty.");
        }

        /*
        Check that the task exists, if given. Select it.
        Once the User.getTask(taskName) method is implemented, this code will be
        significantly simplified.
         */

        Task selectedTask = null;

        if(requestModel.selectedTaskName != null){
            for(Task task: currentUser.getTasks()){
                if(task.getName().equals(requestModel.selectedTaskName)){
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
        for(String tagName: requestModel.selectedTagNames){
            for(Tag tag: currentUser.getTags()){
                if(tag.getName().equals(tagName)){
                    eventTags.add(tag);
                }
            }
        }

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
            return presenter.prepareFailView("The event must end after it begins.");
        }

        /*
        Add the event.
         */

        Event newEvent = new Event(
                requestModel.start_time,
                requestModel.end_time,
                selectedTask,
                requestModel.eventName,
                eventTags
        );

        currentUser.addEvent(newEvent);

        ScheduleEventResponseModel response = new ScheduleEventResponseModel(requestModel.eventName);

        return presenter.prepareSuccessView(response);
    }
}
