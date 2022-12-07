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


public class TaskListScreen implements Observer {

    JFrame frame = new JFrame("Task List");

    JPanel panel = new JPanel();
    TaskListViewModel viewModel;
    GetTaskInfoController getTaskInfoController;
    RemoveTaskController removeTaskController;
    DefaultListModel<String> listModel;
    JList<String> taskList;

    TaskScreen taskScreen;
    JButton newTask;
    NewTaskScreen newTaskScreen;
    DeleteTaskPopUp deleteTaskPopUp;

    String selectedTask;

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

        listModel = new DefaultListModel<>();
        this.taskList = new JList<>();
        this.taskList.setVisibleRowCount(10);
        for (String task : viewModel.getTasks()) {
            listModel.addElement(task);
        }
        this.taskList.setModel(listModel);


        taskList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Detecting a double click
                if (e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e)) {
                    String selectedTask = taskList.getSelectedValue();
                    setSelectedTask(selectedTask);
                    viewModel.setSelectedTask(selectedTask);
                    taskScreen.showScreen(viewModel);

                } else if (SwingUtilities.isRightMouseButton(e) && taskList.getSelectedValue() != null) {
                    String selectedTask = taskList.getSelectedValue();
                    setSelectedTask(selectedTask);
                    deleteTaskPopUp.showScreen(selectedTask);
                    deleteTaskPopUp.show(frame, e.getXOnScreen(), e.getYOnScreen());
                }
            }
        });


        newTask = new JButton("New Task");
        newTask.setPreferredSize(new Dimension(140, 20));
        newTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newTaskScreen.showScreen();
            }
        });

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

    public void showScreen() {
        frame.setVisible(true);
    }


    private void setSelectedTask(String selectedTask) {
        this.selectedTask = selectedTask;

    }

    @Override
    public void update(TaskInfoResponseModel viewModel) {

        listModel.addElement("a"); // I'm not sure why removing this line of code stops the next line from working
        panel.removeAll();

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


        DefaultListModel<String> newListModel = new DefaultListModel<>();

        for (String task : viewModel.getAllTasks()) {
            newListModel.addElement(task);
        }
        newTaskList.setModel(newListModel);


        panel.add(new JScrollPane(newTaskList));
        panel.add(Box.createRigidArea(new Dimension(10, 10))); // Empty space
        panel.add(newTask);


    }

}
