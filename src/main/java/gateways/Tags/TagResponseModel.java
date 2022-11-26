package gateways.Tags;

import entities.User;

import java.awt.*;

public class TagResponseModel {

    private final User user;
    private final String name;
    private final Color color;

    private final boolean success;

    public TagResponseModel(String name, Color color, User user, boolean success) {
        this.user = user;
        this.name = name;
        this.color = color;
        this.success = success;

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

    public boolean getSuccess() {
        return success;
    }

}
