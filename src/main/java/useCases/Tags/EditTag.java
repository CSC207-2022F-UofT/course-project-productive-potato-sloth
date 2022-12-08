package useCases.Tags;

import entities.Tag;
import gateways.Tags.TagDataAccessInterface;
import gateways.Tags.TagRequestModel;
import gateways.Tags.TagResponseModel;

/**
 * A use case which edits a tag
 */
public class EditTag implements EditTagInputBoundary {

    /**
     * The interface which allows access to the TagDatabase
     */
    TagDataAccessInterface databaseGateway;

    /**
     * Creates an instance of EditTag with the required fields
     *
     * @param tagDatabaseGateway Interface for accessing Tag
     */
    public EditTag(TagDataAccessInterface tagDatabaseGateway) {
        this.databaseGateway = tagDatabaseGateway;
    }

    /**
     * Edits a Tag with the fields specified in the Request Model
     *
     * @param tagRequestModel The input data with all required fields relevant to editing a Tag name
     * @return The Response Model with all the Tag fields
     */
    @Override
    public TagResponseModel editTagName(TagRequestModel tagRequestModel) {
        Tag tag = databaseGateway.get(tagRequestModel.getName());
        tag.setName(tagRequestModel.getName());
        return new TagResponseModel(
                tagRequestModel.getName(),
                tagRequestModel.getColor(),
                true
        );
    }

    /**
     * Edits a Tag with the fields specified in the Request Model
     *
     * @param tagRequestModel The input data with all required fields relevant to editing a Tag description
     * @return The Response Model with all the Tag fields
     */
    @Override
    public TagResponseModel editTagColor(TagRequestModel tagRequestModel) {
        Tag tag = databaseGateway.get(tagRequestModel.getName());
        tag.setColor(tagRequestModel.getColor());
        return new TagResponseModel(
                tagRequestModel.getName(),
                tagRequestModel.getColor(),
                true
        );
    }
}
