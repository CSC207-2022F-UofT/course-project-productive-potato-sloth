package controllers.ChatRoomControllers;
import UI.MainUI;
import entities.ChatRoom;
import entities.Message;
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
    SendMessageController sender = new SendMessageController(interactor);
    @After
    public void TearDown(){
    }
    @Test
    public void TestUpdateView(){
        String[] str_list = {"a", "b", "c", "d", "e", "f"};
    }
}