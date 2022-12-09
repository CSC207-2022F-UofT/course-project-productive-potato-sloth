package screens.TaskList;

import controllers.Tags.GetTagsController;
import gateways.Tags.TagInfoResponseModel;
import services.CurrentUserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TagScreen implements TagObserver {

    /**
     * The window of the screen
     */
    final JFrame frame = new JFrame("Tag List");

    /**
     * The panel holding the content
     */
    final JPanel panel = new JPanel();

    /**
     * The new tag button
     */
    final JButton newTag = new JButton("New Tag");

    /**
     * The new tag screen
     */
    NewTagScreen newTagScreen;

    /**
     * The delete tag popup
     */
    DeleteEditTagPopUp deleteEditTagPopUp;

    /**
     * The edit tag screen
     */
    EditTagScreen editTagScreen;

    /**
     * The controller for accessing Tags
     */
    GetTagsController getTagsController;

    /**
     * The service for getting the logged-in user
     */
    CurrentUserService currentUserService;

    /**
     * The list model corresponding to the JList
     */
    DefaultListModel<String> listModel;

    JList<String> tags;

    /**
     * @param getTagsController
     */
    public TagScreen(
            GetTagsController getTagsController,
            CurrentUserService currentUserService,
            NewTagScreen newTagScreen,
            DeleteEditTagPopUp deleteEditTagPopUp,
            EditTagScreen editTagScreen
    ) {
        this.getTagsController = getTagsController;
        this.currentUserService = currentUserService;
        this.newTagScreen = newTagScreen;
        this.deleteEditTagPopUp = deleteEditTagPopUp;
        this.editTagScreen = editTagScreen;
    }

    public void showScreen() {
        panel.removeAll();
        frame.setVisible(false);
        TagInfoResponseModel tagList = getTagsController.getTags();
        listModel = new DefaultListModel<>();
        listModel.addAll(tagList.getTags());
        ;

        tags = new JList<>();
        tags.setModel(listModel);

        tags.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tags.getSelectedValue() != null && SwingUtilities.isRightMouseButton(e)) {
                    deleteEditTagPopUp.showScreen(tags.getSelectedValue());
                    deleteEditTagPopUp.show(frame, e.getXOnScreen(), e.getYOnScreen());
                } else if (e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e)) {
                    editTagScreen.showScreen(tags.getSelectedValue());
                }
            }
        });

        newTag.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newTagScreen.showScreen();
            }
        });


        panel.setBorder(BorderFactory.createEmptyBorder(30, 100, 100, 100));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(tags);
        panel.add(Box.createRigidArea(new Dimension(10, 10))); // Empty space
        panel.add(newTag);
        frame.setPreferredSize(new Dimension(360, 500));
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void update(TagInfoResponseModel viewModel) {
        frame.setVisible(false);
        listModel.removeAllElements();
        listModel.addAll(viewModel.getTags());
        tags.setModel(listModel);
        frame.setVisible(true);
    }

}

