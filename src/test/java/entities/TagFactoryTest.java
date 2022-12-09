package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TagFactoryTest {

    User user;
    TagFactory tagFactory;

    @BeforeEach
    public void setup() {
        this.user = new User();
        this.tagFactory = new TagFactory();

    }

    @ParameterizedTest
    @ValueSource(strings = {"tag", "t", ""})
    public void testTagName(String name) {
        Tag tag = tagFactory.create(name, Color.RED, user);
        assertEquals(tag.getName(), name);
    }

    /**
     * A test which tests the getColor method of Tag
     *
     * @param name The name of the Tag
     */
    @ParameterizedTest
    @ValueSource(strings = {"tag", "t", ""})
    public void testTagColor(String name) {
        Tag tag = tagFactory.create(name, Color.RED, user);
        assertEquals(tag.getColor(), Color.RED);
    }

}
