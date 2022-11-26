package useCases.Tasks;

import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;

public interface RemoveCollaboratorInputBoundary {

    TaskResponseModel removeCollaborator(TaskRequestModel taskRequestModel);

}

