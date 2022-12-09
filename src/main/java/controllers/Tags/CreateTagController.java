package controllers.Tags;

import gateways.Tags.TagRequestModel;
import gateways.Tags.TagResponseModel;
import useCases.Tags.CreateTagInputBoundary;

import java.awt.*;

/**
 * A controller which takes user input relevant to creating a Tag and sends it through the input boundary
 */
public class CreateTagController {

    /**
     * The interface which allows access to the CreateTag use case
     */
    private final CreateTagInputBoundary inputBoundary;

    /**
     * Creates an instance of CreateTagController with the required fields
     *
     * @param inputBoundary Interface for accessing the CreateTag use case
     */
    public CreateTagController(CreateTagInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public TagResponseModel createTag(String name, Color color) {
        TagRequestModel tagRequestModel = new TagRequestModel(name, null, color);
        return inputBoundary.create(tagRequestModel);
    }

}
