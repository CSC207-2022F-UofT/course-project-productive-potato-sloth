package screens.TaskList;

import controllers.Tags.DeleteTagController;
import controllers.Tags.GetTagsController;
import controllers.Tasks.GetTaskInfoController;
import controllers.Tasks.RemoveTagController;
import controllers.Tasks.RemoveTaskController;
import gateways.Tags.TagInfoResponseModel;
import gateways.Tasks.TaskInfoResponseModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DeleteTagConfirmationDialogue extends JOptionPane implements TagSubject {

    /**
     * The controller for removing Tags
     */
    final DeleteTagController deleteTagController;

    /**
     * The controller for retrieving Tags info
     */
    final GetTagsController getTagsController;
    /**
     * The Observers to be updated when an update occurs
     */
    final List<TagObserver> observerList = new ArrayList<>();
    /**
     * The Tag selected for deletion
     */
    String selectedTag;

    /**
     * Instantiates DeleteTagConfirmationDialogue with the necessary controllers
     *
     * @param deleteTagController The controller to remove Tags
     * @param getTagsController   The controller to retrieve Tag info
     */
    public DeleteTagConfirmationDialogue(DeleteTagController deleteTagController, GetTagsController getTagsController) {
        this.deleteTagController = deleteTagController;
        this.getTagsController = getTagsController;
    }

    /**
     * Displays the frame on the User's screen
     *
     * @param selectedTag The Tag selected for deletion
     */
    public void showScreen(String selectedTag) {

        this.selectedTag = selectedTag;

        // Prompts the user for confirmation
        int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this tag?", "Delete Tag",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (result == 0) { // User selected yes (The java swing package has a magic number??)
            deleteTag();
        }
    }

    private void deleteTag() {
        // Deletes the Tag
        deleteTagController.delete(selectedTag, Color.RED);
        TagInfoResponseModel viewModel = getTagsController.getTags();

        // Update all observer screens
        updateObservers(viewModel);
    }


    @Override
    public void registerObserver(TagObserver o) {
        this.observerList.add(o);
    }

    @Override
    public void removeObserver(TagObserver o) {
        this.observerList.remove(o);
    }

    @Override
    public void updateObservers(TagInfoResponseModel viewModel) {
        for (TagObserver o : observerList) {
            o.update(viewModel);
        }
    }

}
