package controllers.Tags;

import gateways.Tags.TagRequestModel;
import gateways.Tags.TagResponseModel;
import useCases.Tags.EditTagInputBoundary;

import java.awt.*;

public class EditTagColorController {

    private final EditTagInputBoundary inputBoundary;

    public EditTagColorController(EditTagInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public TagResponseModel createTag(String name, Color color) {
        TagRequestModel tagRequestModel = new TagRequestModel(name, color);
        return inputBoundary.editTagColor(tagRequestModel);
    }


}
