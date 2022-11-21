package useCases.Tags;

import entities.User;

import java.awt.*;

public class TagResponseModel {

    private final User user;
    private final String name;
    private final Color color;

    public TagResponseModel(User user, String name, Color color) {
        this.user = user;
        this.name = name;
        this.color = color;

    }

    public User getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

}
