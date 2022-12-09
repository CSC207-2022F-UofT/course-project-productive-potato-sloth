package entities;

import java.awt.Color;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A class which tests the Tag entity
 */
public class TagTest {

    User user;

    @BeforeEach
    public void setup() {
        this.user = new User();
    }

    /**
     * A test which tests the getName method of Tag
     *
     * @param name The name of the Tag
     */
    @ParameterizedTest
    @ValueSource(strings = {"tag", "t", ""})
    public void testTagName(String name) {
        Tag tag = new Tag(name, Color.RED, user);
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
        Tag tag = new Tag(name, Color.RED, user);
        assertEquals(tag.getColor(), Color.RED);
    }

    /**
     * A test which tests the setName method of Tag
     *
     * @param name The name of the Tag
     */
    @ParameterizedTest
    @ValueSource(strings = {"tag", "t", ""})
    public void testTagSetName(String name) {
        Tag tag = new Tag(name, Color.RED, user);
        tag.setName("tag2");
        assertEquals(tag.getName(), "tag2");
    }

    /**
     * A test which tests the setColor method of Tag
     *
     * @param name The name of the Tag
     */
    @ParameterizedTest
    @ValueSource(strings = {"tag", "t", ""})
    public void testTagSetColor(String name) {
        Tag tag = new Tag(name, Color.RED, user);
        tag.setColor(Color.BLUE);
        assertEquals(tag.getColor(), Color.BLUE);
    }

    /**
     * A test which tests the setColor method of Tag where the color to be
     * set and the existing Tag color are the same
     *
     * @param name The name of the Tag
     */
    @ParameterizedTest
    @ValueSource(strings = {"tag", "t", ""})
    public void testTagSetSameColor(String name) {
        Tag tag = new Tag(name, Color.RED, user);
        tag.setColor(Color.RED);
        assertEquals(tag.getColor(), Color.RED);
    }

}
