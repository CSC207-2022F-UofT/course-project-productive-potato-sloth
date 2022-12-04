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

    public void runScheduleEventUseCase() {

        // doesn't work as the current user service doesn't have anyone logged in

        JFrame application = new JFrame("Schedule Event");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        ScheduleEventPresenter presenter = new ScheduleEventResponseFormatter();
        ScheduleEventInputBoundary interactor = new ScheduleEventInteractor(currentUserService, presenter, gateway);
        ScheduleEventController controller = new ScheduleEventController(interactor);

        ScheduleEventViewModel viewModel = new ScheduleEventViewModel();
        for(Tag tag: currentUserService.getCurrentUser().getTags()){
            viewModel.addTagName(tag.getName());
        }
        for(Task task: currentUserService.getCurrentUser().getTasks()){
            viewModel.addTaskName(task.getName());
        }

        ScheduleEventScreen scheduleEventScreen = new ScheduleEventScreen(controller, viewModel);

        screens.add(scheduleEventScreen, "welcome");
        cardLayout.show(screens, "register");
        application.pack();
        application.setVisible(true);
    }

}
