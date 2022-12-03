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
public class UpdateViewPresenterTest {
    @Before
    public void SetUp(){
    }
    ChatRoom room = new ChatRoom();
    ChatRoomInteractorInterface interactor = new ChatRoomInteractor(room);
    SendMessageController sender = new SendMessageController(interactor);
    MainUI UI = new MainUI(interactor, sender);
    UpdateViewPresenter presenter = new UpdateViewPresenter();
    @After
    public void TearDown(){
    }

    @Test
    public void TestUpdateView(){
        presenter.setUI(UI);
        //TODO: implement the rest of this test
    }
}
