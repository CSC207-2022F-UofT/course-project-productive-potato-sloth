package useCases.Tags;

import entities.Tag;
import entities.User;

import java.awt.Color;

/**
 * A use case which creates a new tag for a user
 */
public class CreateTag {

    /**
     * Constructs a CreateTag use case given a name and a color
     *
     * @param name  The name of the new Tag
     * @param color The colour of the new Tag
     * @return The new Tag
     */
    public Tag createTag(String name, Color color, User user) {
        return new Tag(name, color, user);
    }
}
