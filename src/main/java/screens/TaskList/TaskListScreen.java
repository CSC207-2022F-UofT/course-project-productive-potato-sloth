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

    String selectedTask;

    public TaskListScreen(
            TaskListViewModel viewModel,
            GetTaskInfoController getTaskInfoController,
            RemoveTaskController removeTaskController,
            TaskScreen taskScreen,
            NewTaskScreen newTaskScreen
    ) {

        this.viewModel = viewModel;
        this.getTaskInfoController = getTaskInfoController;
        this.removeTaskController = removeTaskController;
        this.taskScreen = taskScreen;
        this.newTaskScreen = newTaskScreen;

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
                    JPopupMenu popUp = new JPopupMenu("asdf");
                    JButton deleteTask = new JButton("Delete Task");
                    deleteTask.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int result = JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete this task?", "Delete Task",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE);


                            if (result == 0) { // User selected yes

                                TaskInfoResponseModel viewModel = getTaskInfoController.getInfo(selectedTask);
                                viewModel.removeTask(selectedTask);
                                removeTaskController.removeTask(selectedTask);
                                update(viewModel);
                            }


                        }
                    });


                    popUp.add(deleteTask);
                    popUp.show(frame, e.getXOnScreen(), e.getYOnScreen());
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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
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
