package useCases.Tags;

import entities.Tag;

import java.awt.Color;

/**
 * A use case which edits a tag
 */
public class EditTag {

    Tag tag;

    /**
     * Instantiates a EditTag use case given a tag
     *
     * @param tag The tag to be edited
     */
    public EditTag(Tag tag) {
        this.tag = tag;
    }

    /**
     * Edits the name of the tag
     *
     * @param name The name to be changed to
     */
    public void editTagName(String name) {
        this.tag.setName(name);
    }

    /**
     * Edits the color of the tag
     *
     * @param color The color to be changed to
     */
    public void editTagColour(Color color) {
        this.tag.setColor(color);
    }

}
