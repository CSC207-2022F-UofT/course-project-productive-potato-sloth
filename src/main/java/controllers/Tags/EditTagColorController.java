package controllers.Tags;

import gateways.Tags.TagRequestModel;
import gateways.Tags.TagResponseModel;
import useCases.Tags.EditTagInputBoundary;

import java.awt.*;

/**
 * A controller which takes user input relevant to editing a Tag colour and sends it through the input boundary
 */
public class EditTagColorController {

    /**
     * The interface which allows access to the EditTag use case
     */
    private final EditTagInputBoundary inputBoundary;

    /**
     * Creates an instance of EditTagColorController with the required fields
     *
     * @param inputBoundary Interface for accessing the EditTagColor use case
     */
    public EditTagColorController(EditTagInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public TagResponseModel createTag(String name, Color color) {
        TagRequestModel tagRequestModel = new TagRequestModel(name, color);
        return inputBoundary.editTagColor(tagRequestModel);
    }


}
