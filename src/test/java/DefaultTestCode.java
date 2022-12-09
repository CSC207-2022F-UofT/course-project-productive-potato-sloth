import entities.Tag;
import entities.Task;
import entities.User;
import gateways.UserDataAccessInterface;
import gateways.UserDatabaseGateway;
import services.CurrentUserService;

import java.awt.*;
import java.io.IOException;

public class DefaultTestCode {
    public static CurrentUserService setupDefaultCurrentUserService() {
        CurrentUserService currentUserService = new CurrentUserService();
        User testUser = new User("testUsername", "testPassword");

        Tag tag1 = new Tag("csc207", Color.RED, testUser);
        Tag tag2 = new Tag("coursework", Color.BLACK, testUser);
        Tag tag3 = new Tag("academics", Color.BLUE, testUser);
        Tag tag4 = new Tag("lifestyle", Color.BLUE, testUser);
        testUser.addTag(tag1);
        testUser.addTag(tag2);
        testUser.addTag(tag3);
        testUser.addTag(tag4);

        Task task1 = new Task("Acquire Relationship", testUser);
        Task task2 = new Task("CSC207 Project", testUser);
        Task task3 = new Task("Self-Actualize", testUser);
        Task task4 = new Task("Impress Derek", testUser);
        testUser.addTask(task1);
        testUser.addTask(task2);
        testUser.addTask(task3);
        testUser.addTask(task4);

        currentUserService.setCurrentUser(testUser);

        return currentUserService;
    }

    public static void resetDatabaseWithDefaultUser(String filename) throws IOException {
        CurrentUserService service = setupDefaultCurrentUserService();
        UserDataAccessInterface gateway = new UserDatabaseGateway(filename);
        gateway.deleteAllUsers();
        gateway.persistData();
        gateway.insert(service.getCurrentUser());
        gateway.persistData();
    }

    public static void deleteAllEventsForDefaultUser() throws IOException {
        CurrentUserService service = new CurrentUserService();
        UserDatabaseGateway gateway = new UserDatabaseGateway("database/UserFile1.ser");

        User user = gateway.getAll().get(0);

        service.setCurrentUser(user);

        user.deleteAllEvents();
    }

    public static void main(String[] args) throws IOException {
        resetDatabaseWithDefaultUser("database/ScheduleEventDemoUserFile.ser");
    }

}
