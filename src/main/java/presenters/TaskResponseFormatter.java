package presenters;

import gateways.Tasks.TaskResponseModel;
import screens.TaskList.TaskError;

public class TaskResponseFormatter implements TaskPresenter {
    @Override
    public TaskResponseModel prepareSuccessView(TaskResponseModel taskResponseModel) {
        return taskResponseModel;
    }

    @Override
    public TaskResponseModel prepareFailView(String errorMessage) {
        throw new TaskError(errorMessage);
    }
}
