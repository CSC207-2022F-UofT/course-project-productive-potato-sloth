package useCases.Tags;

import entities.Tag;
import gateways.Tags.TagDataAccessInterface;
import gateways.Tags.TagRequestModel;
import gateways.Tags.TagResponseModel;

/***
 * A use case which deletes a tag from a user's tags
 */
public class DeleteTag implements DeleteTagInputBoundary {

    private final TagDataAccessInterface databaseGateway;

    public DeleteTag(TagDataAccessInterface tagDatabaseGateway/*, TagPreseter tagPresenter */) {
        this.databaseGateway = tagDatabaseGateway;
//        this.tagPresenter = tagPresenter;
    }

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
