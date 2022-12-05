package controllers.Tags;

import entities.User;
import gateways.Tags.TagRequestModel;
import gateways.Tags.TagResponseModel;
import useCases.Tags.CreateTagInputBoundary;

import java.awt.*;

public class CreateTagController {

    private final CreateTagInputBoundary inputBoundary;

    public CreateTagController(CreateTagInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public TagResponseModel createTag(String name, Color color, User user) {
        TagRequestModel tagRequestModel = new TagRequestModel(name, color);
        return inputBoundary.create(tagRequestModel);
    }

}
