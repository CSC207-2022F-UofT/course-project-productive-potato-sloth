package gateways.Tags;

import java.awt.*;

/**
 * A class which is returned from Tag-relevant use cases as a Response
 */
public class TagResponseModel {

    private final String name;
    private final Color color;

    private final boolean success;

    public TagResponseModel(String name, Color color, boolean success) {
        this.name = name;
        this.color = color;
        this.success = success;

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
