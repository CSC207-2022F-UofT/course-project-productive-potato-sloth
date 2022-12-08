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

/**
 * A Screen which shows the edit menu of a Task
 */
public class TaskEditScreen implements Subject, ActionListener {

    /**
     * The window of the screen
     */
    JFrame frame = new JFrame("Edit Task");

    /**
     * The panel holding the content
     */
    JPanel panel = new JPanel();

    /**
     * The name of the task to be edited
     */
    String taskName;

    /**
     * The information about the selected task
     */
    TaskInfoResponseModel response;

    /**
     * All controllers and services necessary for editing tasks
     */
    CurrentUserService currentUserService;
    GetTaskInfoController getTaskInfoController;
    AddCollaboratorController addCollaboratorController;
    AddTagController addTagController;
    EditTaskDescriptionController editTaskDescriptionController;
    EditTaskNameController editTaskNameController;
    MarkTaskCompletenessController markTaskCompletenessController;
    RemoveCollaboratorController removeCollaboratorController;
    RemoveTagController removeTagController;

    /**
     * The new fields the user has entered
     */
    JTextField newName;
    JTextField newDescription;
    JCheckBox completed;
    JComboBox<String> newTags;
    String existingTag;
    JComboBox<String> newCollaborators;
    String existingCollaborators;

    /**
     * The Observers updated when a change happens
     */
    List<Observer> observerList = new ArrayList<Observer>();

    /**
     * Instantiates TaskEditScreen with all controllers necessary for Task editing
     */
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

    /**
     * Displays the frame on the User's screen
     * Requires a Task name to know which Task is being edited
     *
     * @param taskName The name of the Task to be edited
     */
    public void showScreen(String taskName) {
        panel.removeAll();
        this.taskName = taskName;

        // Retrieving the state of the Task before edit
        TaskInfoResponseModel response = getTaskInfoController.getInfo(taskName);
        this.response = response;

        // Creating labels and fields for Users to enter their new data
        // Fields and labels will reflect the Task state before any edits
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


        // Creating the buttons
        JButton save = new JButton("Save");
        save.addActionListener(this);

        // Adding buttons on the panel and setting frame and panel configurations
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


    /**
     * Edits the task to match the inputs the User specified
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        TaskInfoResponseModel viewModel;

        // Calling all controllers
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

            // Updating all observers
            viewModel = getTaskInfoController.getInfo(newName.getText());
            updateObservers(viewModel);
            frame.setVisible(false);

            // Catching any errors
        } catch (TaskError error) {
            JOptionPane.showMessageDialog(frame, error.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Register an observer to receive updates
     *
     * @param o The new observer
     */
    @Override
    public void registerObserver(Observer o) {
        this.observerList.add(o);
    }

    /**
     * Removes an observer from receiving updates
     *
     * @param o The observer to remove
     */
    @Override
    public void removeObserver(Observer o) {
        this.observerList.remove(o);
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
