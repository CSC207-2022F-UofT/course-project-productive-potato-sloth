package useCases.Tasks;

import entities.Task;
import entities.User;
import gateways.Tasks.TaskDataAccessInterface;
import gateways.Tasks.TaskDatabaseGateway;
import gateways.Tasks.TaskRequestModel;
import gateways.UserDatabaseGateway;
import org.junit.jupiter.api.*;
import presenters.TaskPresenter;
import presenters.TaskResponseFormatter;
import services.CurrentUserService;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RemoveCollaboratorTest {

    static final User user = new User("user", "password");
    static final Task task = new Task("task", user);
    static final User collaborator = new User("collaborator", "password");
    static final User collaborator2 = new User("collaborator2", "password");
    static final CurrentUserService currentUserService = new CurrentUserService();
    static final TaskPresenter taskPresenter = new TaskResponseFormatter();
    static UserDatabaseGateway userDatabaseGateway;
    static TaskDataAccessInterface taskDatabaseGateway;

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

        task.addCollaborator(collaborator2);
        task.addCollaborator(collaborator);
        currentUserService.setCurrentUser(user);
        taskDatabaseGateway = new TaskDatabaseGateway(currentUserService, userDatabaseGateway);
        taskDatabaseGateway.insert(task);
        userDatabaseGateway.insert(user);
        userDatabaseGateway.insert(collaborator);
        userDatabaseGateway.insert(collaborator2);
        userDatabaseGateway.persistData();

    }

    /**
     * Tests removing a collaborator through the use case
     */
    @Test
    public void TestRemoveCollaborator() {
        RemoveCollaborator removeCollaborator = new RemoveCollaborator(
                taskDatabaseGateway,
                taskPresenter
        );

        TaskRequestModel taskRequestModel = new TaskRequestModel(
                "task",
                null,
                null,
                null,
                null,
                collaborator.getUsername()
        );

        removeCollaborator.removeCollaborator(taskRequestModel);

        assertTrue(task.getCollaborator().contains(collaborator2));
        assertEquals(1, task.getCollaborator().size());

        TaskRequestModel taskRequestModel2 = new TaskRequestModel(
                "task",
                null,
                null,
                null,
                null,
                collaborator2.getUsername()
        );

        removeCollaborator.removeCollaborator(taskRequestModel2);

        assertEquals(0, task.getCollaborator().size());

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
