package controllers.Tasks;

import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;
import useCases.Tasks.EditTaskInputBoundary;

public class EditTaskNameController {

    private final EditTaskInputBoundary inputBoundary;

    public EditTaskNameController(EditTaskInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public TaskResponseModel editName(String name, String newName) {
        TaskRequestModel taskRequestModel = new TaskRequestModel(
                name,
                newName,
                null,
                null,
                null,
                null
        );
        return inputBoundary.editName(taskRequestModel);
    }

}
