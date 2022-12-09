package useCases.Tasks;

import entities.Tag;
import entities.Task;
import entities.TaskFactory;
import entities.User;
import gateways.Tags.TagDataAccessInterface;
import gateways.Tags.TagDatabaseGateway;
import gateways.Tasks.TaskDataAccessInterface;
import gateways.Tasks.TaskDatabaseGateway;
import gateways.Tasks.TaskRequestModel;
import gateways.UserDatabaseGateway;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import presenters.TaskPresenter;
import presenters.TaskResponseFormatter;
import services.CurrentUserService;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateTaskTest {

    static User user = new User("user", "password");
    static User collaborator = new User("collaborator", "password");
    static User collaborator2 = new User("collaborator2", "password");
    static Tag tag = new Tag("tag", Color.RED, user);
    static Tag tag2 = new Tag("tag2", Color.RED, user);
    static UserDatabaseGateway userDatabaseGateway;
    static TaskDataAccessInterface taskDatabaseGateway;
    static TagDataAccessInterface tagDatabaseGateway;
    static CurrentUserService currentUserService = new CurrentUserService();
    static TaskPresenter taskPresenter = new TaskResponseFormatter();
    static TaskFactory taskFactory = new TaskFactory();


    /**
     * To test the use case:
     * 1) Create the database gateways, and presenters
     * 2) Create the current user service, with a dummy user as the current user
     * 3) Create dummy tasks, tests, and collaborators
     * 4) Add all the dummy entities in the temp database
     */
    @BeforeEach
    public void setup() throws IOException {
        try {
            userDatabaseGateway = new UserDatabaseGateway("taskListTest.ser");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        user = new User("user", "password");

        currentUserService.setCurrentUser(user);
        taskDatabaseGateway = new TaskDatabaseGateway(currentUserService, userDatabaseGateway);
        tagDatabaseGateway = new TagDatabaseGateway(currentUserService, userDatabaseGateway);
        tagDatabaseGateway.insert(tag);
        tagDatabaseGateway.insert(tag2);
        userDatabaseGateway.insert(user);
        userDatabaseGateway.insert(collaborator);
        userDatabaseGateway.insert(collaborator2);
        userDatabaseGateway.persistData();

    }


    /**
     * Tests creating a task through the use case
     *
     * @param taskName The various names of the tag
     */
    @ParameterizedTest
    @ValueSource(strings = {"task", "task2", "t", ""})
    public void TestCreateTask(String taskName) {
        CreateTask createTask = new CreateTask(
                taskDatabaseGateway,
                userDatabaseGateway,
                currentUserService,
                taskFactory,
                taskPresenter
        );

        TaskRequestModel taskRequestModel = new TaskRequestModel(
                taskName,
                null,
                null,
                null,
                null,
                null
        );

        createTask.create(taskRequestModel);

        assertEquals(1, user.getTasks().size());
        assertEquals(taskName, user.getTasks().get(0).getName());

    }

    /**
     * Removes all entities from the temporary database, creating clean slate for the next text
     */
    @AfterEach
    public void tearDown() {
        tagDatabaseGateway.delete(tag);
        tagDatabaseGateway.delete(tag2);
        userDatabaseGateway.delete(user);
        userDatabaseGateway.delete(collaborator);
        userDatabaseGateway.delete(collaborator2);
        userDatabaseGateway.persistData();
    }

}
