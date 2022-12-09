package gateways.Tasks;

/**
 * A class which is passed into the GetTaskInfo use case as a Request
 */
public class TaskInfoRequestModel {

    final String name;

    public TaskInfoRequestModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
