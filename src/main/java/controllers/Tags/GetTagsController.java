package controllers.Tags;

import gateways.Tags.TagInfoRequestModel;
import gateways.Tags.TagInfoResponseModel;
import useCases.Tags.GetTagsInputBoundary;

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
