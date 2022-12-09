package screens.TaskList;

import controllers.Tags.CreateTagController;
import controllers.Tags.GetTagsController;
import gateways.Tags.TagInfoResponseModel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.BorderFactory;

import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class NewTagScreen implements TagSubject {

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
    final GetTagsController getTagsController;

    /**
     * A controller which creates a new Task
     */
    final CreateTagController createTagController;
    /**
     * The Observers updated when a change occurs
     */
    final List<TagObserver> observerList = new ArrayList<>();
    /**
     * The Text Field where the User enters a name
     */
    JTextField nameField;


    /**
     * Instantiates NewTagScreen with the required controllers
     *
     * @param getTagsController   The controller to retrieve Tag info
     * @param createTagController The controller to create Tags
     */
    public NewTagScreen(
            GetTagsController getTagsController,
            CreateTagController createTagController
    ) {
        this.getTagsController = getTagsController;
        this.createTagController = createTagController;
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
        JButton addTask = new JButton("Add Tag");
        addTask.addActionListener(e -> {
            // Retrieves the name entered in the text field and creates the corresponding Task
            String name1 = nameField.getText();
            try {
                createTagController.createTag(name1, Color.RED);
            } catch (TaskError taskError) {
                JOptionPane.showMessageDialog(frame, taskError.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            // Updates all observers
            TagInfoResponseModel viewModel = getTagsController.getTags();
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
    public void registerObserver(TagObserver o) {
        observerList.add(o);
    }

    /**
     * Removes an observer from receiving updates
     *
     * @param o The observer to remove
     */
    @Override
    public void removeObserver(TagObserver o) {
        observerList.remove(o);
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
