package useCases.Tags;

import entities.Tag;
import gateways.Tags.TagDataAccessInterface;
import gateways.Tags.TagRequestModel;
import gateways.Tags.TagResponseModel;

/***
 * A use case which deletes a tag from a user's tags
 */
public class DeleteTag implements DeleteTagInputBoundary {

    /**
     * The interface which allows access to the TagDatabase
     */
    private final TagDataAccessInterface databaseGateway;

    /**
     * Creates an instance of DeleteTag with the required fields
     *
     * @param tagDatabaseGateway Interface for accessing Tag
     */
    public DeleteTag(TagDataAccessInterface tagDatabaseGateway/*, TagPreseter tagPresenter */) {
        this.databaseGateway = tagDatabaseGateway;
//        this.tagPresenter = tagPresenter;
    }

    /**
     * Deletes a Tag with the fields specified in the Request Model
     *
     * @param tagRequestModel The input data with all required fields relevant to deleting a Tag
     * @return The Response Model with all the Tag fields of the deleted Tag
     */
    @Override
    public TagResponseModel delete(TagRequestModel tagRequestModel) {

        if (!databaseGateway.contains(tagRequestModel.getName())) {
//            return tagPresenter.prepareFailView("Tag does not exist")
        } else {

            Tag tag = databaseGateway.get(tagRequestModel.getName());
            databaseGateway.delete(tag);
            return new TagResponseModel(
                    tagRequestModel.getName(),
                    tagRequestModel.getColor(),
                    true
            );
        }
        return null; // temp for compiling
    }
}
