package entities;
import org.junit.Before;
import org.junit.jupiter.api.*;

import static org.junit.Assert.*;

public class ChatRoomTest {
    @Before
    public void setUp() {
    }
    ChatRoom temp = new ChatRoom();
    User user1 = new User();

    @Test
    public void testChatRoomConstructor(){


        //assertion
        assertEquals("chatRoom with messages []", temp.toString());
    }

    @Test
    public void testChatRoomAddMessage(){
        temp.AddMessage(new Message("abcd", user1));

        //assertion
        assertEquals("chatRoom with messages [abcd]", temp.toString());
    }

    @Test
    public void testChatRoomGetMessages(){
        temp.AddMessage(new Message("abcd", user1));
        temp.AddMessage(new Message("efgh", user1));

        //assertion
        assertEquals("chatRoom with messages [abcd, efgh]", temp.toString());
    }
}
