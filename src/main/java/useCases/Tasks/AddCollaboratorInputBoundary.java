package useCases.Tasks;


import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;

/**
 * An interface which hides the details of how a collaborator is added to a task
 */
public interface AddCollaboratorInputBoundary {

    /**
     * The method which adds a collaborator to a task
     *
     * @param taskRequestModel The information necessary to add a collaborator
     * @return The Response Model containing information about the collaborator
     */
    TaskResponseModel addCollaborator(TaskRequestModel taskRequestModel);
}
