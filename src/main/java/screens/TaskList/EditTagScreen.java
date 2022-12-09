package screens.TaskList;

import controllers.Tags.EditTagNameController;
import controllers.Tags.GetTagsController;
import controllers.Tasks.*;
import entities.Tag;
import gateways.Tags.TagInfoResponseModel;
import gateways.Tasks.TaskInfoResponseModel;
import services.CurrentUserService;
import useCases.Tags.GetTagsInputBoundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EditTagScreen implements TagSubject, ActionListener {


    /**
     * The window of the screen
     */
    final JFrame frame = new JFrame("Edit Task");

    /**
     * The panel holding the content
     */
    final JPanel panel = new JPanel();
    /**
     * All controllers and services necessary for editing tasks
     */
    final EditTagNameController editTagNameController;

    final GetTagsController getTagsController;

    /**
     * The Observers updated when a change happens
     */
    final List<TagObserver> observerList = new ArrayList<>();
    /**
     * The name of the tag to be edited
     */
    String tagName;
    /**
     * The information about the selected task
     */
    TaskInfoResponseModel response;
    /**
     * The new fields the user has entered
     */
    JTextField newName;

    /**
     * Instantiates TaskEditScreen with all controllers necessary for Task editing
     */
    public EditTagScreen(
            EditTagNameController editTagNameController,
            GetTagsController getTagsController
    ) {
        this.editTagNameController = editTagNameController;
        this.getTagsController = getTagsController;
    }

    /**
     * Displays the frame on the User's screen
     * Requires a Tag name to know which Tag is being edited
     *
     * @param tagName The name of the Tag to be edited
     */
    public void showScreen(String tagName) {
        panel.removeAll();
        this.tagName = tagName;

        // Creating labels and fields for Users to enter their new data
        // Fields and labels will reflect the Tag state before any edits
        JLabel nameLabel = new JLabel("Name: ");
        JTextField newName = new JTextField(tagName, 10);
        this.newName = newName;


        // Creating the buttons
        JButton save = new JButton("Save");
        save.addActionListener(this);

        // Adding buttons on the panel and setting frame and panel configurations
        panel.setBorder(BorderFactory.createEmptyBorder(30, 300, 300, 300));
        panel.setLayout(new GridLayout(0, 1));

        panel.add(nameLabel);
        panel.add(newName);

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

        // Calling all controllers
        try {
            editTagNameController.editName(tagName, newName.getText(), Color.RED);
        } catch (TagError error) {
            JOptionPane.showMessageDialog(frame, error.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        // Updating all observers
        TagInfoResponseModel viewModel = getTagsController.getTags();
        updateObservers(viewModel);
        frame.setVisible(false);
    }

    /**
     * Register an observer to receive updates
     *
     * @param o The new observer
     */
    @Override
    public void registerObserver(TagObserver o) {
        this.observerList.add(o);
    }

    /**
     * Removes an observer from receiving updates
     *
     * @param o The observer to remove
     */
    @Override
    public void removeObserver(TagObserver o) {
        this.observerList.remove(o);
    }

    /**
     * Updates all observers which are registered
     *
     * @param viewModel The view model that is updated
     */
    @Override
    public void updateObservers(TagInfoResponseModel viewModel) {
        for (TagObserver o : observerList) {
            o.update(viewModel);
        }
    }
}
