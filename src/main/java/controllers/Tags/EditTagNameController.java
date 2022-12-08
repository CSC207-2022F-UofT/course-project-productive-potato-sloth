package controllers.Tags;

import gateways.Tags.TagRequestModel;
import gateways.Tags.TagResponseModel;
import useCases.Tags.EditTagInputBoundary;

import java.awt.*;

/**
 * A controller which takes user input relevant to editing a Tag name and sends it through the input boundary
 */
public class EditTagNameController {

    /**
     * The interface which allows access to the EditTag use case
     */
    private final EditTagInputBoundary inputBoundary;

    /**
     * Creates an instance of EditTagNameController with the required fields
     *
     * @param inputBoundary Interface for accessing the EditTagName use case
     */
    public EditTagNameController(EditTagInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public TagResponseModel createTag(String name, Color color) {
        TagRequestModel tagRequestModel = new TagRequestModel(name, color);
        return inputBoundary.editTagName(tagRequestModel);
    }

}
