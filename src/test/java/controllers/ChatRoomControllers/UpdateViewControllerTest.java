package controllers.ChatRoomControllers;
import entities.ChatRoom;
import entities.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import useCases.ChatRoom.ChatRoomInteractor;
import useCases.ChatRoom.ChatRoomInteractorInterface;

public class UpdateViewControllerTest {
    @Before
    public void SetUp(){
    }
    ChatRoom room = new ChatRoom();
    ChatRoomInteractorInterface interactor = new ChatRoomInteractor(room);
    UpdateViewController updater = new UpdateViewController(interactor);
    User user1 = new User();
    @After
    public void TearDown(){
    }
    @Test
    public void TestUpdateView(){
        String[] str_list = {"a", "b", "c", "d", "e", "f"};
        for(String i:str_list){
            interactor.sendMessage(i, user1);
        }
        updater.UpdateViewController();
        assertEquals(interactor.getMessageIndex(), 0);
        updater.UpdateViewController(true);
        assertEquals(interactor.getMessageIndex(), 3);
        updater.UpdateViewController(false);
        assertEquals(interactor.getMessageIndex(), 0);

    }
}