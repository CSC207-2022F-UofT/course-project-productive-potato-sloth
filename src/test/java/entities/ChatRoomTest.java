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
