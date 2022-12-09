package useCases.Tags;

import entities.TagFactory;
import entities.Task;
import entities.User;
import gateways.Tags.TagDataAccessInterface;
import gateways.Tags.TagDatabaseGateway;
import gateways.Tags.TagRequestModel;
import gateways.Tasks.TaskDataAccessInterface;
import gateways.Tasks.TaskDatabaseGateway;

import gateways.UserDatabaseGateway;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import presenters.TagPresenter;
import presenters.TagResponseFormatter;
import services.CurrentUserService;


import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateTagTest {

    static final User user = new User("user", "password");
    static final Task task = new Task("task", user);
    static final User collaborator = new User("collaborator", "password");
    static final User collaborator2 = new User("collaborator2", "password");
    static final CurrentUserService currentUserService = new CurrentUserService();
    static final TagPresenter tagPresenter = new TagResponseFormatter();
    static final TagFactory tagFactory = new TagFactory();
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
        taskDatabaseGateway.insert(task);
        userDatabaseGateway.insert(user);
        userDatabaseGateway.insert(collaborator);
        userDatabaseGateway.insert(collaborator2);
        userDatabaseGateway.persistData();
    }

    /**
     * Tests creating a tag through the use case
     */
    @Test
    public void TestCreateTag() {
        CreateTag createTag = new CreateTag(
                tagDatabaseGateway,
                tagFactory,
                tagPresenter,
                currentUserService
        );

        TagRequestModel tagRequestModel = new TagRequestModel(
                "tag",
                null,
                null
        );

        createTag.create(tagRequestModel);

        ArrayList<String> tagNames = new ArrayList<>();
        user.getTags().forEach((tag) -> tagNames.add(tag.getName()));
        assertTrue(tagNames.contains("tag"));

        assertEquals(1, user.getTags().size());


        TagRequestModel tagRequestModel2 = new TagRequestModel(
                "tag2",
                null,
                null
        );

        createTag.create(tagRequestModel2);

        ArrayList<String> tagNames2 = new ArrayList<>();
        user.getTags().forEach((tag) -> tagNames2.add(tag.getName()));
        assertTrue(tagNames2.contains("tag2"));
        assertEquals(2, user.getTags().size());

    }

    /**
     * Removes all entities from the temporary database, creating clean slate for the next text
     */
    @AfterEach
    public void tearDown() {
        taskDatabaseGateway.delete(task);
        userDatabaseGateway.delete(user);
        userDatabaseGateway.delete(collaborator);
        userDatabaseGateway.delete(collaborator2);
        userDatabaseGateway.persistData();
    }


}
