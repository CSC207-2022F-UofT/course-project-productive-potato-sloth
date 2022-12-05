package controllers.Tasks;

import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;
import useCases.Tasks.AddTagInputBoundary;
import useCases.Tasks.CreateTaskInputBoundary;

public class CreateTaskController {

    private final CreateTaskInputBoundary inputBoundary;

    public CreateTaskController(CreateTaskInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public TaskResponseModel createTask(String name) {
        TaskRequestModel taskRequestModel = new TaskRequestModel(
                name,
                null,
                null,
                null,
                null,
                null
        );
        return inputBoundary.create(taskRequestModel);
    }

}
