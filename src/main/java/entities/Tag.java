package entities;

import java.awt.Color;
import java.io.Serializable;

/**
 * A class representing a Tag in the system
 */
public class Tag implements Serializable {
    /**
     * The User (owner) of the tag
     */
    final User user;

    /**
     * The name of the Tag
     */
    String name;

    /**
     * The colour of the tag
     */
    Color color;

    /**
     * The User (owner) of the tag
     */
//    final User user;

    /**
     * Instantiates a new Tag with a name and colour
     *
     * @param name  The name of the Tag
     * @param color The colour of the Tag
     *              // @param user The owner of the Tag
     */
    public Tag(String name, Color color, User user) {
        this.name = name;
        this.color = color;
        this.user = user;
    }

    /**
     * Gets the name of the Tag
     *
     * @return The name of the tag
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the string
     *
     * @param name The new name of the string
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the colour of the Tag
     *
     * @return The colour of the Tag
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets the colour of the Tag
     *
     * @param color The new colour of the Tag
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Gets the owner of the Tag
     */
    public User getUser() {
        return this.user;
    }

}
