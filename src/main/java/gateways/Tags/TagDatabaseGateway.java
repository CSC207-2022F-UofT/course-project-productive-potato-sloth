package gateways.Tags;

import entities.Tag;
import entities.User;
import gateways.DatabaseGateway;
import gateways.UserDatabaseGateway;
import services.CurrentUserService;

import java.io.IOException;
import java.util.List;

public class TagDatabaseGateway extends DatabaseGateway implements TagDataAccessInterface {

    private final CurrentUserService currentUserService;
    private UserDatabaseGateway userDatabaseGateway;
    private List<User> userList;
    private User currentUser;
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

    public void load() {
        this.userList = userDatabaseGateway.getAll();
        this.currentUser = currentUserService.getCurrentUser();
        this.tagList = currentUser.getTags();
    }

    public Tag get(String name) {
        load();
        for (Tag tag : tagList) {
            if (tag.getName().equals(name)) {
                return tag;
            }
        }
        return null;
    }

    public List<Tag> getAll() {
        load();
        return tagList;
    }

    @Override
    public void insert(Tag tag) {
        load();
        currentUser.addTag(tag);
        userDatabaseGateway.saveToFile();
    }

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
