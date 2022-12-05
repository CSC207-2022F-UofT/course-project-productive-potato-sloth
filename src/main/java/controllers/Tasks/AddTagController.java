package controllers.Tasks;

import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;
import useCases.Tasks.AddTagInputBoundary;


public class AddTagController {

    private final AddTagInputBoundary inputBoundary;

    public AddTagController(AddTagInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public TaskResponseModel addTag(String name, String tagName) {
        TaskRequestModel taskRequestModel = new TaskRequestModel(
                name,
                null,
                null,
                null,
                tagName,
                null
        );
        return inputBoundary.addTag(taskRequestModel);
    }


}
