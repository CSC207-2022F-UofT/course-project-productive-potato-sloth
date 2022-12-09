package controllers.ChatRoomControllers;
import entities.ChatRoom;
import entities.Message;
import entities.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import services.CurrentUserService;
import useCases.ChatRoom.ChatRoomInteractor;
import useCases.ChatRoom.ChatRoomInteractorInterface;

import java.util.List;

public class SendMessageControllerTest {
    @Before
    public void setUp() {
    }

    /**
     * Here we set up a ChatRoom, an interactor associated with the ChatRoom with a CurrentUserService
     * to facilitate the interactor getting the current user (which is needed for creating a Message),
     * a User and a SendMessageController.
     */
    ChatRoom room = new ChatRoom();
    ChatRoomInteractorInterface interactor = new ChatRoomInteractor(room);
    CurrentUserService service1 = new CurrentUserService();
    User user1 = new User();
    SendMessageController sender = new SendMessageController(interactor);

    @After
    public void tearDown() {
    }

    /**
     *This test tests that when the SendMessageController's send message method is called,
     * the SendMessageController calls the interactor and the Messages inside ChatRoom are updated.
     */
    @Test
    public void TestSendMessage(){
        service1.setCurrentUser(user1);
        interactor.setService(service1);
        sender.sendMessageController("abcd");
        List<Message> messages = room.GetMessages();
        assertEquals(messages.size(), 1);
        assertEquals(messages.get(0).toString(), "abcd");
    }
}
