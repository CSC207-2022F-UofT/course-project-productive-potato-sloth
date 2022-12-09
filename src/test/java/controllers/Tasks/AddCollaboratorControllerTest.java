package controllers.Tasks;

import entities.Task;
import entities.User;
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
import useCases.Tasks.AddCollaborator;
import useCases.Tasks.AddCollaboratorInputBoundary;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddCollaboratorControllerTest {


    static final User user = new User("user", "password");
    static final User collaborator = new User("collaborator", "password");
    static final User collaborator2 = new User("collaborator2", "password");
    static final User collaborator3 = new User("c", "password");
    static final User collaborator4 = new User("", "password");
    static final CurrentUserService currentUserService = new CurrentUserService();
    static final TaskPresenter taskPresenter = new TaskResponseFormatter();
    static File testFile;
    static Task task = new Task("task", user);
    static UserDatabaseGateway userDatabaseGateway;
    static TaskDataAccessInterface taskDatabaseGateway;
    static AddCollaboratorInputBoundary inputBoundary;

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

        inputBoundary = new AddCollaborator(
                taskDatabaseGateway,
                userDatabaseGateway,
                taskPresenter
        );

        task = new Task("task", user);

        taskDatabaseGateway.insert(task);
        userDatabaseGateway.insert(user);
        userDatabaseGateway.insert(collaborator);
        userDatabaseGateway.insert(collaborator2);
        userDatabaseGateway.insert(collaborator3);
        userDatabaseGateway.insert(collaborator4);
        userDatabaseGateway.persistData();


    }

    /**
     * Tests adding a collaborator through the controller
     */
    @ParameterizedTest
    @ValueSource(strings = {"collaborator", "collaborator2", "c", ""})
    public void TestAddCollaboratorController(String collaboratorUsername) {

        AddCollaboratorController addCollaboratorController = new AddCollaboratorController(inputBoundary);

        addCollaboratorController.addCollaborator("task", collaboratorUsername);

        ArrayList<String> taskCollaborators = new ArrayList<>();
        task.getCollaborator().forEach((collaborator) -> taskCollaborators.add(collaborator.getUsername()));

        assertTrue(taskCollaborators.contains(collaboratorUsername));
        assertEquals(1, task.getCollaborator().size());

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
        userDatabaseGateway.delete(collaborator3);
        userDatabaseGateway.delete(collaborator4);
        userDatabaseGateway.persistData();
    }

}
