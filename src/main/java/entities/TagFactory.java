package entities;

import java.awt.Color;

/**
 * A Factory Pattern that creates a tag
 * <p>
 * This class abstracts away the details of creating a tag,
 * changing the constructor only requires change in this class
 */
public class TagFactory {

    /**
     * Creates a new Tag with the following parameters
     *
     * @param name  Name of the Tag
     * @param color Colour of the Tag
     * @param user  User creating the Tag
     * @return The new Tag
     */
    public Tag create(String name, Color color, User user) {
        return new Tag(name, color, user);
    }

}
