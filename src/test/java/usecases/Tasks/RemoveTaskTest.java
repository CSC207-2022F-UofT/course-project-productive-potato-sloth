package useCases.Tasks;

import entities.Tag;
import entities.TaskFactory;
import entities.User;
import gateways.Tags.TagDataAccessInterface;
import gateways.Tags.TagDatabaseGateway;
import gateways.Tasks.TaskDataAccessInterface;
import gateways.Tasks.TaskDatabaseGateway;
import gateways.Tasks.TaskRequestModel;
import gateways.UserDatabaseGateway;
import org.junit.jupiter.api.*;
import presenters.TaskPresenter;
import presenters.TaskResponseFormatter;
import services.CurrentUserService;

import java.awt.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveTaskTest {

    static final User user = new User("user", "password");
    static final User collaborator = new User("collaborator", "password");
    static final User collaborator2 = new User("collaborator2", "password");
    static final Tag tag = new Tag("tag", Color.RED, user);
    static final Tag tag2 = new Tag("tag2", Color.RED, user);
    static final CurrentUserService currentUserService = new CurrentUserService();
    static final TaskPresenter taskPresenter = new TaskResponseFormatter();
    static final TaskFactory taskFactory = new TaskFactory();
    static UserDatabaseGateway userDatabaseGateway;
    static TaskDataAccessInterface taskDatabaseGateway;
    static TagDataAccessInterface tagDatabaseGateway;

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
     * Tests removing a task through the use case
     */
    @Test
    public void TestRemoveTask() {
        CreateTask createTask = new CreateTask(
                taskDatabaseGateway,
                currentUserService,
                taskFactory,
                taskPresenter
        );

        TaskRequestModel taskRequestModel = new TaskRequestModel(
                "task",
                null,
                null,
                null,
                null,
                null
        );

        createTask.create(taskRequestModel);

        assertEquals("task", user.getTasks().get(0).getName());
        assertEquals(1, user.getTasks().size());


        TaskRequestModel taskRequestModel2 = new TaskRequestModel(
                "task2",
                null,
                null,
                null,
                null,
                null
        );

        createTask.create(taskRequestModel2);

        assertEquals(user.getTasks().get(1).getName(), "task2");
        assertEquals(2, user.getTasks().size());

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
