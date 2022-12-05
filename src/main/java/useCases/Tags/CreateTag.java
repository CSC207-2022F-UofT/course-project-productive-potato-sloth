package useCases.Tags;

import entities.Tag;
import entities.TagFactory;
import entities.User;
import gateways.Tags.TagDataAccessInterface;
import gateways.Tags.TagRequestModel;
import gateways.Tags.TagResponseModel;
import gateways.UserDatabaseGateway;
import presenters.TagPresenter;


/**
 * A use case which creates a new tag for a user
 */
public class CreateTag implements CreateTagInputBoundary {

    private final TagDataAccessInterface tagDatabaseGateway;
    private final TagFactory tagFactory;
    private final UserDatabaseGateway userDatabaseGateway;
//    private final TagPresenter tagPresenter;


    public CreateTag(
            TagDataAccessInterface tagDatabaseGateway,
            UserDatabaseGateway userDatabaseGateway,
            TagFactory tagFactory
//            TagPresenter tagPresenter
    ) {
        this.tagDatabaseGateway = tagDatabaseGateway;
        this.tagFactory = tagFactory;
        this.userDatabaseGateway = userDatabaseGateway;
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
        if (tagDatabaseGateway.contains(tagRequestModel.getName())) {
//            return tagPresenter.prepareFailView("This tag already exists.");
        } else {

            User user = userDatabaseGateway.get(tagRequestModel.getName());

            Tag tag = tagFactory.create(
                    tagRequestModel.getName(),
                    tagRequestModel.getColor(),
                    user
            );

            tagDatabaseGateway.insert(tag);
            return new TagResponseModel(
                    tagRequestModel.getName(),
                    tagRequestModel.getColor(),
                    true
            );
        }
        return null;
    }
}
