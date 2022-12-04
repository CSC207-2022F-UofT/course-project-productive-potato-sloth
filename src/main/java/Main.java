import entities.Tag;
import entities.Task;
import entities.User;
import gateways.DataAccessInterface;
import gateways.UserDataAccessInterface;
import gateways.UserDatabaseGateway;
import screens.ScheduleEvent.ScheduleEventMainFrame;
import services.CurrentUserService;

import java.awt.*;
import java.io.IOException;

public class Main {

    public static CurrentUserService setupDefaultCurrentUserService() {
        CurrentUserService currentUserService = new CurrentUserService();
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

        return currentUserService;
    }

    public static void main(String[] args) throws IOException {
        CurrentUserService currentUserService1 = setupDefaultCurrentUserService();
        UserDataAccessInterface gateway = new UserDatabaseGateway("database/UserFile1.ser");
        gateway.insert(currentUserService1.getCurrentUser());
        ScheduleEventMainFrame scheduleEventMainFrame = new ScheduleEventMainFrame(currentUserService1, gateway);
        scheduleEventMainFrame.runScheduleEventUseCase();
    }
}
