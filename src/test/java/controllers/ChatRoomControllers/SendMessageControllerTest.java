package controllers.ChatRoomControllers;
import entities.ChatRoom;
import entities.Message;
import entities.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import useCases.ChatRoom.ChatRoomInteractor;
import useCases.ChatRoom.ChatRoomInteractorInterface;

import java.util.ArrayList;
import java.util.List;

public class SendMessageControllerTest {
    @Before
    public void setUp() {
    }
    ChatRoom room = new ChatRoom();
    ChatRoomInteractorInterface interactor = new ChatRoomInteractor(room);
    User user1 = new User();
    SendMessageController sender = new SendMessageController(interactor);

    @After
    public void tearDown() {
    }

    @Test
    public void TestSendMessage(){
        sender.sendMessageController("abcd");
        List<Message> messages = room.GetMessages();
        assertEquals(messages.size(), 1);
        assertEquals(messages.get(0).toString(), "abcd");
    }
}
