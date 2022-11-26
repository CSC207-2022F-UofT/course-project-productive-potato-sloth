package gateways.Tasks;

import entities.Task;
import entities.User;
import gateways.DatabaseGateway;
import gateways.UserDatabaseGateway;
import services.CurrentUserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskDatbaseGateway extends DatabaseGateway implements TaskDataAccessInterface {


    private final CurrentUserService currentUserService;
    private UserDatabaseGateway userDatabaseGateway;
    private List<User> userList;
    private User currentUser;
    private ArrayList<Task> taskList;

    /**
     * Instantiating DatabaseGateway with a relative path will store the absolute path to the respective database.
     * If the file at the path does not exist, one will be created
     * This absolute path can be fetched using the getAbsoluteFilepath method
     *
     * @throws IOException Throws exception if encountering failed or interrupted IO exceptions
     */
    public TaskDatbaseGateway(CurrentUserService currentUserService, UserDatabaseGateway userDatabaseGateway) throws IOException {
        super(userDatabaseGateway.getAbsoluteFilepath());
        this.currentUserService = currentUserService;
        this.userDatabaseGateway = userDatabaseGateway;
        load();
    }

    public void load() {
        this.userList = userDatabaseGateway.loadFromFile();
        this.currentUser = userDatabaseGateway.get(currentUserService.getCurrentUser().getUsername());
        this.taskList = (ArrayList<Task>) currentUser.getTasks();
    }

    public Task get(String name) {
        load();
        for (Task task : taskList) {
            if (task.getName().equals(name)) {
                return task;
            }
        }
        return null;
    }


    @Override
    public List<Task> getAll() {
        load();
        return taskList;
    }

    @Override
    public void insert(Task task) {
        load();
        currentUser.addTask(task);
        userDatabaseGateway.saveToFile();
    }

    @Override
    public boolean update(Task task) {
        load();
        try {
            delete(task);
            insert(task);
        } catch (Exception e) {
            userDatabaseGateway.saveToFile();
            return false;
        }
        userDatabaseGateway.saveToFile();
        return true;
    }

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
