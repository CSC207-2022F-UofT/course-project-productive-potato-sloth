package screens.ViewCalendar;

import controllers.Events.ViewCalendarController;
import entities.User;
import gateways.UserDataAccessInterface;
import gateways.UserDatabaseGateway;
import screens.ScheduleEvent.ScheduleEventMainFrame;
import screens.ScheduleEvent.ScheduleEventScreen;
import services.CurrentUserService;
import useCases.ViewCalendar.ViewCalendarInputBoundary;
import useCases.ViewCalendar.ViewCalendarInteractor;
import useCases.ViewCalendar.ViewCalendarPresenter;
import useCases.ViewCalendar.ViewCalendarResponseFormatter;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * A class that contains the code for initializing an application
 * for the ViewCalendar use case.
 */
public class ViewCalendarMainFrame {

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
    public ViewCalendarMainFrame(CurrentUserService currentUserService, UserDataAccessInterface gateway){
        this.currentUserService = currentUserService;
        this.gateway = gateway;
    }

    /**
     * Setup the main screen using the given gateway and service by initializing
     * all relevant components of the CA.
     * @return the ViewCalendarScreen after initializing it.
     */
    public ViewCalendarScreen setupViewCalendarScreen(){
        ViewCalendarViewModel viewModel = new ViewCalendarViewModel();
        ViewCalendarPresenter presenter = new ViewCalendarResponseFormatter(viewModel);

        ViewCalendarInputBoundary interactor = new ViewCalendarInteractor(this.currentUserService, presenter);

        ViewCalendarController controller = new ViewCalendarController(interactor);

        ViewCalendarScreen viewCalendarScreen = new ViewCalendarScreen(controller, viewModel);
        viewModel.addObserver(viewCalendarScreen);
        viewCalendarScreen.update();
        return viewCalendarScreen;
    }

    public void runViewCalendarUseCase(){

        JFrame application = new JFrame("Calendar");
        BorderLayout cardLayout = new BorderLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        JSplitPane pane = new JSplitPane();

        ScheduleEventMainFrame scheduleEventMainFrame = new ScheduleEventMainFrame(currentUserService, gateway);

        ScheduleEventScreen scheduleEventScreen = scheduleEventMainFrame.setupScheduleEventScreen();

        ViewCalendarScreen viewCalendarScreen = setupViewCalendarScreen();
        scheduleEventScreen.addUseCaseObserver(viewCalendarScreen);
        screens.add(viewCalendarScreen);
        screens.add(scheduleEventScreen);

        pane.setTopComponent(viewCalendarScreen);
        pane.setBottomComponent(scheduleEventScreen);

        application.add(pane);

        application.pack();
        application.setVisible(true);
    }


    public static void main(String[] args) throws IOException {
        CurrentUserService service = new CurrentUserService();
        UserDatabaseGateway gateway = new UserDatabaseGateway("database/ScheduleEventDemoUserFile.ser");

        User user = gateway.getAll().get(0);

        service.setCurrentUser(user);

        ViewCalendarMainFrame mainFrame = new ViewCalendarMainFrame(service, gateway);
        mainFrame.runViewCalendarUseCase();
    }

}
