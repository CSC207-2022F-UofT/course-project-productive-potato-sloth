package entities;

import java.awt.Color;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    Tag tag;
    User user;

    @BeforeEach
    public void setup() {
        this.tag = new Tag("tag", Color.RED);
        this.user = new User("testUsername", "testPassword");
    }

    /**
     * A test which tests instantiation of Task with only a name
     *
     * @param name The name of the Tag
     */
    @ParameterizedTest
    @ValueSource(strings = {"tag", "t", ""})
    public void testTaskName(String name) {
        Task task = new Task(name, user);
        assertEquals(task.getName(), name);
    }

    /**
     * A test which tests instantiation of Task with a name and a description
     *
     * @param description The description of the Tag
     */
    @ParameterizedTest
    @ValueSource(strings = {"tag", "t", ""})
    public void testTaskNameDescription(String description) {
        Task task = new Task("tag", user, description);
        assertEquals(task.getDescription(), description);
    }

    /**
     * A test which tests the setName method of Task
     *
     * @param name The new name of the Task
     */
    @ParameterizedTest
    @ValueSource(strings = {"tag", "t", ""})
    public void testTaskSetName(String name) {
        Task task = new Task("tag", user, "description");
        task.setName(name);
        assertEquals(task.getName(), name);
    }

    /**
     * A test which tests the setDescription method of Task
     *
     * @param description The new name of the Task
     */
    @ParameterizedTest
    @ValueSource(strings = {"tag", "t", ""})
    public void testTaskSetDescription(String description) {
        Task task = new Task("tag", user, "description");
        task.setDescription(description);
        assertEquals(task.getDescription(), description);
    }

    /**
     * A test which tests the addTag method of Task
     */
    @Test
    public void testTaskAddTag() {
        Tag tag2 = new Tag("tag2", Color.RED);
        Task task = new Task("tag", user, "");
        task.addTag(tag);
        assertEquals(task.getTags().size(), 1);
        assertEquals(task.getTags().get(1), tag);
        task.addTag(tag2);
        assertEquals(task.getTags().size(), 2);
        assertEquals(task.getTags().get(0), tag);
        assertEquals(task.getTags().get(1), tag2);
    }

    /**
     * A test which tests the removeTag method of Task
     */
    @Test
    public void testTaskRemoveTag() {
        Tag tag2 = new Tag("tag2", Color.RED);
        Task task = new Task("tag", user, "description");
        task.addTag(tag);
        task.addTag(tag2);
        assertEquals(task.getTags().size(), 2);
        assertEquals(task.getTags().get(0), tag);
        assertEquals(task.getTags().get(1), tag2);

        task.removeTag(tag);
        assertEquals(task.getTags().size(), 1);
        assertEquals(task.getTags().get(0), tag2);

    }

    /**
     * A test which tests the setCompleted method of Task
     */
    @Test
    public void testTaskSetCompleted() {
        Task task = new Task("tag", user, "description");
        assertEquals(task.getCompleted(), false);
        task.setCompleted();
        assertTrue(task.getCompleted());
    }

    /**
     * A test which tests the setIncompleted method of Task
     */
    @Test
    public void testTaskSetIncompleted() {
        Task task = new Task("tag", user, "description");
        task.setCompleted();
        task.setIncompleted();
        assertFalse(task.getCompleted());
    }

}
