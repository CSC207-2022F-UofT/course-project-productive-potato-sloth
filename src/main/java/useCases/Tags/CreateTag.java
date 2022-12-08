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

    /**
     * The interface which allows access to the TagDatabase
     */
    private final TagDataAccessInterface tagDatabaseGateway;

    /**
     * The Factory class required for creating Tags
     */
    private final TagFactory tagFactory;

    /**
     * The interface which allows access to the UserDatabase
     */
    private final UserDatabaseGateway userDatabaseGateway;
//    private final TagPresenter tagPresenter;


    /**
     * Creates an instance of CreateTag with the required fields
     *
     * @param tagDatabaseGateway  Interface for accessing Tag
     * @param userDatabaseGateway Interface for accessing Users
     * @param tagFactory          Factory for creating Tasks
     */
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
     * Creates a Tag with the fields specified in the Request Model
     *
     * @param tagRequestModel The input data with all required fields relevant to creating a Tag
     * @return The Response Model with all the Tag fields of the new Tag
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
