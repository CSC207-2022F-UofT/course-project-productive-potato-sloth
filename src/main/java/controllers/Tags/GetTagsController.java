package controllers.Tags;

import entities.User;
import gateways.Tags.TagInfoRequestModel;
import gateways.Tags.TagInfoResponseModel;
import gateways.Tags.TagRequestModel;
import gateways.Tags.TagResponseModel;
import useCases.Tags.CreateTagInputBoundary;
import useCases.Tags.GetTagsInputBoundary;

import java.awt.*;

public class GetTagsController {

    /**
     * The interface which allows access to the GetTags use case
     */
    private final GetTagsInputBoundary inputBoundary;

    /**
     * Creates an instance of GetTagsController with the required fields
     *
     * @param inputBoundary Interface for accessing the GetTags use case
     */
    public GetTagsController(GetTagsInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public TagInfoResponseModel getTags() {
        TagInfoRequestModel tagInfoRequestModel = new TagInfoRequestModel();
        return inputBoundary.getTags(tagInfoRequestModel);
    }

}
