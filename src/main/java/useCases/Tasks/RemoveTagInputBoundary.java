package useCases.Tasks;

import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;

public interface RemoveTagInputBoundary {

    TaskResponseModel removeTag(TaskRequestModel taskRequestModel);

}
