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

    @Test
    public void testMessageGetAuthor() {
        user1.changeUsername("Kerensky");
        Message temp2 = new Message("", user1);

        //assertion
        assertEquals("Kerensky", temp2.getAuthor());
    }

    @Test
    public void testMessageGetDateTime(){
        Message temp = new Message("abcd", user1);
        LocalDateTime tempDate = LocalDateTime.now();

        //assertion
        assertEquals(tempDate.getSecond(), temp.getDateTime().getSecond());
    }
}