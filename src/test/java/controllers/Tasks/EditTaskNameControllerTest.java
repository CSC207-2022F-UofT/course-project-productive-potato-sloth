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
import useCases.Tasks.CreateTask;
import useCases.Tasks.CreateTaskInputBoundary;
import useCases.Tasks.EditTask;
import useCases.Tasks.EditTaskInputBoundary;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class EditTaskNameControllerTest {

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
    static EditTaskInputBoundary inputBoundary;
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

        task = new Task("task", user);

        userDatabaseGateway = new UserDatabaseGateway("taskListTest.ser");

        currentUserService.setCurrentUser(user);
        taskDatabaseGateway = new TaskDatabaseGateway(currentUserService, userDatabaseGateway);
        tagDatabaseGateway = new TagDatabaseGateway(currentUserService, userDatabaseGateway);

        inputBoundary = new EditTask(
                taskDatabaseGateway,
                taskPresenter
        );


        taskDatabaseGateway.insert(task);
        tagDatabaseGateway.insert(tag);
        tagDatabaseGateway.insert(tag2);
        userDatabaseGateway.insert(user);
        userDatabaseGateway.insert(collaborator);
        userDatabaseGateway.insert(collaborator2);
        userDatabaseGateway.persistData();
    }

    /**
     * Tests editing a task name through the controller
     */
    @ParameterizedTest
    @ValueSource(strings = {"task", "task2", "t", ""})
    public void TestEditTaskNameController(String newTaskName) {

        EditTaskNameController editTaskNameController = new EditTaskNameController(inputBoundary);

        assertEquals(user.getTasks().size(), 1);
        assertEquals(user.getTasks().get(0).getName(), "task");

        editTaskNameController.editName("task", newTaskName);

        assertEquals(user.getTasks().size(), 1);
        assertEquals(user.getTasks().get(0).getName(), newTaskName);

    }

    /**
     * Removes all entities from the temporary database, creating clean slate for the next text
     */
    @AfterEach
    public void tearDown() {
        taskDatabaseGateway.delete(task);
        tagDatabaseGateway.delete(tag);
        tagDatabaseGateway.delete(tag2);
        userDatabaseGateway.delete(user);
        userDatabaseGateway.delete(collaborator);
        userDatabaseGateway.delete(collaborator2);
        userDatabaseGateway.persistData();
    }

}
