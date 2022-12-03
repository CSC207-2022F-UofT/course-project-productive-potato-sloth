package screens.ViewCalendar;

import entities.Tag;
import entities.Task;
import entities.User;
import gateways.UserDataAccessInterface;
import gateways.UserDatabaseGateway;
import screens.ScheduleEvent.ScheduleEventScreen;
import services.CurrentUserService;
import useCases.ViewCalendar.ViewCalendarInputBoundary;
import useCases.ViewCalendar.ViewCalendarInteractor;
import useCases.ViewCalendar.ViewCalendarPresenter;
import useCases.ViewCalendar.ViewCalendarResponseFormatter;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.io.IOException;

public class ViewCalendarMainFrame {

    CurrentUserService currentUserService;
    UserDataAccessInterface gateway;

    public ViewCalendarMainFrame(CurrentUserService currentUserService, UserDataAccessInterface gateway){
        this.currentUserService = currentUserService;
        this.gateway = gateway;
    }

    public void runViewCalendarUseCase(){

        JFrame application = new JFrame("Calendar");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        ViewCalendarViewModel viewModel = new ViewCalendarViewModel();
        ViewCalendarPresenter presenter = new ViewCalendarResponseFormatter(viewModel);

        ViewCalendarInputBoundary interactor = new ViewCalendarInteractor(this.currentUserService, presenter);

        ViewCalendarController controller = new ViewCalendarController(interactor);

        ViewCalendarScreen viewCalendarScreen = new ViewCalendarScreen(controller, viewModel);
        viewModel.addObserver(viewCalendarScreen);
        viewCalendarScreen.update();

        screens.add(viewCalendarScreen);

        cardLayout.show(screens, "name");
        application.pack();
        application.setVisible(true);
    }


    public static void main(String[] args) throws IOException {

        CurrentUserService service = new CurrentUserService();
        UserDatabaseGateway gateway = new UserDatabaseGateway("database/UserFile1.ser");

        User user = gateway.getAll().get(0);

        service.setCurrentUser(user);

        ViewCalendarMainFrame mainFrame = new ViewCalendarMainFrame(service, gateway);
        mainFrame.runViewCalendarUseCase();
    }

}
