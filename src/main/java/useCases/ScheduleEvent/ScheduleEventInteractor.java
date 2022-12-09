package useCases.ScheduleEvent;

import entities.Event;
import entities.Tag;
import entities.Task;
import entities.User;
import gateways.DataAccessInterface;
import gateways.UserDataAccessInterface;
import screens.ScheduleEvent.ScheduleEventResponseModel;
import services.CurrentUserService;

import java.util.ArrayList;
import java.util.List;

/**
 * An interactor that executes the ScheduleEvent use case.
 */
public class ScheduleEventInteractor implements ScheduleEventInputBoundary{

    /**
     * The current user service.
     */
    CurrentUserService currentUserService;

    /**
     * The presenter associated with this interactor.
     */
    ScheduleEventPresenter presenter;

    /**
     * The user data access interface.
     */
    UserDataAccessInterface gateway;

    /**
     * Constructs an interactor that schedules events.
     * @param currentUserService the current user service to get the current user from.
     * @param scheduleEventPresenter the presenter that formats the response model.
     * @param gateway data access interface.
     */
    public ScheduleEventInteractor(CurrentUserService currentUserService,
                                   ScheduleEventPresenter scheduleEventPresenter,
                                   UserDataAccessInterface gateway){
        this.currentUserService = currentUserService;
        this.presenter = scheduleEventPresenter;
        this.gateway = gateway;
    }

    /**
     * The only responsibility of this class. Schedules a new event
     * with the parameters in request model and call upon the presenter
     * to format a response.
     * @param requestModel the request model containing the parameters for scheduling the new event.
     * @return
     */
    public ScheduleEventResponseModel scheduleEvent(ScheduleEventRequestModel requestModel){

        User currentUser = currentUserService.getCurrentUser();

        /*
        Check that the event name is not empty or whitespace.
         */

        if(requestModel.getEventName().isBlank()){
            return presenter.prepareFailView("Your event name must not be empty.");
        }

        /*
        Check that the task exists, if given. Select it.
        Once the User.getTask(taskName) method is implemented, this code will be
        significantly simplified.
         */

        Task selectedTask = null;

        if(requestModel.getSelectedTaskName() != null){
            for(Task task: currentUser.getTasks()){
                if(task.getName().equals(requestModel.getSelectedTaskName())){
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
        for(String tagName: requestModel.getSelectedTagNames()){
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

        if(requestModel.getStartTime() == null){
            return presenter.prepareFailView("No start time provided.");
        }

        if(requestModel.getEndTime() == null){
            return presenter.prepareFailView("No end time provided.");
        }

        if(requestModel.getStartTime().isAfter(requestModel.getEndTime())){
            return presenter.prepareFailView("The event must end after it begins.");
        }

        /*
        Add the event.
         */

        Event newEvent = new Event(
                requestModel.getStartTime(),
                requestModel.getEndTime(),
                selectedTask,
                requestModel.getEventName(),
                eventTags
        );

        currentUser.addEvent(newEvent);

        ScheduleEventResponseModel response = new ScheduleEventResponseModel(requestModel.getEventName());

        if(gateway.persistData()){
            return presenter.prepareSuccessView(response);
        }else{
            return presenter.prepareFailView("Unable to save your new event.");
        }
    }
}