package useCases;
import controllers.ChatRoomControllers.UpdateViewPresenter;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.*;
import entities.*;
import useCases.ChatRoom.ChatRoomInteractor;
import controllers.ChatRoomControllers.UpdateViewPresenterInterface;
import useCases.responseModels.MessageResponseModel;

import java.util.List;

import static org.junit.Assert.*;

public class ChatRoomInteractorTest {
    @Before
    public void setUp() {
    }
    ChatRoom room = new ChatRoom();
    ChatRoomInteractor interactor = new ChatRoomInteractor(room);
    User user1 = new User();

    @After
    public void tearDown() {
    }

    @Test
    public void testMessageToString(){

        interactor.sendMessage("abcd", user1);
        //assertion
        assertEquals("chatRoom with messages [abcd]", room.toString());
    }

    @Test
    public void testUpdateView(){
        String[] str_array = new String[]{"a", "b", "c", "d", "e", "f"};
        for(String i:str_array){
            interactor.sendMessage(i, user1);
        }
        List<MessageResponseModel> list1 = interactor.updateView();
        assertEquals(interactor.getMessageIndex(), 3);
        assertEquals(list1.toString(), "[d, e, f]");
    }

    @Test
    public void testInitializeView(){
        //test not yet implemented because view initialization method needs to be moved into Main
    }
}
