package screens.TaskList;

import controllers.Tasks.*;
import entities.Task;
import gateways.Tasks.TaskInfoRequestModel;
import gateways.Tasks.TaskInfoResponseModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * A Screen which shows the one Task and its details of the logged-in User
 */
public class TaskScreen implements Observer, ActionListener {

    /**
     * The window of the screen
     */
    JFrame frame = new JFrame();

    /**
     * The panel holding the content
     */
    JPanel panel = new JPanel();

    /**
     * The view model the screen is reflecting
     */
    TaskListViewModel viewModel;

    /**
     * A controller which retrieves Task information
     */
    GetTaskInfoController getTaskInfoController;

    /**
     * The Task edit screen
     */
    TaskEditScreen taskEditScreen;

    /**
     * All labels displayed on the screen
     */
    JLabel name;
    JLabel description;
    JLabel completed;
    JLabel tags;
    JLabel collaborators;

    /**
     * Instantiates TaskListScreen with the required fields
     * Displays a list of the currently logged-in User
     *
     * @param viewModel             The view model this screen reflects
     * @param getTaskInfoController The controller to retrieve Task info
     * @param taskEditScreen        The Task edit screen
     */
    public TaskScreen(
            TaskListViewModel viewModel,
            GetTaskInfoController getTaskInfoController,
            TaskEditScreen taskEditScreen

    ) {
        this.viewModel = viewModel;
        this.getTaskInfoController = getTaskInfoController;
        this.taskEditScreen = taskEditScreen;
    }

    /**
     * Shows the edit menu for this Task
     *
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e) {
        taskEditScreen.showScreen(viewModel.getSelectedTask());
    }

    /**
     * Displays the frame on the User's screen
     *
     * @param viewModel The view model the screen reflects
     */
    public void showScreen(TaskListViewModel viewModel) {
        this.viewModel = viewModel;
        this.panel.removeAll();

        TaskInfoResponseModel response = getTaskInfoController.getInfo(viewModel.getSelectedTask());
        panel.setBorder(BorderFactory.createEmptyBorder(30, 300, 300, 300));
        panel.setLayout(new GridLayout(0, 1));

        // Retrieving all Task information
        this.name = new JLabel(String.format("<html>Task: <br>%s<br><br></html>", response.getName()));
        this.description = new JLabel(String.format("<html>Description: <br>%s<br></html>", response.getDescription()));
        this.completed = new JLabel(String.format("<html>Completed: <br>%s<br></html>", response.getCompleted()));
        this.tags = new JLabel(String.format("<html>Tags: <br>%s<br></html>", response.getTags()));
        this.collaborators = new JLabel(String.format("<html>Collaborators: <br>%s<br></html>", response.getCollaborators()));

        // Configuring buttons
        JButton editButton = new JButton("Edit Task");
        editButton.addActionListener(this);

        // Adding Task information on the screen
        panel.add(name);
        panel.add(description);
        panel.add(completed);
        panel.add(tags);
        panel.add(collaborators);

        // Adding buttons on the screen
        panel.add(editButton);

        // Frame configurations
        frame.add(panel, BorderLayout.CENTER);
        frame.setTitle(response.getName());
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Updates the screen according to the view model
     *
     * @param viewModel The updated view model
     */
    @Override
    public void update(TaskInfoResponseModel viewModel) {
        this.name.setText(String.format("<html>Task: <br>%s<br><br></html>", viewModel.getName()));
        this.description.setText((String.format("<html>Description: <br>%s<br></html>", viewModel.getDescription())));
        this.completed.setText(String.format("<html>Completed: <br>%s<br></html>", viewModel.getCompleted()));
        this.tags.setText(String.format("<html>Tags: <br>%s<br></html>", viewModel.getTags()));
        this.collaborators.setText(String.format("<html>Collaborators: <br>%s<br></html>", viewModel.getCollaborators()));
    }
}
