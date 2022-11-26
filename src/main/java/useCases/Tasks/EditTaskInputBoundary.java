package useCases.Tasks;

import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;

public interface EditTaskInputBoundary {
    TaskResponseModel editName(TaskRequestModel taskRequestModel);

    TaskResponseModel editDescription(TaskRequestModel taskRequestModel);
}
