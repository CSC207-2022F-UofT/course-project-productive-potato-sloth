package useCases.Tags;

import entities.Tag;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;

/**
 * A class that tests the TagInteractor use case
 */
public class TestTagInteractor {

    /**
     * A nested class that tests the static method createTag
     */
    @Nested
    public class TestCreateTag {

        /**
         * A test that tests the name when creating a new Tag
         *
         * @param name The name of the Tag
         */
        @ParameterizedTest
        @ValueSource(strings = {"tag", "t", ""})
        public void testCreateTagName(String name) {
            Tag newTag = TagInteractor.createTag(name, Color.RED);
            assertEquals(newTag.getName(), name);
        }

        /**
         * A test that tests the color when creating a new Tag
         *
         * @param name The name of the Tag
         */
        @ParameterizedTest
        @ValueSource(strings = {"tag", "t", ""})
        public void testCreateTagColor(String name) {
            Tag newTag = TagInteractor.createTag(name, Color.RED);
            assertEquals(newTag.getColor(), Color.RED);
        }

    }

    /**
     * A nested class that tests the static method editTagName
     */
    @Nested
    public class TestEditTagName {

        /**
         * A test that tests the name when editing name
         *
         * @param name The name of the Tag
         */
        @ParameterizedTest
        @ValueSource(strings = {"tag", "t", ""})
        public void testEditTagName(String name) {
            Tag newTag = new Tag(name, Color.RED);
            TagInteractor.editTagName(newTag, name);
            assertEquals(newTag.getName(), name);
        }
    }

    /**
     * A nested class that tests the static method editTagColor
     */
    @Nested
    public class TestEditTagColor {

        /**
         * A test that tests color when changing color to the same color
         *
         * @param name The name of the Tag
         */
        @ParameterizedTest
        @ValueSource(strings = {"tag", "t", ""})
        public void testEditTagColorSame(String name) {
            Tag newTag = new Tag(name, Color.RED);
            TagInteractor.editTagColor(newTag, Color.RED);
            assertEquals(newTag.getColor(), Color.RED);
        }

        /**
         * A test that tests color when changing color to a different color
         *
         * @param name The name of the Tag
         */
        @ParameterizedTest
        @ValueSource(strings = {"tag", "t", ""})
        public void testEditTagColorDifferent(String name) {
            Tag newTag = new Tag(name, Color.RED);
            TagInteractor.editTagColor(newTag, Color.BLUE);
            assertEquals(newTag.getColor(), Color.BLUE);
        }

    }

}
