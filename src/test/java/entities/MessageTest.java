package entities;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class MessageTest {
    @Before
    public void setUp() {
    }
    Message temp = new Message("abcd");

    @Test
    public void testMessageToString(){

        //assertion
        assertEquals("abcd", temp.toString());
    }

    @Test
    public void testMessageSetContent(){
        temp.setContent("efgh");

        //assertion
        assertEquals("efgh", temp.toString());
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
        Message temp2 = new Message("efgh");
        LocalDateTime tempDate = LocalDateTime.now();

        //assertion
        assertEquals(tempDate.getSecond(), temp2.getDateTime().getSecond());
    }
}