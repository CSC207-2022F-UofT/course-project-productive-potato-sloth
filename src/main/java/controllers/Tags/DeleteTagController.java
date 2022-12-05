package controllers.Tags;

import gateways.Tags.TagRequestModel;
import gateways.Tags.TagResponseModel;
import useCases.Tags.DeleteTagInputBoundary;

import java.awt.*;

public class DeleteTagController {

    private final DeleteTagInputBoundary inputBoundary;

    public DeleteTagController(DeleteTagInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public TagResponseModel createTag(String name, Color color) {
        TagRequestModel tagRequestModel = new TagRequestModel(name, color);
        return inputBoundary.delete(tagRequestModel);
    }

}
