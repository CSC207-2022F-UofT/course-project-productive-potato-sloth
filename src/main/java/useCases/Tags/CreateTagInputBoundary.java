package useCases.Tags;

import gateways.Tags.TagRequestModel;
import gateways.Tags.TagResponseModel;

public interface CreateTagInputBoundary {
    TagResponseModel create(TagRequestModel tagRequestModel);
}
