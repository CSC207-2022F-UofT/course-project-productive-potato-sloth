package useCases.Tags;

import entities.Tag;
import entities.User;

import java.awt.Color;

/***
 * A facade class that allows interactions with the Tag entity
 */
public class TagInteractor {

    /**
     * Creates a tag instance
     *
     * @param name  The name of the tag
     * @param color The color of the tag
     * @return The new tag
     */
    public static Tag createTag(String name, Color color, User user) {
        CreateTag createTag = new CreateTag();
        return createTag.createTag(name, color, user);
    }

    /**
     * Edits a tag instance
     *
     * @param tag  The instance of the tag
     * @param name The new name of the tag
     */
    public static void editTagName(Tag tag, String name) {
        EditTag editTag = new EditTag(tag);
        editTag.editTagName(name);
    }

    /**
     * Edits a tag instance
     *
     * @param tag   The instance of the tag
     * @param color The new color of the tag
     */
    public static void editTagDescription(Tag tag, Color color) {
        EditTag editTag = new EditTag(tag);
        editTag.editTagColour(color);
    }
}
