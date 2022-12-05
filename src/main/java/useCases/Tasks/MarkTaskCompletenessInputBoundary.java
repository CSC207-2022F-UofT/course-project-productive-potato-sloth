package useCases.Tasks;

import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;

public interface MarkTaskCompletenessInputBoundary {
    TaskResponseModel setCompleteness(TaskRequestModel taskRequestModel);
}
