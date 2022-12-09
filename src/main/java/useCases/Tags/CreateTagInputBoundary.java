package useCases.Tags;

import gateways.Tags.TagRequestModel;
import gateways.Tags.TagResponseModel;

/**
 * An interface which hides the details of how a Tag is created
 */
public interface CreateTagInputBoundary {

    /**
     * The method which creates a Tag
     *
     * @param tagRequestModel The information necessary to create a Tag
     * @return The Response Model containing information about the Tag
     */
    TagResponseModel create(TagRequestModel tagRequestModel);
}
