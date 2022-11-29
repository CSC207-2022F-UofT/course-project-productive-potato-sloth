import entities.Tag;
import entities.Task;
import entities.User;
import screens.ScheduleEvent.ScheduleEventController;
import screens.ScheduleEvent.ScheduleEventScreen;
import screens.ScheduleEvent.ScheduleEventViewModel;
import services.CurrentUserService;
import useCases.ScheduleEvent.ScheduleEventInputBoundary;
import useCases.ScheduleEvent.ScheduleEventInteractor;
import useCases.ScheduleEvent.ScheduleEventPresenter;
import useCases.ScheduleEvent.ScheduleEventResponseFormatter;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {

    private static CurrentUserService currentUserService;

    public static void setupDefaultCurrentUserService() {
        currentUserService = new CurrentUserService();
        User testUser = new User("testUsername", "testPassword");

        Tag tag1 = new Tag("tag1", Color.RED);
        Tag tag2 = new Tag("tag2", Color.BLACK);
        Tag tag3 = new Tag("tag3", Color.BLUE);
        testUser.addTag(tag1);
        testUser.addTag(tag2);
        testUser.addTag(tag3);

        Task task1 = new Task("task1", testUser);
        Task task2 = new Task("task2", testUser);
        testUser.addTask(task1);
        testUser.addTask(task2);

        currentUserService.setCurrentUser(testUser);
    }

    public static void setupScheduleEvent() {

        // doesn't work as the current user service doesn't have anyone logged in

        JFrame application = new JFrame("Schedule Event");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        setupDefaultCurrentUserService();

        ScheduleEventPresenter presenter = new ScheduleEventResponseFormatter();
        ScheduleEventInputBoundary interactor = new ScheduleEventInteractor(currentUserService, presenter);
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

    public static void main(String[] args) throws IOException {
        setupScheduleEvent();
    }
}
