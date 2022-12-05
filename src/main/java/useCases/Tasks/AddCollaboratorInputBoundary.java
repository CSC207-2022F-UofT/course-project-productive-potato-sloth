package useCases.Tasks;


import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;

public interface AddCollaboratorInputBoundary {
    TaskResponseModel addCollaborator(TaskRequestModel taskRequestModel);
}
