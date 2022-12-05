package entities;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.*;

import static org.junit.Assert.*;

public class ChatRoomTest {
    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testChatRoomConstructor(){
        ChatRoom temp = new ChatRoom();

        //assertion
        assertEquals("chatRoom with messages []", temp.toString());
    }

    @Test
    public void testChatRoomAddMessage(){
        ChatRoom temp = new ChatRoom();
        temp.AddMessage(new Message("abcd"));

        //assertion
        assertEquals("chatRoom with messages [abcd]", temp.toString());
    }

    @Test
    public void testChatRoomGetMessages(){
        ChatRoom temp = new ChatRoom();
        temp.AddMessage(new Message("abcd"));
        temp.AddMessage(new Message("efgh"));

        //assertion
        assertEquals("chatRoom with messages [abcd, efgh]", temp.toString());
    }
}
