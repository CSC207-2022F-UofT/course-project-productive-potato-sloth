package presenters;

import gateways.Tags.TagResponseModel;

public interface TagPresenter {

    TagResponseModel prepareSuccessView(TagResponseModel tagResponseModel);

    TagResponseModel prepareFailView(String errorMessage);
}
