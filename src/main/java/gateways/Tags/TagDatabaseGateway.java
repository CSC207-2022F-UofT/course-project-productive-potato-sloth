package gateways.Tags;

import entities.Tag;
import entities.User;
import gateways.DatabaseGateway;
import gateways.UserDatabaseGateway;
import services.CurrentUserService;

import java.io.IOException;
import java.util.List;

/**
 * A Gateway class which connects to the database and contains operations for Tags
 */
public class TagDatabaseGateway extends DatabaseGateway implements TagDataAccessInterface {

    /**
     * Service for accessing the current logged-in user
     */
    private final CurrentUserService currentUserService;

    /**
     * The interface which allows access to the UserDatabase
     */
    private final UserDatabaseGateway userDatabaseGateway;

    /**
     * The current user
     */
    private User currentUser;

    /**
     * The list of tags for the user
     */
    private List<Tag> tagList;


    /**
     * Instantiating DatabaseGateway with a relative path will store the absolute path to the respective database.
     * If the file at the path does not exist, one will be created
     * This absolute path can be fetched using the getAbsoluteFilepath method
     *
     * @throws IOException Throws exception if encountering failed or interrupted IO exceptions
     */
    public TagDatabaseGateway(CurrentUserService currentUserService, UserDatabaseGateway userDatabaseGateway) throws IOException {
        super(userDatabaseGateway.getAbsoluteFilepath());
        this.currentUserService = currentUserService;
        this.userDatabaseGateway = userDatabaseGateway;
        load();
    }

    /**
     * Loads all users, the current user, and the tags of the current user
     */
    public void load() {
        List<User> userList = userDatabaseGateway.getAll();
        this.currentUser = currentUserService.getCurrentUser();
        this.tagList = currentUser.getTags();
    }

    /**
     * Retrieves the Tag from the database given a name
     * This method will always retrieve from the currently logged-in user
     *
     * @param name The name of the Tag
     * @return The Tag object matching the name
     */
    public Tag get(String name) {
        load();
        for (Tag tag : tagList) {
            if (tag.getName().equals(name)) {
                return tag;
            }
        }
        return null;
    }

    /**
     * Retrieves all Tags from the database
     * This method will only retrieve Tags from the currently logged-in user
     *
     * @return A list of the current user's tags
     */
    public List<Tag> getAll() {
        load();
        return tagList;
    }

    /**
     * Adds a Tag to the current user's Tags
     * This method will automatically persist the changes
     * No additional calls to this class are required to save changes
     *
     * @param tag The tag to add to the current user
     */
    @Override
    public void insert(Tag tag) {
        load();
        currentUser.addTag(tag);
        userDatabaseGateway.saveToFile();
    }

    /**
     * Updates an existing Tag in the current user's Tags
     * This method will automatically persist the changes
     * No additional calls to this class are required to save changes
     *
     * @param tag The tag to be updated
     * @return A boolean representing if the update succeeded
     */
    @Override
    public boolean update(Tag tag) {
        load();
        try {
            delete(tag);
            insert(tag);
        } catch (Exception e) {
            userDatabaseGateway.saveToFile();
            return false;
        }
        userDatabaseGateway.saveToFile();
        return true;
    }

    /**
     * Deletes an existing tag in the current logged-in user's Tags
     * This method will automatically persist the changes
     * No additional calls to this class are required to save changes
     *
     * @param tag The tag to be removed
     * @return A boolean representing if the delete was successful
     */
    @Override
    public boolean delete(Tag tag) {
        load();
        try {
            currentUser.removeTag(tag);
        } catch (Exception e) {
            userDatabaseGateway.saveToFile();
            return false;
        }
        userDatabaseGateway.saveToFile();
        return true;
    }

    /**
     * Checks if a Tag exists in the currently logged-in user's Tags
     *
     * @param name The name of the Tag to be checked
     * @return A boolean representing if the Tag already exists
     */
    @Override
    public boolean contains(String name) {
        load();
        for (Tag tag : tagList) {
            if (tag.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }


}
