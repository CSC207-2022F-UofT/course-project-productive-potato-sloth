package controllers.Tasks;

import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;
import useCases.Tasks.RemoveTaskInputBoundary;

public class RemoveTaskController {

    private final RemoveTaskInputBoundary inputBoundary;

    public RemoveTaskController(RemoveTaskInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public TaskResponseModel removeTask(String name) {
        TaskRequestModel taskRequestModel = new TaskRequestModel(
                name,
                null,
                null,
                null,
                null,
                null
        );
        return inputBoundary.removeTask(taskRequestModel);
    }

}
