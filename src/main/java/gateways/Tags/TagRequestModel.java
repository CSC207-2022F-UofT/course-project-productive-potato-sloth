package gateways.Tags;

import entities.User;

import java.awt.Color;

public class TagRequestModel {

    private User user;
    private String name;
    private Color color;

    public TagRequestModel(User user, String name, Color color) {
        this.user = user;
        this.name = name;
        this.color = color;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


}
