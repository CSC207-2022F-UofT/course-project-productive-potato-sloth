package screens.TaskList;

import controllers.Tasks.GetTaskInfoController;
import controllers.Tasks.RemoveTaskController;
import gateways.Tasks.TaskInfoResponseModel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class DeleteTaskConfirmationDialog extends JOptionPane implements Subject {

    RemoveTaskController removeTaskController;
    GetTaskInfoController getTaskInfoController;
    String selectedTask;
    List<Observer> observerList = new ArrayList<>();

    public DeleteTaskConfirmationDialog(RemoveTaskController removeTaskController, GetTaskInfoController getTaskInfoController) {
        this.removeTaskController = removeTaskController;
        this.getTaskInfoController = getTaskInfoController;
        this.selectedTask = selectedTask;
    }

    public void showScreen(String selectedTask) {

        this.selectedTask = selectedTask;

        int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this task?", "Delete Task",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (result == 0) { // User selected yes
            deleteTask();
        }
    }

    private void deleteTask() {
        TaskInfoResponseModel viewModel = getTaskInfoController.getInfo(selectedTask);
        viewModel.removeTask(selectedTask);
        removeTaskController.removeTask(selectedTask);
        updateObservers(viewModel);
    }


    @Override
    public void registerObserver(Observer o) {
        this.observerList.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        this.observerList.remove(o);
    }

    @Override
    public void updateObservers(TaskInfoResponseModel viewModel) {
        for (Observer o : observerList) {
            o.update(viewModel);
        }
    }
}
