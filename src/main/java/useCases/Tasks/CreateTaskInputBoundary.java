package useCases.Tasks;

import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;

public interface CreateTaskInputBoundary {
    TaskResponseModel create(TaskRequestModel taskRequestModel);
}
