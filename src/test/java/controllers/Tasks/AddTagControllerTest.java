package controllers.Tasks;

import entities.Tag;
import entities.Task;
import entities.User;
import gateways.Tags.TagDataAccessInterface;
import gateways.Tags.TagDatabaseGateway;
import gateways.Tasks.TaskDataAccessInterface;
import gateways.Tasks.TaskDatabaseGateway;
import gateways.UserDatabaseGateway;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import presenters.TaskPresenter;
import presenters.TaskResponseFormatter;
import services.CurrentUserService;
import useCases.Tasks.AddTag;
import useCases.Tasks.AddTagInputBoundary;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddTagControllerTest {

    static final User user = new User("user", "password");
    static final Tag tag = new Tag("tag", Color.RED, user);
    static final Tag tag2 = new Tag("tag2", Color.RED, user);
    static final Tag tag3 = new Tag("t", Color.RED, user);
    static final Tag tag4 = new Tag("", Color.RED, user);
    static final User collaborator = new User("collaborator", "password");
    static final User collaborator2 = new User("collaborator2", "password");
    static final CurrentUserService currentUserService = new CurrentUserService();
    static final TaskPresenter taskPresenter = new TaskResponseFormatter();
    static File testFile;
    static Task task = new Task("task", user);
    static UserDatabaseGateway userDatabaseGateway;
    static TaskDataAccessInterface taskDatabaseGateway;
    static TagDataAccessInterface tagDatabaseGateway;
    static AddTagInputBoundary inputBoundary;

    /**
     * To test the controller:
     * 1) Create the database gateways, and presenters, use case interfaces
     * 2) Create the current user service, with a dummy user as the current user
     * 3) Create dummy tasks, tests, and collaborators
     * 4) Add all the dummy entities in the temp database
     */
    @BeforeEach
    public void setup() throws IOException {

        userDatabaseGateway = new UserDatabaseGateway("taskListTest.ser");

        currentUserService.setCurrentUser(user);
        taskDatabaseGateway = new TaskDatabaseGateway(currentUserService, userDatabaseGateway);
        tagDatabaseGateway = new TagDatabaseGateway(currentUserService, userDatabaseGateway);

        inputBoundary = new AddTag(
                taskDatabaseGateway,
                tagDatabaseGateway,
                taskPresenter
        );

        task = new Task("task", user);

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
     * Tests adding a tag through the controller
     */
    @ParameterizedTest
    @ValueSource(strings = {"tag", "tag2", "t", ""})
    public void TestAddTagController(String tagName) {

        AddTagController addTagController = new AddTagController(inputBoundary);

        addTagController.addTag("task", tagName);

        ArrayList<String> taskTags = new ArrayList<>();
        task.getTags().forEach((tag) -> taskTags.add(tag.getName()));

        assertTrue(taskTags.contains(tagName));
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
