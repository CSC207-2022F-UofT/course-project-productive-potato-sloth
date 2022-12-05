package entities;

import java.awt.Color;

public class TagFactory {

    public Tag create(String name, Color color, User user) {
        return new Tag(name, color, user);
    }
    
}
