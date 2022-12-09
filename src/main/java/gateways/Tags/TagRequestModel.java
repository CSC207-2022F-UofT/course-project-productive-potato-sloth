package gateways.Tags;

import java.awt.Color;

/**
 * A class which is passed into Tag-relevant use cases as a Request
 */
public class TagRequestModel {

    private final String newName;
    private String name;
    private Color color;

    public TagRequestModel(String name, String newName, Color color) {
        this.name = name;
        this.newName = newName;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNewName() {
        return newName;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


}
