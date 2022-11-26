package useCases.Tags;

import entities.Tag;
import gateways.Tags.TagDatabaseGateway;
import gateways.Tags.TagRequestModel;
import gateways.Tags.TagResponseModel;

/**
 * A use case which edits a tag
 */
public class EditTag implements EditTagInputBoundary {

    TagDatabaseGateway databaseGateway;

    /**
     * Instantiates a EditTag use case given a tag
     */
    public EditTag(TagDatabaseGateway tagDatabaseGateway) {
        this.databaseGateway = tagDatabaseGateway;
    }

    /**
     * Edits the name of the tag
     *
     * @param tagRequestModel
     */
    @Override
    public TagResponseModel editTagName(TagRequestModel tagRequestModel) {
        Tag tag = databaseGateway.get(tagRequestModel.getName());
        tag.setName(tagRequestModel.getName());
        return new TagResponseModel(
                tagRequestModel.getName(),
                tagRequestModel.getColor(),
                tagRequestModel.getUser(),
                true
        );
    }

    /**
     * Edits the color of the tag
     *
     * @param tagRequestModel
     */
    @Override
    public TagResponseModel editTagColor(TagRequestModel tagRequestModel) {
        Tag tag = databaseGateway.get(tagRequestModel.getName());
        tag.setColor(tagRequestModel.getColor());
        return new TagResponseModel(
                tagRequestModel.getName(),
                tagRequestModel.getColor(),
                tagRequestModel.getUser(),
                true
        );
    }
}
