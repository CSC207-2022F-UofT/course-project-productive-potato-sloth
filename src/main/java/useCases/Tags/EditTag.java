package useCases.Tags;

import entities.Tag;
import gateways.Tags.TagDataAccessInterface;
import gateways.Tags.TagRequestModel;
import gateways.Tags.TagResponseModel;
import presenters.TagPresenter;

/**
 * A use case which edits a tag
 */
public class EditTag implements EditTagInputBoundary {

    /**
     * The interface which allows access to the TagDatabase
     */
    final TagDataAccessInterface tagDatabaseGateway;

    /**
     * The tag presenter
     */
    final TagPresenter tagPresenter;

    /**
     * Creates an instance of EditTag with the required fields
     *
     * @param tagDatabaseGateway Interface for accessing Tag
     */
    public EditTag(TagDataAccessInterface tagDatabaseGateway, TagPresenter tagPresenter) {
        this.tagDatabaseGateway = tagDatabaseGateway;
        this.tagPresenter = tagPresenter;
    }

    /**
     * Edits a Tag with the fields specified in the Request Model
     *
     * @param tagRequestModel The input data with all required fields relevant to editing a Tag name
     * @return The Response Model with all the Tag fields
     */
    @Override
    public TagResponseModel editTagName(TagRequestModel tagRequestModel) {

        if (tagDatabaseGateway.contains(tagRequestModel.getNewName()) && !(tagRequestModel.getName().equals(tagRequestModel.getNewName()))) {
            return tagPresenter.prepareFailView("Tag already exists!");
        }

        Tag tag = tagDatabaseGateway.get(tagRequestModel.getName());
        tag.setName(tagRequestModel.getNewName());
        tagDatabaseGateway.update(tag);

        TagResponseModel response = new TagResponseModel(
                tagRequestModel.getNewName(),
                tagRequestModel.getColor()
        );
        return tagPresenter.prepareSuccessView(response);
    }

    /**
     * Edits a Tag with the fields specified in the Request Model
     *
     * @param tagRequestModel The input data with all required fields relevant to editing a Tag description
     * @return The Response Model with all the Tag fields
     */
    @Override
    public TagResponseModel editTagColor(TagRequestModel tagRequestModel) {
        Tag tag = tagDatabaseGateway.get(tagRequestModel.getName());
        tag.setColor(tagRequestModel.getColor());
        tagDatabaseGateway.update(tag);

        TagResponseModel response = new TagResponseModel(
                tagRequestModel.getName(),
                tagRequestModel.getColor()
        );
        return tagPresenter.prepareSuccessView(response);
    }
}
