package entities;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class MessageTest {
    @Before
    public void setUp() {
    }
    User user1 = new User();
    Message temp = new Message("abcd", user1);

    /**
     * Tests if the ToString method returns the Message's content String.
     */
    @Test
    public void testMessageToString(){
        //assertion
        assertEquals("abcd", temp.toString());
    }

    /**
     * Tests the setter method for the content String. This method may be necessary for future feature enabling
     * message editing.
     */
    @Test
    public void testMessageSetContent(){
        temp.setContent("efgh");

        //assertion
        assertEquals("efgh", temp.toString());
    }

    /**
     * Tests getter method for author, specifically that it returns the current username of the author.
     */
    @Test
    public void testMessageGetAuthor() {
        user1.setUsername("Kerensky");
        Message temp2 = new Message("", user1);

        //assertion
        assertEquals("Kerensky", temp2.getAuthor());
        assertEquals("Kerensky", temp.getAuthor());
    }

    /**
     * Test that Message entity correctly records when it was created.
     */
    @Test
    public void testMessageGetDateTime(){
        Message temp = new Message("abcd", user1);
        LocalDateTime tempDate = LocalDateTime.now();

        //assertion
        assertEquals(tempDate.getSecond(), temp.getDateTime().getSecond());
    }
}