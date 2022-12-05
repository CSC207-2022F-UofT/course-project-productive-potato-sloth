package usecases;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.*;
import entities.*;

import static org.junit.Assert.*;

public class ChatRoomInteractorTest {
    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testMessageToString(){
        ChatRoom room = new ChatRoom();
        ChatRoomInteractor interactor = new ChatRoomInteractor(room);
        interactor.sendMessage("abcd");
        //assertion
        assertEquals("chatRoom with messages [abcd]", room.toString());
    }
}
