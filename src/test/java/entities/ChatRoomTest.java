package entities;
import org.junit.Before;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ChatRoomTest {
    @Before
    public void setUp() {
    }
    ChatRoom temp = new ChatRoom();
    User user1 = new User();
    Message message1 = new Message("abcd", user1);

    @Test
    public void testChatRoomConstructor(){


        //assertion
        assertEquals("chatRoom with messages []", temp.toString());
    }

    @Test
    public void testChatRoomAddMessage(){
        temp.AddMessage(message1);

        //assertion
        assertEquals("chatRoom with messages [abcd]", temp.toString());
    }

    @Test
    public void testChatRoomGetMessages(){
        temp.AddMessage(message1);
        Message message2 = new Message("efgh", user1);
        temp.AddMessage(message2);

        //assertion
        assertEquals("chatRoom with messages [abcd, efgh]", temp.toString());
        assertEquals(temp.GetMessages().get(0), message1);
        assertEquals(temp.GetMessages().get(1), message2);
        assertEquals(temp.GetMessages(1, 0).size(), 1);
    }
}
