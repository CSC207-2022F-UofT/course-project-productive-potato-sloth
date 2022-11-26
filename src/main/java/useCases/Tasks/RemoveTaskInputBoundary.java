package useCases.Tasks;

import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;

public interface RemoveTaskInputBoundary {

    TaskResponseModel removeTask(TaskRequestModel taskRequestModel);

}
