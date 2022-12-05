package useCases.Tags;

import gateways.Tags.TagRequestModel;
import gateways.Tags.TagResponseModel;

public interface EditTagInputBoundary {
    TagResponseModel editTagName(TagRequestModel tagRequestModel);

    TagResponseModel editTagColor(TagRequestModel tagRequestModel);
}
