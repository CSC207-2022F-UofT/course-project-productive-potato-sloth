package useCases.Tags;

import gateways.Tags.TagRequestModel;
import gateways.Tags.TagResponseModel;

/**
 * An interface which hides the details of how a Tag is edited
 */
public interface EditTagInputBoundary {

    /**
     * The method which edits the name of a Tag
     *
     * @param tagRequestModel The information necessary to edit a Tag name
     * @return The Response Model containing information about the Tag
     */
    TagResponseModel editTagName(TagRequestModel tagRequestModel);

    /**
     * The method which edits the colour of a Tag
     *
     * @param tagRequestModel The information necessary to edit a Tag colour
     * @return The Response Model containing information about the Tag
     */
    TagResponseModel editTagColor(TagRequestModel tagRequestModel);
}
