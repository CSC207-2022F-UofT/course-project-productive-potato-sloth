package screens.TaskList;

import gateways.Tasks.TaskInfoResponseModel;

public interface Observer {
    public void update(TaskInfoResponseModel viewModel);
}
