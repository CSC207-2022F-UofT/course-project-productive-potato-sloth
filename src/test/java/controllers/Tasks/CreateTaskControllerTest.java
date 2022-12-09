package controllers.Tasks;

import entities.Tag;
import entities.Task;
import entities.TaskFactory;
import entities.User;
import gateways.Tags.TagDataAccessInterface;
import gateways.Tags.TagDatabaseGateway;
import gateways.Tasks.TaskDataAccessInterface;
import gateways.Tasks.TaskDatabaseGateway;
import gateways.UserDatabaseGateway;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import presenters.TaskPresenter;
import presenters.TaskResponseFormatter;
import services.CurrentUserService;
import useCases.Tasks.AddTag;
import useCases.Tasks.AddTagInputBoundary;
import useCases.Tasks.CreateTask;
import useCases.Tasks.CreateTaskInputBoundary;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateTaskControllerTest {

    static File testFile;

    static User user = new User("user", "password");
    static Task task = new Task("task", user);
    static Tag tag = new Tag("tag", Color.RED, user);
    static Tag tag2 = new Tag("tag2", Color.RED, user);

    static User collaborator = new User("collaborator", "password");
    static User collaborator2 = new User("collaborator2", "password");
    static UserDatabaseGateway userDatabaseGateway;
    static TaskDataAccessInterface taskDatabaseGateway;
    static TagDataAccessInterface tagDatabaseGateway;
    static CreateTaskInputBoundary inputBoundary;
    static CurrentUserService currentUserService = new CurrentUserService();
    static TaskFactory taskFactory = new TaskFactory();
    static TaskPresenter taskPresenter = new TaskResponseFormatter();

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

        user = new User("user", "password");
        currentUserService.setCurrentUser(user);
        taskDatabaseGateway = new TaskDatabaseGateway(currentUserService, userDatabaseGateway);
        tagDatabaseGateway = new TagDatabaseGateway(currentUserService, userDatabaseGateway);

        inputBoundary = new CreateTask(
                taskDatabaseGateway,
                userDatabaseGateway,
                currentUserService,
                taskFactory,
                taskPresenter
        );


        tagDatabaseGateway.insert(tag);
        tagDatabaseGateway.insert(tag2);
        userDatabaseGateway.insert(user);
        userDatabaseGateway.insert(collaborator);
        userDatabaseGateway.insert(collaborator2);
        userDatabaseGateway.persistData();
    }

    /**
     * Tests creating a task through the controller
     */
    @ParameterizedTest
    @ValueSource(strings = {"task", "task2", "t", ""})
    public void TestCreateTaskController(String taskName) {

        CreateTaskController createTaskController = new CreateTaskController(inputBoundary);

        createTaskController.createTask(taskName);

        ArrayList<String> taskNames = new ArrayList<>();
        user.getTasks().forEach((task) -> taskNames.add(task.getName()));

        assertTrue(taskNames.contains(taskName));
        assertEquals(1, user.getTasks().size());
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
