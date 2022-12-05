package controllers.Tasks;

import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;
import useCases.Tasks.RemoveCollaboratorInputBoundary;

public class RemoveCollaboratorController {

    private final RemoveCollaboratorInputBoundary inputBoundary;

    public RemoveCollaboratorController(RemoveCollaboratorInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public TaskResponseModel removeCollaborator(String name, String collaboratorUsername) {
        TaskRequestModel taskRequestModel = new TaskRequestModel(
                name,
                null,
                null,
                null,
                null,
                collaboratorUsername
        );
        return inputBoundary.removeCollaborator(taskRequestModel);
    }

}
