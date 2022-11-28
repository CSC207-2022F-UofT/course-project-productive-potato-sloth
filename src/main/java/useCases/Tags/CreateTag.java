package useCases.Tags;

import entities.Tag;
import entities.TagFactory;
import gateways.Tags.TagDataAccessInterface;
import gateways.Tags.TagRequestModel;
import gateways.Tags.TagResponseModel;


/**
 * A use case which creates a new tag for a user
 */
public class CreateTag implements CreateTagInputBoundary {

    final TagDataAccessInterface databaseGateway;
    final TagFactory tagFactory;


    public CreateTag(TagDataAccessInterface tagDatabaseGateway, TagFactory tagFactory /*, TagPreseter tagPresenter */) {
        this.databaseGateway = tagDatabaseGateway;
        this.tagFactory = tagFactory;
//        this.tagPresenter = tagPresenter;
    }

    /**
     * Constructs a CreateTag use case given a name and a color
     *
     * @param tagRequestModel The input data with all required fields
     * @return The output data with all required fields
     */

    @Override
    public TagResponseModel create(TagRequestModel tagRequestModel) {
        if (databaseGateway.contains(tagRequestModel.getName())) {
//            return tagPresenter.prepareFailView("This tag already exists.");
        } else {
            Tag tag = tagFactory.create(
                    tagRequestModel.getName(),
                    tagRequestModel.getColor(),
                    tagRequestModel.getUser()
            );

            databaseGateway.insert(tag);
            return new TagResponseModel(
                    tagRequestModel.getName(),
                    tagRequestModel.getColor(),
                    tagRequestModel.getUser(),
                    true
            );
        }
        return null; // temp for compiling
    }
}
