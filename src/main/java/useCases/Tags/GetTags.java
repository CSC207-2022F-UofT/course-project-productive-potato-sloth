package useCases.Tags;

import entities.Event;
import entities.Tag;
import entities.Task;
import entities.User;
import gateways.Tags.TagDataAccessInterface;
import gateways.Tags.TagInfoRequestModel;
import gateways.Tags.TagInfoResponseModel;
import gateways.Tasks.TaskDataAccessInterface;
import gateways.Tasks.TaskInfoRequestModel;
import gateways.Tasks.TaskInfoResponseModel;
import presenters.TaskInfoPresenter;
import services.CurrentUserService;

import java.util.ArrayList;

public class GetTags implements GetTagsInputBoundary {

    /**
     * The interface which allows access to tags
     */
    final TagDataAccessInterface tagDatabaseAccess;

    /**
     * The presenter for Tag info
     */
    final TaskInfoPresenter taskInfoPresenter;

    /**
     * The service allowing access to the current user
     */
    final CurrentUserService currentUserService;

    /**
     * Creates an instance of GetTaskInfo with the required fields
     *
     * @param tagDatabaseAccess  Interface for accessing Tasks
     * @param taskInfoPresenter  Presenter for Task info
     * @param currentUserService Service for accessing the logged-in user
     */
    public GetTags(TagDataAccessInterface tagDatabaseAccess, TaskInfoPresenter taskInfoPresenter, CurrentUserService currentUserService) {
        this.tagDatabaseAccess = tagDatabaseAccess;
        this.taskInfoPresenter = taskInfoPresenter;
        this.currentUserService = currentUserService;
    }

    /**
     * Gets all the Tags of the currently logged-in user
     *
     * @param tagInfoRequestModel Contains the name of the Task for which to return information
     * @return A Response Model containing the Tags
     */
    @Override
    public TagInfoResponseModel getTags(TagInfoRequestModel tagInfoRequestModel) {
        TagInfoResponseModel response = new TagInfoResponseModel();
        for (Tag tag : currentUserService.getCurrentUser().getTags()) {
            response.addTag(tag.getName());
        }
        return response;
    }
}
