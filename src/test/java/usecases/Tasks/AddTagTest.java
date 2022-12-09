package useCases.Tasks;

import entities.Tag;
import entities.Task;
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
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddTagTest {

    static final User user = new User("user", "password");
    static final User collaborator = new User("collaborator", "password");
    static final User collaborator2 = new User("collaborator2", "password");
    static final Tag tag = new Tag("tag", Color.RED, user);
    static final Tag tag2 = new Tag("tag2", Color.RED, user);
    static final Tag tag3 = new Tag("t", Color.RED, user);
    static final Tag tag4 = new Tag("", Color.RED, user);
    static final CurrentUserService currentUserService = new CurrentUserService();
    static final TaskPresenter taskPresenter = new TaskResponseFormatter();
    static Task task = new Task("task", user);
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

        task = new Task("task", user);

        currentUserService.setCurrentUser(user);
        taskDatabaseGateway = new TaskDatabaseGateway(currentUserService, userDatabaseGateway);
        tagDatabaseGateway = new TagDatabaseGateway(currentUserService, userDatabaseGateway);
        taskDatabaseGateway.insert(task);
        tagDatabaseGateway.insert(tag);
        tagDatabaseGateway.insert(tag2);
        tagDatabaseGateway.insert(tag3);
        tagDatabaseGateway.insert(tag4);
        userDatabaseGateway.insert(user);
        userDatabaseGateway.insert(collaborator);
        userDatabaseGateway.insert(collaborator2);
        userDatabaseGateway.persistData();

    }

    /**
     * Tests adding a tag through the use case
     *
     * @param tagName The various names of the tag
     */
    @ParameterizedTest
    @ValueSource(strings = {"tag", "tag2", "t", ""})
    public void TestAddTag(String tagName) {
        AddTag addTag = new AddTag(
                taskDatabaseGateway,
                tagDatabaseGateway,
                taskPresenter
        );

        TaskRequestModel taskRequestModel = new TaskRequestModel(
                "task",
                null,
                null,
                null,
                tagName,
                null
        );

        addTag.addTag(taskRequestModel);

        ArrayList<String> tagNames = new ArrayList<>();
        task.getTags().forEach((tag) -> tagNames.add(tag.getName()));

        assertTrue(tagNames.contains(tagName));
        assertEquals(1, task.getTags().size());
    }

    /**
     * Removes all entities from the temporary database, creating clean slate for the next text
     */
    @AfterEach
    public void tearDown() {
        taskDatabaseGateway.delete(task);
        tagDatabaseGateway.delete(tag);
        tagDatabaseGateway.delete(tag2);
        tagDatabaseGateway.delete(tag3);
        tagDatabaseGateway.delete(tag4);
        userDatabaseGateway.delete(user);
        userDatabaseGateway.delete(collaborator);
        userDatabaseGateway.delete(collaborator2);
        userDatabaseGateway.persistData();
    }


}
