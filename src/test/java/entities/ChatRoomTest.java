package entities;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class ChatRoomTest {
    @Before
    public void setUp() {
    }
    ChatRoom temp = new ChatRoom();

    @Test
    public void testChatRoomConstructor(){


        //assertion
        assertEquals("chatRoom with messages []", temp.toString());
    }

    @Test
    public void testChatRoomAddMessage(){
        temp.addMessage(new Message("abcd"));

        //assertion
        assertEquals("chatRoom with messages [abcd]", temp.toString());
    }

    @Test
    public void testChatRoomGetMessages(){
        temp.addMessage(new Message("abcd"));
        temp.addMessage(new Message("efgh"));

        //assertion
        assertEquals("chatRoom with messages [abcd, efgh]", temp.toString());
    }
}
