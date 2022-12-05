package controllers.Tasks;

import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;
import useCases.Tasks.EditTaskInputBoundary;

public class EditTaskDescriptionController {

    private final EditTaskInputBoundary inputBoundary;

    public EditTaskDescriptionController(EditTaskInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public TaskResponseModel editDescription(String name, String newDescription) {
        TaskRequestModel taskRequestModel = new TaskRequestModel(
                name,
                null,
                newDescription,
                null,
                null,
                null
        );
        return inputBoundary.editDescription(taskRequestModel);
    }


}
