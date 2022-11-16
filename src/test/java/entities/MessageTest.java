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

    @After
    public void tearDown() {
    }

    @Test
    public void testMessageToString(){
        Message temp = new Message("abcd");

        //assertion
        assertEquals("abcd", temp.toString());
    }

    @Test
    public void testMessageSetContent(){
        Message temp = new Message("efgh");
        temp.setContent("abcd");

        //assertion
        assertEquals("abcd", temp.toString());
    }

    /*
    This test is not yet implemented because it depends on the User entity.
    @Test
    public void testMessageGetAuthor(){
        user1 = new User();
        Message temp = new Message("abcd", user1);

        //assertion
        assertEquals("abcd", temp.getAuthor());
    }*/

    @Test
    public void testMessageGetDateTime(){
        Message temp = new Message("abcd");
        LocalDateTime tempDate = LocalDateTime.now();

        //assertion
        assertEquals(tempDate.getSecond(), temp.getDateTime().getSecond());
    }
}