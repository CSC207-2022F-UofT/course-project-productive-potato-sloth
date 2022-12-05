package gateways.Tasks;

import entities.Task;
import gateways.DataAccessInterface;

public interface TaskDataAccessInterface extends DataAccessInterface<Task> {
    boolean contains(String name);
}
