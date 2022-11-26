package usecases;

import entities.User;
import gateways.DataAccessInterface;
import gateways.UserDatabaseGateway;
import org.junit.jupiter.api.Test;
import screens.ScheduleEvent.ScheduleEventController;
import screens.ScheduleEvent.ScheduleEventScreen;
import services.CurrentUserService;
import useCases.ScheduleEvent.ScheduleEventInputBoundary;
import useCases.ScheduleEvent.ScheduleEventInteractor;
import useCases.ScheduleEvent.ScheduleEventPresenter;
import useCases.ScheduleEvent.ScheduleEventResponseFormatter;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ScheduleEventTest {
    @Test
    public void testScheduleEventOne(){

    }

    @Test
    public void testGeneral() throws IOException {
        JFrame application = new JFrame("Schedule Event");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);
        CurrentUserService currentUserService = new CurrentUserService();
        DataAccessInterface<User> gateway = new UserDatabaseGateway("database/emptyUserFile.ser");
        ScheduleEventPresenter presenter = new ScheduleEventResponseFormatter();
        ScheduleEventInputBoundary interactor = new ScheduleEventInteractor(currentUserService, gateway, presenter);
        ScheduleEventController controller = new ScheduleEventController(interactor);
        ScheduleEventScreen scheduleEventScreen = new ScheduleEventScreen(controller);
        screens.add(scheduleEventScreen, "welcome");
        cardLayout.show(screens, "register");
        application.pack();
        application.setVisible(true);
    }
}
