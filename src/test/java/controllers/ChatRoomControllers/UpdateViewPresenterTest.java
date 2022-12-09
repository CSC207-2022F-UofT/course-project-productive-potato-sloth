package controllers.ChatRoomControllers;
import entities.ChatRoom;
import entities.Message;
import entities.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import usecases.ChatRoom.ChatRoomInteractor;
import usecases.ChatRoom.ChatRoomInteractorInterface;
import usecases.responseModels.MessageResponseModel;

import java.util.ArrayList;
import java.util.List;

public class UpdateViewPresenterTest {
    @Before
    public void SetUp(){
    }
    ChatRoom room = new ChatRoom();
    User user1 = new User();
    ChatRoomInteractorInterface interactor = new ChatRoomInteractor(room);
    UpdateViewPresenter presenter = new UpdateViewPresenter();
    String[] str_list = {"a", "b", "c"};
    @After
    public void TearDown(){
    }

    /**
     * This test tests that the presenter returns the correct List of ResponseModel objects.
     * Since that is going to be the same List passed into the UI (which is the only thing the presenter does),
     * this is how we know the correct object is being passed.
     */
    @Test
    public void TestUpdateView(){
        List<MessageResponseModel> msg_list = new ArrayList<>();
        for(String i: str_list){
            Message msg = new Message(i, user1);
            msg_list.add(new MessageResponseModel(msg));
        }
        List<MessageResponseModel> temp_list = presenter.updateView(msg_list);
        assertEquals(temp_list, msg_list);
    }
}
