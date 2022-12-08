package screens.TaskList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteTaskPopUp extends JPopupMenu implements ActionListener {

    /**
     * The confirmation dialogue for deletion
     */
    final DeleteTaskConfirmationDialog deleteTaskConfirmationDialog;
    /**
     * The selected task to be potentially deleted
     */
    String selectedTask;

    /**
     * Instantiates DeleteTaskPopUp with the dialogue
     *
     * @param deleteTaskConfirmationDialog The confirmation dialogue
     */
    public DeleteTaskPopUp(DeleteTaskConfirmationDialog deleteTaskConfirmationDialog) {
        super("Delete Task");
        this.deleteTaskConfirmationDialog = deleteTaskConfirmationDialog;

        // Creating and adding buttons to the frame
        JButton deleteTask = new JButton("Delete Task");
        deleteTask.addActionListener(this);
        this.add(deleteTask);
    }

    /**
     * Displays the frame on the User's screen
     *
     * @param selectedTask The Task the User has selected for deletion
     */
    public void showScreen(String selectedTask) {
        this.selectedTask = selectedTask;
    }


    /**
     * Shows the Task deletion confirmation dialogue
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        deleteTaskConfirmationDialog.showScreen(selectedTask);
    }
}
