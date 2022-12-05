package screens.TaskList;

import controllers.Tasks.*;
import entities.Task;
import gateways.Tasks.TaskInfoRequestModel;
import gateways.Tasks.TaskInfoResponseModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TaskScreen implements Observer, ActionListener {

    JFrame frame = new JFrame();

    JPanel panel = new JPanel();

    TaskListViewModel viewModel;
    GetTaskInfoController getTaskInfoController;
    TaskEditScreen taskEditScreen;

    JLabel name;
    JLabel description;
    JLabel completed;
    JLabel tags;
    JLabel collaborators;

    public TaskScreen(
            TaskListViewModel viewModel,
            GetTaskInfoController getTaskInfoController,
            TaskEditScreen taskEditScreen

    ) {
        this.viewModel = viewModel;
        this.getTaskInfoController = getTaskInfoController;
        this.taskEditScreen = taskEditScreen;
    }


    public void actionPerformed(ActionEvent e) {
        taskEditScreen.showScreen(viewModel.getSelectedTask());
    }

    public void showScreen(TaskListViewModel viewModel) {
        this.panel.removeAll();

        TaskInfoResponseModel response = getTaskInfoController.getInfo(viewModel.getSelectedTask());
        panel.setBorder(BorderFactory.createEmptyBorder(30, 300, 300, 300));
        panel.setLayout(new GridLayout(0, 1));

        this.name = new JLabel(String.format("<html>Task: <br>%s<br><br></html>", response.getName()));
        this.description = new JLabel(String.format("<html>Description: <br>%s<br></html>", response.getDescription()));
        this.completed = new JLabel(String.format("<html>Completed: <br>%s<br></html>", response.getCompleted()));
        this.tags = new JLabel(String.format("<html>Tags: <br>%s<br></html>", response.getTags()));
        this.collaborators = new JLabel(String.format("<html>Collaborators: <br>%s<br></html>", response.getCollaborators()));


        JButton editButton = new JButton("Edit Task");
        editButton.addActionListener(this);

        JButton openChatRoom = new JButton("Open Chatroom");
        openChatRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Open chatroom");
            }
        });

        JButton collaboratorMenu = new JButton("Edit Collaborators");
        collaboratorMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        panel.add(name);
        panel.add(description);
        panel.add(completed);
        panel.add(tags);
        panel.add(collaborators);
        panel.add(editButton);
        panel.add(openChatRoom);
        panel.add(collaboratorMenu);
        frame.add(panel, BorderLayout.CENTER);
        frame.setTitle(response.getName());
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void update(TaskInfoResponseModel viewModel) {
        this.name.setText(String.format("<html>Task: <br>%s<br><br></html>", viewModel.getName()));
        this.description.setText((String.format("<html>Description: <br>%s<br></html>", viewModel.getDescription())));
        this.completed.setText(String.format("<html>Completed: <br>%s<br></html>", viewModel.getCompleted()));
        this.tags.setText(String.format("<html>Tags: <br>%s<br></html>", viewModel.getTags()));
        this.collaborators.setText(String.format("<html>Collaborators: <br>%s<br></html>", viewModel.getCollaborators()));
    }
}
