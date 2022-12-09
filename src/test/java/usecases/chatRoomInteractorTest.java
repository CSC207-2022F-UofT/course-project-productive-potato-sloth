package usecases;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.*;
import entities.ChatRoom;
import entities.User;
import useCases.ChatRoom.ChatRoomInteractor;
import useCases.responseModels.MessageResponseModel;

import java.util.ArrayList;
import java.util.List;

public class chatRoomInteractorTest {
    @Before
    public void setUp() {
    }
    ChatRoom room = new ChatRoom();
    ChatRoomInteractor interactor = new ChatRoomInteractor(room);
    User user1 = new User();

    @After
    public void tearDown() {
    }

    /**
     *This test tests that the SendMessage method updates the ChatRoom.
     */
    @Test
    public void testMessageToString(){
        interactor.sendMessage("abcd", user1);
        //assertion
        Assertions.assertEquals("chatRoom with messages [abcd]", room.toString());
    }

    /**
     * This test tests that the interactor correctly retrieves and returns the 3 newest Messages
     * when the UpdateView method is called with no parameters.
     */
    @Test
    public void testUpdateView(){
        String[] str_array = new String[]{"a", "b", "c", "d", "e", "f"};
        for(String i:str_array){
            interactor.sendMessage(i, user1);
        }
        List<MessageResponseModel> list1 = interactor.updateView();
        List<String> list1Str = new ArrayList<>();
        for(MessageResponseModel i:list1){
            list1Str.add(i.getContent());
        }
        Assertions.assertEquals(interactor.getMessageIndex(), 0);
        Assertions.assertEquals(list1Str.toString(), "[d, e, f]");
    }

    /**
     * This test tests that the interactor correctly retrieves the 3 messages at and older/newer than the MessageIndex
     * depending on the boolean passed into UpdateView.
     */
    @Test
    public void testUpdateViewScroll(){
        String[] str_array = new String[]{"a", "b", "c", "d", "e", "f"};
        for(String i:str_array){
            interactor.sendMessage(i, user1);
        }
        List<MessageResponseModel> list1 = interactor.updateView(true);
        List<String> list1Str = new ArrayList<>();
        for(MessageResponseModel i:list1){
            list1Str.add(i.getContent());
        }
        Assertions.assertEquals(interactor.getMessageIndex(), 3);
        Assertions.assertEquals(list1Str.toString(), "[a, b, c]");
        List<MessageResponseModel> list2 = interactor.updateView(false);
        List<String> list2Str = new ArrayList<>();
        for(MessageResponseModel i:list2){
            list2Str.add(i.getContent());
        }
        Assertions.assertEquals(interactor.getMessageIndex(), 0);
        Assertions.assertEquals(list2Str.toString(), "[d, e, f]");
    }

    @Test
    public void testInitializeView(){
        //test not yet implemented because view initialization method needs to be moved into Main
    }
}
