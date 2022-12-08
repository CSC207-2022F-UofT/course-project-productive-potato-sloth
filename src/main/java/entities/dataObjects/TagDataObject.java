package entities.dataObjects;

import java.awt.*;

public class TagDataObject {

    String name;
    Color color;

    public TagDataObject(String name, Color color){
        this.name = name;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }
}
