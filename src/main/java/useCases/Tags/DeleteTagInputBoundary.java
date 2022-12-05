package useCases.Tags;

import gateways.Tags.TagRequestModel;
import gateways.Tags.TagResponseModel;

public interface DeleteTagInputBoundary {
    TagResponseModel delete(TagRequestModel tagRequestModel);
}
