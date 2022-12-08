package useCases.Tasks;

import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;

/**
 * An interface which hides the details of how a Collaborator is removed from a Task
 */
public interface RemoveCollaboratorInputBoundary {

    /**
     * The method which removes a collaborator from a Task
     *
     * @param taskRequestModel Contains the name of the Collaborator
     * @return The Response Model containing the name of the Collaborator removed
     */
    TaskResponseModel removeCollaborator(TaskRequestModel taskRequestModel);

}

