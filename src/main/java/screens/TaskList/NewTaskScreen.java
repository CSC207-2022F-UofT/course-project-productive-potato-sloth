package screens.TaskList;

import controllers.Tasks.*;
import gateways.Tasks.TaskInfoResponseModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;


public class NewTaskScreen implements Subject {

    JFrame frame = new JFrame();

    JPanel panel = new JPanel();
    GetTaskInfoController getTaskInfoController;
    CreateTaskController createTaskController;

    JTextField nameField;

    List<Observer> observerList = new ArrayList<>();


    public NewTaskScreen(
            GetTaskInfoController getTaskInfoController,
            CreateTaskController createTaskController
    ) {
        this.getTaskInfoController = getTaskInfoController;
        this.createTaskController = createTaskController;
    }

    public void showScreen() {
        this.panel.removeAll();

        panel.setBorder(BorderFactory.createEmptyBorder(30, 300, 300, 300));
        panel.setLayout(new GridLayout(0, 1));

        JLabel name = new JLabel("Name: ");
        nameField = new JTextField();

        JButton addTask = new JButton("Add Task");
        addTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                createTaskController.createTask(name);
                TaskInfoResponseModel viewModel = getTaskInfoController.getInfo(name);
                updateObservers(viewModel);
                frame.setVisible(false);
            }
        });

        panel.add(name);
        panel.add(nameField);
        panel.add(addTask);
        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void registerObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observerList.remove(o);
    }

    @Override
    public void updateObservers(TaskInfoResponseModel viewModel) {
        for (Observer o : observerList) {
            o.update(viewModel);
        }
    }
}
