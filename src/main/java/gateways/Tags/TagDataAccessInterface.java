package gateways.Tags;

import entities.Tag;
import gateways.DataAccessInterface;

/**
 * An interface which hides the implementation details of the connection to the database
 */
public interface TagDataAccessInterface extends DataAccessInterface<Tag> {

    /**
     * Checks if a Tag exists in the currently logged-in user's Tags
     *
     * @param name The name of the Tag to be checked
     * @return A boolean representing if the Tag already exists
     */
    boolean contains(String name);
}
