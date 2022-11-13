package usecases;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import entities.ChatRoom;

import static org.junit.Assert.*;

public class ChatRoomInteractorTest {
    @Before
    public void setUp() {
    }
    ChatRoom room = new ChatRoom();
    ChatRoomInteractor interactor = new ChatRoomInteractor(room);

    @Test
    public void testMessageToString(){
        interactor.sendMessage("abcd");
        //assertion
        assertEquals("chatRoom with messages [abcd]", room.toString());
    }

    @Test
    public void testEmtyMessage(){
        interactor.sendMessage("");
        //assertion
        assertEquals("chatRoom with messages []", room.toString());
        assertEquals(room.getMessages().size(), 1);
    }
}
