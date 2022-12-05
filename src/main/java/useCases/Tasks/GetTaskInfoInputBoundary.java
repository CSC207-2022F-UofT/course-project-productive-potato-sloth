package useCases.Tasks;

import gateways.Tasks.TaskInfoRequestModel;
import gateways.Tasks.TaskInfoResponseModel;

public interface GetTaskInfoInputBoundary {

    TaskInfoResponseModel getInfo(TaskInfoRequestModel taskInfoRequestModel);

}
