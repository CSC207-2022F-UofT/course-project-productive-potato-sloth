package screens.ScheduleEvent;

import controllers.Events.ScheduleEventController;
import entities.Tag;
import entities.Task;
import gateways.UserDataAccessInterface;
import services.CurrentUserService;
import useCases.ScheduleEvent.ScheduleEventInputBoundary;
import useCases.ScheduleEvent.ScheduleEventInteractor;
import useCases.ScheduleEvent.ScheduleEventPresenter;
import useCases.ScheduleEvent.ScheduleEventResponseFormatter;


/**
 * A class that contains the code for initializing an application
 * for the ScheduleEvent use case.
 */
public class ScheduleEventMainFrame {

    /**
     * The current user service.
     */
    CurrentUserService currentUserService;

    /**
     * The data access gateway.
     */
    UserDataAccessInterface gateway;


    /**
     * Construct the mainframe given a current user service and gateway
     * @param currentUserService the service.
     * @param gateway the data access interface for storing users.
     */
    public ScheduleEventMainFrame(CurrentUserService currentUserService, UserDataAccessInterface gateway){
        this.currentUserService = currentUserService;
        this.gateway = gateway;
    }

    /**
     * Setup the main screen using the given gateway and service by initializing
     * all relevant components of the CA.
     * @return the ScheduleEventScreen after initializing it.
     */
    public ScheduleEventScreen setupScheduleEventScreen() {

        ScheduleEventPresenter scheduleEventResponseFormatter = new ScheduleEventResponseFormatter();
        ScheduleEventInputBoundary scheduleEventInteractor = new ScheduleEventInteractor(currentUserService, scheduleEventResponseFormatter, gateway);
        ScheduleEventController scheduleEventController = new ScheduleEventController(scheduleEventInteractor);

        ScheduleEventViewModel scheduleEventViewModel = new ScheduleEventViewModel();
        for(Tag tag: currentUserService.getCurrentUser().getTags()){
            scheduleEventViewModel.addTagName(tag.getName());
        }
        for(Task task: currentUserService.getCurrentUser().getTasks()){
            scheduleEventViewModel.addTaskName(task.getName());
        }

        return new ScheduleEventScreen(scheduleEventController, scheduleEventViewModel);
    }

}
