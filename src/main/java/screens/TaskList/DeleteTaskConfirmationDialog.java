package screens.TaskList;

import controllers.Tasks.GetTaskInfoController;
import controllers.Tasks.RemoveTaskController;
import gateways.Tasks.TaskInfoResponseModel;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

/**
 * The confirmation dialogue which prompts the User for deletion confirmation
 */
public class DeleteTaskConfirmationDialog extends JOptionPane implements Subject {

    /**
     * The controller for removing Tasks
     */
    final RemoveTaskController removeTaskController;

    /**
     * The controller for retrieving Task info
     */
    final GetTaskInfoController getTaskInfoController;
    /**
     * The Observers to be updated when an update occurs
     */
    final List<Observer> observerList = new ArrayList<>();
    /**
     * The Task selected for deletion
     */
    String selectedTask;

    /**
     * Instantiates DeleteTaskConfirmationDialog with the necessary controllers
     *
     * @param removeTaskController  The controller to remove Tasks
     * @param getTaskInfoController The controller to retrieve Task info
     */
    public DeleteTaskConfirmationDialog(RemoveTaskController removeTaskController, GetTaskInfoController getTaskInfoController) {
        this.removeTaskController = removeTaskController;
        this.getTaskInfoController = getTaskInfoController;
    }

    /**
     * Displays the frame on the User's screen
     *
     * @param selectedTask The Task selected for deletion
     */
    public void showScreen(String selectedTask) {

        this.selectedTask = selectedTask;

        // Prompts the user for confirmation
        int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this task?", "Delete Task",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (result == 0) { // User selected yes (The java swing package has a magic number??)
            deleteTask();
        }
    }

    private void deleteTask() {
        // Deletes the Task
        TaskInfoResponseModel viewModel = getTaskInfoController.getInfo(selectedTask);
        viewModel.removeTask(selectedTask);
        removeTaskController.removeTask(selectedTask);

        // Update all observer screens
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
