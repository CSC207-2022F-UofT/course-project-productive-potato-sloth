package screens.ScheduleEvent;

import entities.Tag;
import entities.Task;
import entities.User;
import gateways.DataAccessInterface;
import gateways.UserDataAccessInterface;
import gateways.UserDatabaseGateway;
import services.CurrentUserService;
import useCases.ScheduleEvent.ScheduleEventInputBoundary;
import useCases.ScheduleEvent.ScheduleEventInteractor;
import useCases.ScheduleEvent.ScheduleEventPresenter;
import useCases.ScheduleEvent.ScheduleEventResponseFormatter;

import javax.swing.*;
import java.awt.*;

public class ScheduleEventMainFrame {

    CurrentUserService currentUserService;
    UserDataAccessInterface gateway;

    public ScheduleEventMainFrame(CurrentUserService currentUserService, UserDataAccessInterface gateway){
        this.currentUserService = currentUserService;
        this.gateway = gateway;
    }

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
