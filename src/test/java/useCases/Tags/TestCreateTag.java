package useCases.Tags;

import entities.Tag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;

/**
 * A class which tests the CreateTag use case
 */
public class TestCreateTag {

    /**
     * Instance of CreateTag
     */
    CreateTag createTag;

    /**
     * Creating a new instance of CreateTag before each test
     */
    @BeforeEach
    void setup() {
        this.createTag = new CreateTag();
    }

    /**
     * A test which tests the name of Tag using CreateTag
     *
     * @param name The name of the Tag
     */
    @ParameterizedTest
    @ValueSource(strings = {"tag", "t", ""})
    public void testCreateTagName(String name) {
        Tag newTag = this.createTag.createTag(name, Color.RED);
        assertEquals(newTag.getName(), name);
    }

    /**
     * A test which tests the color of Tag using CreateTag
     *
     * @param name The name of the Tag
     */
    @ParameterizedTest
    @ValueSource(strings = {"tag", "t", ""})
    public void testCreateTagColor(String name) {
        Tag newTag = this.createTag.createTag(name, Color.RED);
        assertEquals(newTag.getColor(), Color.RED);
    }
}
