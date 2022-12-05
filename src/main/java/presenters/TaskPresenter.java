package presenters;

import gateways.Tasks.TaskResponseModel;

public interface TaskPresenter {

    TaskResponseModel prepareSuccessView(TaskResponseModel taskResponseModel);

    TaskResponseModel prepareFailView(String errorMessage);
}
