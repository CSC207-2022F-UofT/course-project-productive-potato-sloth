package screens.TaskList;

import gateways.Tasks.TaskInfoResponseModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteTaskPopUp extends JPopupMenu implements ActionListener {

    String selectedTask;

    DeleteTaskConfirmationDialog deleteTaskConfirmationDialog;

    public DeleteTaskPopUp(DeleteTaskConfirmationDialog deleteTaskConfirmationDialog) {
        super("Delete Task");
        this.deleteTaskConfirmationDialog = deleteTaskConfirmationDialog;
    }

    public void showScreen(String selectedTask) {
        this.selectedTask = selectedTask;
        JButton deleteTask = new JButton("Delete Task");
        deleteTask.addActionListener(this);
        this.add(deleteTask);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        deleteTaskConfirmationDialog.showScreen(selectedTask);
    }
}
