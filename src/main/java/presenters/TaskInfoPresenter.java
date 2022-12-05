package presenters;

import gateways.Tasks.TaskInfoRequestModel;
import gateways.Tasks.TaskInfoResponseModel;

public interface TaskInfoPresenter {
    TaskInfoResponseModel prepareSuccessView(TaskInfoResponseModel taskInfoResponseModel);

    TaskInfoResponseModel prepareFailView(String error);
}
