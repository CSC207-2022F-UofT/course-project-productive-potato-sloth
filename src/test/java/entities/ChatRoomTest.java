package entities;
import org.junit.After;
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

    @After
    public void TearDown() {
    }
    /**
     * This test tests the ChatRoom is constructed and its ToString method is overridden correctly.
     */
    @Test
    public void testChatRoomConstructor(){


        //assertion
        assertEquals("chatRoom with messages []", temp.toString());
    }

    /**
     * This test tests that the AddMessage method works correctly.
     */
    @Test
    public void testChatRoomAddMessage(){
        temp.AddMessage(message1);

        //assertion
        assertEquals("chatRoom with messages [abcd]", temp.toString());
    }

    /**
     * This test tests that the GetMessages method returns a List of all of its Messages, from old to new.
     */
    @Test
    public void testChatRoomGetMessages(){
        assertEquals(temp.GetMessages().size(), 0);
        temp.AddMessage(message1);
        Message message2 = new Message("efgh", user1);
        temp.AddMessage(message2);

        //assertion
        assertEquals("chatRoom with messages [abcd, efgh]", temp.toString());
        assertEquals(temp.GetMessages().get(0), message1);
        assertEquals(temp.GetMessages().get(1), message2);
        assertEquals(temp.GetMessages(1, 0).size(), 1);
    }

    /**
     * This method checks that the second GetMessages method by testing that the second parameter corresponds to the
     * index of the newest/oldest returned message on the reverse of the list of messages (i.e. how far that message is
     * from the end of the list, not the start), and the first corresponds to how many messages to get, with positive
     * numbers meaning "get messages at and older than indexed message" and negative ones meaning "get messages at
     * and newer than indexed message". The method should also not throw an error when the number of messages requested
     * is more than the number of Messages contained in this ChatRoom.
     */
    @Test
    public void testChatRoomGetMessagesIndexed(){
        List<Message> str_list = new ArrayList<>();
        str_list.add(new Message("a", user1));
        str_list.add(new Message("b", user1));
        str_list.add(new Message("c", user1));
        str_list.add(new Message("d", user1));
        str_list.add(new Message("e", user1));
        str_list.add(new Message("f", user1));
        for(Message i:str_list){
            temp.AddMessage(i);
        }
        List<Message> second_half = new ArrayList<>();
        List<Message> first_half = new ArrayList<>();
        for (int i = 0; i <= 2; i++){
            first_half.add(str_list.get(i));
            second_half.add(str_list.get(i+3));
        }
        assertEquals(temp.GetMessages(3, 0), second_half);
        assertEquals(temp.GetMessages(-3, 3), second_half);
        assertEquals(temp.GetMessages(3,3), first_half);
        assertEquals(temp.GetMessages(-3,6), first_half);
        assertEquals(temp.GetMessages(3,5).size(), 1);

    }
}
