package gateways.Tasks;

import entities.Task;
import entities.User;
import gateways.DatabaseGateway;
import gateways.UserDatabaseGateway;
import services.CurrentUserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A Gateway class which connects to the database and contains operations for Tasks
 */
public class TaskDatabaseGateway extends DatabaseGateway implements TaskDataAccessInterface {

    /**
     * Service for accessing the current logged-in user
     */
    private final CurrentUserService currentUserService;

    /**
     * The interface which allows access to the UserDatabase
     */
    private final UserDatabaseGateway userDatabaseGateway;

    /**
     * The current user
     */
    private User currentUser;

    /**
     * The list of tasks for the user
     */
    private List<Task> taskList;

    /**
     * Instantiating DatabaseGateway with a relative path will store the absolute path to the respective database.
     * If the file at the path does not exist, one will be created
     * This absolute path can be fetched using the getAbsoluteFilepath method
     *
     * @throws IOException Throws exception if encountering failed or interrupted IO exceptions
     */
    public TaskDatabaseGateway(CurrentUserService currentUserService, UserDatabaseGateway userDatabaseGateway) throws IOException {
        super(userDatabaseGateway.getAbsoluteFilepath());
        this.currentUserService = currentUserService;
        this.userDatabaseGateway = userDatabaseGateway;
        load();
    }

    /**
     * Loads all users, the current user, and the tasks of the current user
     */
    public void load() {
        List<User> userList = userDatabaseGateway.loadFromFile();
        this.currentUser = currentUserService.getCurrentUser();
        this.taskList = currentUser.getTasks();
    }

    /**
     * Retrieves the Task from the database given a name
     * This method will always retrieve from the currently logged-in user
     *
     * @param name The name of the Task
     * @return The Task object matching the name
     */
    public Task get(String name) {
        load();
        for (Task task : taskList) {
            if (task.getName().equals(name)) {
                return task;
            }
        }
        return null;
    }

    /**
     * Retrieves all Tasks from the database
     * This method will only retrieve Tasks from the currently logged-in user
     *
     * @return A list of the current user's tasks
     */
    @Override
    public List<Task> getAll() {
        load();
        return taskList;
    }

    /**
     * Adds a Task to the current user's Tasks
     * This method will automatically persist the changes
     * No additional calls to this class are required to save changes
     *
     * @param task The task to add to the current user
     */
    @Override
    public void insert(Task task) {
        load();
        currentUser.addTask(task);
        userDatabaseGateway.saveToFile();
    }

    /**
     * Updates an existing Task in the current user's Tasks
     * This method will automatically persist the changes
     * No additional calls to this class are required to save changes
     *
     * @param task The task to be updated
     * @return A boolean representing if the update succeeded
     */
    @Override
    public boolean update(Task task) {
        userDatabaseGateway.saveToFile();
        return true;
    }

    /**
     * Deletes an existing task in the current logged-in user's Tasks
     * This method will automatically persist the changes
     * No additional calls to this class are required to save changes
     *
     * @param task The task to be removed
     * @return A boolean representing if the delete was successful
     */
    @Override
    public boolean delete(Task task) {
        load();
        try {
            currentUser.removeTask(task);
        } catch (Exception e) {
            userDatabaseGateway.saveToFile();
            return false;
        }
        userDatabaseGateway.saveToFile();
        return true;
    }

    /**
     * Checks if a Task exists in the currently logged-in user's Tasks
     *
     * @param name The name of the Task to be checked
     * @return A boolean representing if the Task already exists
     */
    @Override
    public boolean contains(String name) {
        load();
        for (Task task : taskList) {
            if (task.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
