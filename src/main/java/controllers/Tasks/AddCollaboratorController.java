package controllers.Tasks;

import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;
import useCases.Tasks.AddCollaboratorInputBoundary;

/**
 * A controller which takes user input relevant to adding a collaborator and sends it through the input boundary
 */
public class AddCollaboratorController {

    /**
     * The interface which allows access to the AddCollaborator use case
     */
    private final AddCollaboratorInputBoundary inputBoundary;

    /**
     * Creates an instance of AddCollaboratorController with the required fields
     *
     * @param inputBoundary Interface for accessing the AddCollaborator use case
     */
    public AddCollaboratorController(AddCollaboratorInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * The method which takes raw input pertaining to adding a collaborator and returns a Response
     * This method packages the data into a TaskRequestModel first before sending it through the input boundary
     *
     * @param name                 The name of the Task
     * @param collaboratorUsername The name of the collaborator
     * @return The Response Model containing the name of the collaborator
     */
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
