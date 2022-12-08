package screens.TaskList;

import controllers.Tags.DeleteTagController;
import controllers.Tasks.*;
import entities.Task;
import gateways.Tasks.TaskInfoResponseModel;

import javax.swing.*;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * A Screen which shows the list of Tasks of the logged in User
 */
public class TaskListScreen implements Observer {

    /**
     * The window of the screen
     */
    JFrame frame = new JFrame("Task List");

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
     * A controller which removes tasks from the list
     */
    RemoveTaskController removeTaskController;

    /**
     * The ListModel which the JList reflects
     */
    DefaultListModel<String> listModel;

    /**
     * The JList displayed on the screen
     */
    JList<String> taskList;

    /**
     * The single-view Task screen
     */
    TaskScreen taskScreen;

    /**
     * The button to add a new Task
     */
    JButton newTask;

    /**
     * The screen to add a new Task
     */
    NewTaskScreen newTaskScreen;

    /**
     * The right-click menu to delete a Task
     */
    DeleteTaskPopUp deleteTaskPopUp;

    /**
     * The currently selected task in the JList
     */
    String selectedTask;

    /**
     * Instantiates TaskListScreen with the required fields
     * Displays a list of the currently logged-in User
     *
     * @param viewModel             The view model this screen reflects
     * @param getTaskInfoController The controller to retrieve Task info
     * @param removeTaskController  The controller to remove Tasks
     * @param taskScreen            The single Task view screen
     * @param newTaskScreen         The screen to add Tasks
     * @param deleteTaskPopUp       The right-click menu to delete Tasks
     */
    public TaskListScreen(
            TaskListViewModel viewModel,
            GetTaskInfoController getTaskInfoController,
            RemoveTaskController removeTaskController,
            TaskScreen taskScreen,
            NewTaskScreen newTaskScreen,
            DeleteTaskPopUp deleteTaskPopUp
    ) {
        this.viewModel = viewModel;
        this.getTaskInfoController = getTaskInfoController;
        this.removeTaskController = removeTaskController;
        this.taskScreen = taskScreen;
        this.newTaskScreen = newTaskScreen;
        this.deleteTaskPopUp = deleteTaskPopUp;

        // Adding Tasks to the ListModel
        listModel = new DefaultListModel<>();
        this.taskList = new JList<>();
        this.taskList.setVisibleRowCount(10);
        for (String task : viewModel.getTasks()) {
            listModel.addElement(task);
        }

        // Updating the task list to reflect the ListModel
        this.taskList.setModel(listModel);

        // Adding a mouse listener to detect actions on the task list
        taskList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                // Detecting a double click
                if (e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e)) {
                    // Setting the selected task, showing the single task view screen
                    String selectedTask = taskList.getSelectedValue();
                    setSelectedTask(selectedTask);
                    viewModel.setSelectedTask(selectedTask);
                    taskScreen.showScreen(viewModel);

                    // Detecting a right click
                } else if (SwingUtilities.isRightMouseButton(e) && taskList.getSelectedValue() != null) {
                    // Setting the selected Task, showing the right-click menu popup at current mmouse location
                    // This can be refactored later
                    String selectedTask = taskList.getSelectedValue();
                    setSelectedTask(selectedTask);
                    deleteTaskPopUp.showScreen(selectedTask);
                    deleteTaskPopUp.show(frame, e.getXOnScreen(), e.getYOnScreen());
                }
            }
        });

        // New Task button configuration
        newTask = new JButton("New Task");
        newTask.setPreferredSize(new Dimension(140, 20));
        newTask.addActionListener(new ActionListener() {
            // Show the New Task Screen on button press
            @Override
            public void actionPerformed(ActionEvent e) {
                newTaskScreen.showScreen();
            }
        });

        // Panel sizing and layout configurations
        panel.setBorder(BorderFactory.createEmptyBorder(30, 100, 100, 100));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(this.taskList);
        panel.add(Box.createRigidArea(new Dimension(10, 10))); // Empty space
        panel.add(newTask);

        frame.setPreferredSize(new Dimension(360, 500));
        frame.add(panel);
        frame.pack();
        frame.setVisible(false);
    }

    /**
     * Displays the frame on the User's screen
     */
    public void showScreen() {
        frame.setVisible(true);
    }


    private void setSelectedTask(String selectedTask) {
        this.selectedTask = selectedTask;

    }

    /**
     * Redraws the screen using the updated view model
     *
     * @param viewModel The updated view model
     */
    @Override
    public void update(TaskInfoResponseModel viewModel) {
        frame.setVisible(false);

        listModel.addElement("a"); // I'm not sure why removing this line of code stops the next line from working
        panel.removeAll();

        // Creating a new task list
        JList<String> newTaskList = new JList<>();
        newTaskList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Detecting a double click
                if (e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e)) {
                    String selectedTask = newTaskList.getSelectedValue();
                    setSelectedTask(selectedTask);
                    TaskListViewModel newViewModel = new TaskListViewModel();
                    newViewModel.setSelectedTask(selectedTask);
                    taskScreen.showScreen(newViewModel);

                } else if (SwingUtilities.isRightMouseButton(e) && newTaskList.getSelectedValue() != null) {
                    String selectedTask = newTaskList.getSelectedValue();
                    setSelectedTask(selectedTask);
                    deleteTaskPopUp.showScreen(selectedTask);
                    deleteTaskPopUp.show(frame, e.getXOnScreen(), e.getYOnScreen());
                }
            }
        });

        // Creating a new ListModel, retrieving relevant info from view model
        DefaultListModel<String> newListModel = new DefaultListModel<>();

        for (String task : viewModel.getAllTasks()) {
            newListModel.addElement(task);
        }
        newTaskList.setModel(newListModel);

        // Panel and frame layout and configurations
        frame.remove(panel);
        panel.add(new JScrollPane(newTaskList));
        panel.add(Box.createRigidArea(new Dimension(10, 10))); // Empty space
        panel.add(newTask);
        frame.add(panel);
        frame.setVisible(true);

    }

}
