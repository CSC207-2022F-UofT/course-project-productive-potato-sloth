package useCases.Tags;

import entities.Tag;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;

/**
 * A class which tests the EditTag use case
 */
public class TestEditTag {

    /**
     * A nested class that tests the method editTagName
     */
    @Nested
    public class TestEditTagName {

        /**
         * A test that tests editing name of a Tag which has an empty name
         *
         * @param name The name of the Tag
         */
        @ParameterizedTest
        @ValueSource(strings = {"tag", "t", ""})
        public void testEditNameEmptyName(String name) {
            Tag tag = new Tag("", Color.RED);
            EditTag editTag = new EditTag(tag);
            editTag.editTagName(name);
            assertEquals(tag.getName(), name);
        }

        /**
         * A test that tests editing name of a Tag which has a single char name
         *
         * @param name The name of the Tag
         */
        @ParameterizedTest
        @ValueSource(strings = {"tag", "t", ""})
        public void testEditNameOneChar(String name) {
            Tag tag = new Tag("t", Color.RED);
            EditTag editTag = new EditTag(tag);
            editTag.editTagName(name);
            assertEquals(tag.getName(), name);
        }

        /**
         * A test that tests editing name of a Tag which has a multiple char name
         *
         * @param name The name of the Tag
         */
        @ParameterizedTest
        @ValueSource(strings = {"tag", "t", ""})
        public void testEditNameMultChars(String name) {
            Tag tag = new Tag("tag", Color.RED);
            EditTag editTag = new EditTag(tag);
            editTag.editTagName(name);
            assertEquals(tag.getName(), name);
        }
    }

    /**
     * A nested class that tests the method editTagColor
     */
    @Nested
    public class TestEditTagColor {

        /**
         * A test that tests editing color of a Tag which has the same color
         *
         * @param name The name of the Tag
         */
        @ParameterizedTest
        @ValueSource(strings = {"tag", "t", ""})
        public void testEditColorSame(String name) {
            Tag tag = new Tag(name, Color.RED);
            EditTag editTag = new EditTag(tag);
            editTag.editTagColour(Color.RED);
            assertEquals(tag.getColor(), Color.RED);
        }

        /**
         * A test that tests editing color of a Tag which has a different color
         *
         * @param name The name of the Tag
         */
        @ParameterizedTest
        @ValueSource(strings = {"tag", "t", ""})
        public void testEditColorDifferent(String name) {
            Tag tag = new Tag(name, Color.RED);
            EditTag editTag = new EditTag(tag);
            editTag.editTagColour(Color.BLUE);
            assertEquals(tag.getColor(), Color.BLUE);
        }
    }
}
