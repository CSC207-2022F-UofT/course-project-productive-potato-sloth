package screens.TaskList;

import controllers.Tasks.*;
import entities.Tag;
import entities.Task;
import gateways.Tasks.TaskInfoRequestModel;
import gateways.Tasks.TaskInfoResponseModel;
import gateways.Tasks.TaskResponseModel;
import services.CurrentUserService;
import useCases.Tasks.RemoveTag;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class TaskEditScreen implements Subject, ActionListener {

    JFrame frame = new JFrame("Edit Task");

    JPanel panel = new JPanel();
    String taskName;
    TaskInfoResponseModel response;

    CurrentUserService currentUserService;
    GetTaskInfoController getTaskInfoController;
    AddCollaboratorController addCollaboratorController;
    AddTagController addTagController;
    EditTaskDescriptionController editTaskDescriptionController;
    EditTaskNameController editTaskNameController;
    MarkTaskCompletenessController markTaskCompletenessController;
    RemoveCollaboratorController removeCollaboratorController;
    RemoveTagController removeTagController;

    JTextField newName;
    JTextField newDescription;
    JCheckBox completed;
    JComboBox<String> newTags;
    String existingTag;
    JComboBox<String> newCollaborators;
    String existingCollaborators;

    List<Observer> observerList = new ArrayList<Observer>();

    public TaskEditScreen(
            CurrentUserService currentUserService,
            GetTaskInfoController getTaskInfoController,
            AddCollaboratorController addCollaboratorController,
            AddTagController addTagController,
            EditTaskDescriptionController editTaskDescriptionController,
            EditTaskNameController editTaskNameController,
            MarkTaskCompletenessController markTaskCompletenessController,
            RemoveCollaboratorController removeCollaboratorController,
            RemoveTagController removeTagController
    ) {
        this.currentUserService = currentUserService;
        this.getTaskInfoController = getTaskInfoController;
        this.addCollaboratorController = addCollaboratorController;
        this.addTagController = addTagController;
        this.editTaskDescriptionController = editTaskDescriptionController;
        this.editTaskNameController = editTaskNameController;
        this.markTaskCompletenessController = markTaskCompletenessController;
        this.removeCollaboratorController = removeCollaboratorController;
        this.removeTagController = removeTagController;
    }

    public void showScreen(String taskName) {
        panel.removeAll();
        this.taskName = taskName;
        TaskInfoResponseModel response = getTaskInfoController.getInfo(taskName);
        this.response = response;

        JLabel nameLabel = new JLabel("Name: ");
        JTextField newName = new JTextField(response.getName(), 10);
        this.newName = newName;

        JLabel descriptionLabel = new JLabel("Description: ");
        JTextField newDescription = new JTextField(response.getDescription(), 10);
        this.newDescription = newDescription;

        JLabel completedLabel = new JLabel("Completed: ");
        JCheckBox completed = new JCheckBox("", response.getCompleted());
        this.completed = completed;

        JLabel tagsLabel = new JLabel("Tags: ");
        JComboBox<String> newTags = new JComboBox<String>();
        this.newTags = newTags;
        newTags.addItem("None");
        for (Tag tag : currentUserService.getCurrentUser().getTags()) {
            String tagName = tag.getName();
            newTags.addItem(tagName);
        }
        if (response.getTags().size() != 0) { // If there exist tags
            String existingTag = response.getTags().get(0);
            newTags.setSelectedItem(existingTag);
            this.existingTag = existingTag;
        } else { // There exist no tags
            this.existingTag = "None";
        }


        JLabel collaboratorsLabel = new JLabel("Collaborators: ");
        JComboBox<String> newCollaborators = new JComboBox<String>();
        this.newCollaborators = newCollaborators;

        JButton save = new JButton("Save");
        save.addActionListener(this);

        panel.setBorder(BorderFactory.createEmptyBorder(30, 300, 300, 300));
        panel.setLayout(new GridLayout(0, 1));

        panel.add(nameLabel);
        panel.add(newName);

        panel.add(descriptionLabel);
        panel.add(newDescription);

        panel.add(completedLabel);
        panel.add(completed);

        panel.add(tagsLabel);
        panel.add(newTags);

        panel.add(collaboratorsLabel);
        panel.add(newCollaborators);

        panel.add(save);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        TaskInfoResponseModel viewModel;

        try {
            editTaskNameController.editName(response.getName(), newName.getText());
            editTaskDescriptionController.editDescription(newName.getText(), newDescription.getText());
            markTaskCompletenessController.setCompleteness(newName.getText(), completed.isSelected());

            if (newTags.getSelectedItem().toString().equals("None") && existingTag.equals("None")) {
            } else if (newTags.getSelectedItem().toString().equals("None")) { // The selected item is none
                removeTagController.removeTag(newName.getText(), existingTag);
            } else if (existingTag.equals("None")) {
                addTagController.addTag(newName.getText(), newTags.getSelectedItem().toString());
            } else {
                removeTagController.removeTag(newName.getText(), existingTag);
                addTagController.addTag(newName.getText(), newTags.getSelectedItem().toString());
            }


//            removeCollaboratorController.removeCollaborator(newName.getText(), existingCollaborators);
//            addCollaboratorController.addCollaborator(newName.getText(), newCollaborators.getSelectedItem().toString());
            viewModel = getTaskInfoController.getInfo(newName.getText());
            updateObservers(viewModel);
            frame.setVisible(false);

        } catch (TaskError error) {
            JOptionPane.showMessageDialog(frame, error.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
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
