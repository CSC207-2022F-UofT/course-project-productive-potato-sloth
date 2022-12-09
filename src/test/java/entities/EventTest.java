package entities;

import java.awt.Color;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import entities.dataObjects.EventDataResponseObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class EventTest {

    User testUser;
    Task task;

    List<Tag> tags;

    @BeforeEach
    public void setup() {
        this.testUser = new User("testUsername", "testPassword");
        this.task = new Task("Test task", testUser);
        String[] tagNameArray = new String[]{"csc207", "coursework", "academics"};
        ArrayList<Tag> tags = new ArrayList<>();
        for(String tagName: tagNameArray){
            Tag tag = new Tag(tagName, Color.RED, testUser);
            tags.add(tag);
        }
        this.tags = tags;
    }

    @Test
    /**
     * Tests the creation of an event given initial parameters.
     */
    public void testCreateEvent(){
        LocalDateTime start_time = LocalDateTime.of(2022, 11, 9, 23, 22);
        LocalDateTime end_time = LocalDateTime.of(2022, 11, 9, 23, 22);
        Event event = new Event(
                start_time,
                end_time,
                this.task,
                "Test Name",
                this.tags
        );
    };

    @Test
    /**
     * Test that the data response object is created properly from an Event.
     */
    public void testPrepareDataResponseObject(){
        LocalDateTime start_time = LocalDateTime.of(2022, 11, 9, 23, 22);
        LocalDateTime end_time = LocalDateTime.of(2022, 11, 9, 23, 22);

        Event event = new Event(
                start_time,
                end_time,
                this.task,
                "Test Name",
                this.tags
        );
        EventDataResponseObject responseObject = event.prepareDataResponseObject();
        assert responseObject.getEventName().equals("Test Name");
        for(int i = 0; i < responseObject.getTagDataObjects().size(); i++){
            assert responseObject.getTagDataObjects().get(i).getName().equals(this.tags.get(i).getName());
        }
        assert responseObject.getStartTime().isEqual(start_time);
        assert responseObject.getEndTime().isEqual(start_time);
    };
}
