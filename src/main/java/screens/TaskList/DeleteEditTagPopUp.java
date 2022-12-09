package screens.TaskList;


import javax.swing.JPopupMenu;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteEditTagPopUp extends JPopupMenu implements ActionListener {

    /**
     * The confirmation dialogue for deletion
     */
    final DeleteTagConfirmationDialogue deleteTagConfirmationDialogue;

    /**
     * The edit tag screen
     */
    final EditTagScreen editTagScreen;

    /**
     * The selected tag to be potentially deleted
     */
    String selectedTag;

    /**
     * Instantiates DeleteEditTagPopUp with the dialogue
     *
     * @param deleteTagConfirmationDialogue The confirmation dialogue
     */
    public DeleteEditTagPopUp(DeleteTagConfirmationDialogue deleteTagConfirmationDialogue, EditTagScreen editTagScreen) {
        super("Delete Tag");
        this.deleteTagConfirmationDialogue = deleteTagConfirmationDialogue;
        this.editTagScreen = editTagScreen;

        // Creating and adding buttons to the frame
        JButton deleteTag = new JButton("Delete Tag");
        deleteTag.addActionListener(this);
        this.add(deleteTag);

        JButton editTag = new JButton("Edit Tag");
        editTag.addActionListener(this::editTagAction);
        this.add(editTag);
    }

    /**
     * Displays the frame on the User's screen
     *
     * @param selectedTag The Task the User has selected for deletion
     */
    public void showScreen(String selectedTag) {
        this.selectedTag = selectedTag;
    }


    /**
     * Shows the Task deletion confirmation dialogue
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        deleteTagConfirmationDialogue.showScreen(selectedTag);
    }

    public void editTagAction(ActionEvent e) {
        editTagScreen.showScreen(selectedTag);
    }
}
