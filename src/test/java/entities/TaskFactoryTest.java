package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTest {

    Tag tag;
    User user;
    TaskFactory taskFactory;

    @BeforeEach
    public void setup() {
        this.user = new User();
        this.tag = new Tag("tag", Color.RED, this.user);
        this.taskFactory = new TaskFactory();
    }

    /**
     * A test which tests instantiation of Task with only a name
     *
     * @param name The name of the Tag
     */
    @ParameterizedTest
    @ValueSource(strings = {"tag", "t", ""})
    public void testTaskName(String name) {
        Task task = taskFactory.create(name, user);
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
        Task task = taskFactory.create("name", user, description);
        assertEquals(task.getDescription(), description);
    }


}
