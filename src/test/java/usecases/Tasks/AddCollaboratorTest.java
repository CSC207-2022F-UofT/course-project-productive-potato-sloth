package useCases.Tasks;

import entities.Task;
import entities.User;
import gateways.Tasks.TaskDataAccessInterface;
import gateways.Tasks.TaskDatabaseGateway;
import gateways.Tasks.TaskRequestModel;
import gateways.UserDatabaseGateway;
import org.junit.BeforeClass;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import presenters.TaskInfoPresenter;
import presenters.TaskPresenter;
import presenters.TaskResponseFormatter;
import services.CurrentUserService;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddCollaboratorTest {

    static File testFile;
    static User user = new User("user", "password");
    static Task task = new Task("task", user);
    static User collaborator = new User("collaborator", "password");
    static User collaborator2 = new User("collaborator2", "password");
    static User collaborator3 = new User("c", "password");
    static User collaborator4 = new User("", "password");

    static UserDatabaseGateway userDatabaseGateway;
    static TaskDataAccessInterface taskDatabaseGateway;
    static CurrentUserService currentUserService = new CurrentUserService();
    static TaskPresenter taskPresenter = new TaskResponseFormatter();


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
        taskDatabaseGateway.insert(task);
        userDatabaseGateway.insert(user);
        userDatabaseGateway.insert(collaborator);
        userDatabaseGateway.insert(collaborator2);
        userDatabaseGateway.insert(collaborator3);
        userDatabaseGateway.insert(collaborator4);
        userDatabaseGateway.persistData();
    }


    /**
     * Tests adding a collaborator through a task through the use case
     *
     * @param collaboratorName The various names of the collaborator
     */
    @ParameterizedTest
    @ValueSource(strings = {"collaborator", "collaborator2", "c", ""})
    public void TestAddCollaborators(String collaboratorName) {
        AddCollaborator addCollaborator = new AddCollaborator(
                taskDatabaseGateway,
                userDatabaseGateway,
                taskPresenter
        );

        TaskRequestModel taskRequestModel = new TaskRequestModel(
                "task",
                null,
                null,
                null,
                null,
                collaboratorName
        );

        addCollaborator.addCollaborator(taskRequestModel);

        ArrayList<String> taskCollaborators = new ArrayList<>();
        task.getCollaborator().forEach((collaborator) -> taskCollaborators.add(collaborator.getUsername()));

        assertTrue(taskCollaborators.contains(collaboratorName));
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
