package gateways.Tags;

import java.awt.Color;

/**
 * A class which is returned from Tag-relevant use cases as a Response
 */
public class TagResponseModel {

    private final String name;
    private final Color color;

    public TagResponseModel(String name, Color color) {
        this.name = name;
        this.color = color;

    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }


}
