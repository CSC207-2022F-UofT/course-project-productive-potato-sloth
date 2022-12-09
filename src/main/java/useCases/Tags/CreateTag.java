package useCases.Tags;

import entities.Tag;
import entities.TagFactory;
import entities.User;
import gateways.Tags.TagDataAccessInterface;
import gateways.Tags.TagRequestModel;
import gateways.Tags.TagResponseModel;
import presenters.TagPresenter;
import services.CurrentUserService;


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
     * The current user service
     */
    private final CurrentUserService currentUserService;

    /**
     * The tag presenter
     */
    private final TagPresenter tagPresenter;


    /**
     * Creates an instance of CreateTag with the required fields
     *
     * @param tagDatabaseGateway Interface for accessing Tag
     * @param tagFactory         Factory for creating Tasks
     * @param tagPresenter       The presenter for tags
     */
    public CreateTag(
            TagDataAccessInterface tagDatabaseGateway,
            TagFactory tagFactory,
            TagPresenter tagPresenter,
            CurrentUserService currentUserService
    ) {
        this.tagDatabaseGateway = tagDatabaseGateway;
        this.tagFactory = tagFactory;
        this.tagPresenter = tagPresenter;
        this.currentUserService = currentUserService;
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
            return tagPresenter.prepareFailView("This tag already exists.");
        } else {

            User user = currentUserService.getCurrentUser();

            Tag tag = tagFactory.create(
                    tagRequestModel.getName(),
                    tagRequestModel.getColor(),
                    user
            );

            tagDatabaseGateway.insert(tag);


            TagResponseModel response = new TagResponseModel(
                    tagRequestModel.getName(),
                    tagRequestModel.getColor()
            );
            return tagPresenter.prepareSuccessView(response);
        }
    }
}
