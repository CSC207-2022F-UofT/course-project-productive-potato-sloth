package entities;

public class TaskFactory {

    public Task create(String name, User user) {
        return new Task(name, user);
    }
    
    public Task create(String name, User user, String description) {
        return new Task(name, user, description);
    }

}
