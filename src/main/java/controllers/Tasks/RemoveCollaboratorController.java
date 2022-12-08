package controllers.Tasks;

import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;
import useCases.Tasks.RemoveCollaboratorInputBoundary;

/**
 * A controller which takes user input relevant to removing a Collaborator and sends it through the input boundary
 */
public class RemoveCollaboratorController {

    /**
     * The interface which allows access to the RemoveCollaborator use case
     */
    private final RemoveCollaboratorInputBoundary inputBoundary;

    /**
     * Creates an instance of RemoveCollaboratorController with the required fields
     *
     * @param inputBoundary Interface for accessing the RemoveCollaborator use case
     */
    public RemoveCollaboratorController(RemoveCollaboratorInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * The method which takes raw input pertaining to removing a collaborator and returns a Response
     * This method packages the data into a TaskRequestModel first before sending it through the input boundary
     *
     * @param name                 The name of the Task
     * @param collaboratorUsername The name of the collaborator
     * @return The Response Model containing the removed name of the collaborator
     */
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
