package screens.TaskList;

import controllers.Tasks.*;
import gateways.Tasks.TaskInfoResponseModel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.BorderFactory;

import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

/**
 * A Screen which allows Users to add new Tasks
 */
public class NewTaskScreen implements Subject {

    /**
     * The window of the screen
     */
    final JFrame frame = new JFrame();

    /**
     * The panel holding the content
     */
    final JPanel panel = new JPanel();

    /**
     * A controller which retrieves Task information
     */
    final GetTaskInfoController getTaskInfoController;

    /**
     * A controller which creates a new Task
     */
    final CreateTaskController createTaskController;
    /**
     * The Observers updated when a change occurs
     */
    final List<Observer> observerList = new ArrayList<>();
    /**
     * The Text Field where the User enters a name
     */
    JTextField nameField;


    /**
     * Instantiates NewTaskScreen with the required controllers
     *
     * @param getTaskInfoController The controller to retrieve Task info
     * @param createTaskController  The controller to create Tasks
     */
    public NewTaskScreen(
            GetTaskInfoController getTaskInfoController,
            CreateTaskController createTaskController
    ) {
        this.getTaskInfoController = getTaskInfoController;
        this.createTaskController = createTaskController;
    }

    /**
     * Displays the frame on the User's screen
     */
    public void showScreen() {
        this.panel.removeAll();

        panel.setBorder(BorderFactory.createEmptyBorder(30, 300, 300, 300));
        panel.setLayout(new GridLayout(0, 1));

        // Creating the name label and text field
        JLabel name = new JLabel("Name: ");
        nameField = new JTextField();

        // Creating the confirmation button
        JButton addTask = new JButton("Add Task");
        addTask.addActionListener(e -> {
            // Retrieves the name entered in the text field and creates the corresponding Task
            String name1 = nameField.getText();
            try {
                createTaskController.createTask(name1);
            } catch (TaskError taskError) {
                JOptionPane.showMessageDialog(frame, taskError.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            // Updates all observers
            TaskInfoResponseModel viewModel = getTaskInfoController.getInfo(name1);
            updateObservers(viewModel);

            // Make frame invisible
            frame.setVisible(false);
        });

        // Adding fields and buttons to panel, frame configurations
        panel.add(name);
        panel.add(nameField);
        panel.add(addTask);
        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Register an observer to receive updates
     *
     * @param o The new observer
     */
    @Override
    public void registerObserver(Observer o) {
        observerList.add(o);
    }

    /**
     * Removes an observer from receiving updates
     *
     * @param o The observer to remove
     */
    @Override
    public void removeObserver(Observer o) {
        observerList.remove(o);
    }

    /**
     * Updates all observers which are registered
     *
     * @param viewModel The view model that is updated
     */
    @Override
    public void updateObservers(TaskInfoResponseModel viewModel) {
        for (Observer o : observerList) {
            o.update(viewModel);
        }
    }
}
