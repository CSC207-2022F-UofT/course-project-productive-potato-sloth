package gateways;

import entities.Tag;
import entities.User;
import gateways.Tags.TagDatabaseGateway;
import org.junit.jupiter.api.Test;
import services.CurrentUserService;

import java.awt.*;
import java.io.IOException;

public class TestTagDatabaseGateway {

    @Test
    public void test() throws IOException, ClassNotFoundException {
        CurrentUserService currentUserService = new CurrentUserService();
        User user = new User();
        user.changeUsername("a");
        currentUserService.setCurrentUser(user);
        UserDatabaseGateway userDatabaseGateway = new UserDatabaseGateway("src/main/java/database/testTagDatabaseGateway.ser");
        userDatabaseGateway.insert(user);
        userDatabaseGateway.saveToFile();

        Tag tag1 = new Tag("name", Color.BLACK, user);
        TagDatabaseGateway tagDatabaseGateway = new TagDatabaseGateway(currentUserService, userDatabaseGateway);

        tagDatabaseGateway.insert(tag1);
        tagDatabaseGateway.insert(tag1);
        tagDatabaseGateway.delete(tag1);
        tagDatabaseGateway.load();
        System.out.println(tagDatabaseGateway.getAll());

    }
}
