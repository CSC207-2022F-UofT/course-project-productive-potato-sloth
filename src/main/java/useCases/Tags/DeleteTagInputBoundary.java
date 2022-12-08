package useCases.Tags;

import gateways.Tags.TagRequestModel;
import gateways.Tags.TagResponseModel;

/**
 * An interface which hides the details of how a Tag is deleted
 */
public interface DeleteTagInputBoundary {

    /**
     * The method which deletes a Tag
     *
     * @param tagRequestModel The information necessary to delete a Tag
     * @return The Response Model containing information about the deleted Tag
     */
    TagResponseModel delete(TagRequestModel tagRequestModel);
}
