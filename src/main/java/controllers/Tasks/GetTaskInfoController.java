package controllers.Tasks;

import gateways.Tasks.TaskInfoRequestModel;
import gateways.Tasks.TaskInfoResponseModel;
import useCases.Tasks.GetTaskInfoInputBoundary;

public class GetTaskInfoController {

    private final GetTaskInfoInputBoundary inputBoundary;

    public GetTaskInfoController(GetTaskInfoInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public TaskInfoResponseModel getInfo(String name) {
        TaskInfoRequestModel taskRequestModel = new TaskInfoRequestModel(name);
        return inputBoundary.getInfo(taskRequestModel);
    }

}
