package useCases.Tags;

import gateways.Tags.TagInfoRequestModel;
import gateways.Tags.TagInfoResponseModel;

public interface GetTagsInputBoundary {

    TagInfoResponseModel getTags(TagInfoRequestModel tagInfoRequestModel);

}
