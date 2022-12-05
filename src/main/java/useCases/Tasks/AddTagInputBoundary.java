package useCases.Tasks;

import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;

public interface AddTagInputBoundary {
    TaskResponseModel addTag(TaskRequestModel taskRequestModel);
}
