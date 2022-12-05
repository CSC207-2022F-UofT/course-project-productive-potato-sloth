package controllers.Tasks;

import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;
import useCases.Tasks.AddCollaboratorInputBoundary;

public class AddCollaboratorController {

    private final AddCollaboratorInputBoundary inputBoundary;

    public AddCollaboratorController(AddCollaboratorInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public TaskResponseModel addCollaborator(String name, String collaboratorUsername) {
        TaskRequestModel taskRequestModel = new TaskRequestModel(
                name,
                null,
                null,
                null,
                null,
                collaboratorUsername
        );
        return inputBoundary.addCollaborator(taskRequestModel);
    }

}
