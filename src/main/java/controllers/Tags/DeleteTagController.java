package controllers.Tags;

import gateways.Tags.TagRequestModel;
import gateways.Tags.TagResponseModel;
import useCases.Tags.DeleteTagInputBoundary;

import java.awt.*;

/**
 * A controller which takes user input relevant to deleting a Tag and sends it through the input boundary
 */
public class DeleteTagController {

    /**
     * The interface which allows access to the DeleteTag use case
     */
    private final DeleteTagInputBoundary inputBoundary;

    /**
     * Creates an instance of DeleteTagController with the required fields
     *
     * @param inputBoundary Interface for accessing the DeleteTag use case
     */
    public DeleteTagController(DeleteTagInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public TagResponseModel delete(String name, Color color) {
        TagRequestModel tagRequestModel = new TagRequestModel(name, null, color);
        return inputBoundary.delete(tagRequestModel);
    }

}
