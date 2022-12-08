package gateways.Tags;

import java.awt.Color;

/**
 * A class which is passed into Tag-relevant use cases as a Request
 */
public class TagRequestModel {

    private String name;
    private Color color;

    public TagRequestModel(String name, Color color) {
        this.name = name;
        this.color = color;
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
