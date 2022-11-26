package gateways.Tasks;

public class TaskResponseModel {

    private final boolean success;
    private final String message;

    public TaskResponseModel(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
