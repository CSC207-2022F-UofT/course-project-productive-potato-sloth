package useCases;

import controllers.UpdateViewPresenter;
import entities.User;
import entities.ChatRoom;
import entities.Message;
import controllers.UpdateViewPresenterInterface;

import java.util.ArrayList;
import java.util.List;

public class ChatRoomInteractor {
    ChatRoom room;
    UpdateViewPresenterInterface presenter;

    public ChatRoomInteractor(ChatRoom room){
        this.room = room;
        this.presenter = new UpdateViewPresenter();
    }
    public void sendMessage(String message, User user){
        Message temp_message = new Message(message, user);
        this.room.AddMessage(temp_message);
        List<Message> temp_list = room.GetMessages(3, 0);
        List out_list = extractInfo(temp_list);
        presenter.updateView((List) out_list.get(0), (List) out_list.get(1), (List) out_list.get(2));
    }
    /*Since Entities cannot be directly passed into Presenters, below is a helper
    class that takes in a List of Messages and returns a List, in which the first element is the list
    of Strings contained in the input messages the second is the list of usernames, and the third is
    a list of timestamps.
     */
    private List extractInfo(List<Message> input_list){
        List<List> out_list = new ArrayList<>();
        List str_list = new ArrayList();
        List user_list = new ArrayList();
        List time_list = new ArrayList();
        out_list.add(str_list);
        out_list.add(user_list);
        out_list.add(time_list);
        for(Message i:input_list){
            str_list.add(i.toString());
            user_list.add(i.getAuthor());
            time_list.add(i.getDateTime());
        }
        return out_list;
    }
    public void initializeView(){
        //InitializeViewInterface();--this is supposed th initialize the window with text fields and the like.
        //List temp_list = room.GetMessages(3);
        //UpdateViewPresenterInterface.updateView(temp_list);
    }
}
