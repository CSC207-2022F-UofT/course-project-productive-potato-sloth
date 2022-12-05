package screens.TaskList;

import gateways.Tasks.TaskInfoResponseModel;

public interface Subject {
    public void registerObserver(Observer o);

    public void removeObserver(Observer o);

    public void updateObservers(TaskInfoResponseModel viewModel);
}
