package controllers.Tasks;

import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;
import useCases.Tasks.RemoveTagInputBoundary;

public class RemoveTagController {

    private final RemoveTagInputBoundary inputBoundary;

    public RemoveTagController(RemoveTagInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public TaskResponseModel removeTag(String name, String tagName) {
        TaskRequestModel taskRequestModel = new TaskRequestModel(
                name,
                null,
                null,
                null,
                tagName,
                null
        );
        return inputBoundary.removeTag(taskRequestModel);
    }

}
