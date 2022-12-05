package presenters;

import gateways.Tags.TagResponseModel;
import screens.TaskList.TagError;

public class TagResponseFormatter implements TagPresenter {
    @Override
    public TagResponseModel prepareSuccessView(TagResponseModel tagResponseModel) {
        
        return tagResponseModel;
    }

    @Override
    public TagResponseModel prepareFailView(String errorMessage) {
        throw new TagError(errorMessage);
    }
}
