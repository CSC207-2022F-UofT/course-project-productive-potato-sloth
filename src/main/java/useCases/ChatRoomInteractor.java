package useCases;

import controllers.UpdateViewPresenter;
import entities.User;
import entities.ChatRoom;
import entities.Message;
import controllers.UpdateViewPresenterInterface;
import useCases.responseModels.MessageResponseModel;

import java.util.ArrayList;
import java.util.List;

public class ChatRoomInteractor implements ChatRoomInteractorInterface{
    ChatRoom room;
    int messageIndex;
    UpdateViewPresenterInterface presenter;
    public ChatRoomInteractor(ChatRoom room){
        this.room = room;
        this.messageIndex = 0;
        this.presenter = new UpdateViewPresenter();
    }
    @Override
    public void sendMessage(String message, User user){
        Message temp_message = new Message(message, user);
        this.room.AddMessage(temp_message);
        List<Message> temp_list = this.room.GetMessages(3, 0);
        List out_list = extractInfo(temp_list);
        presenter.updateView(out_list);
        this.messageIndex = 0;
    }
    /*Since Entities cannot be directly passed into Presenters, below is a helper
    class that takes in a List of Messages and returns a List, in which the first element is the list
    of Strings contained in the input messages the second is the list of usernames, and the third is
    a list of timestamps.
     */
    private List extractInfo(List<Message> input_list){
        List<MessageResponseModel> out_list = new ArrayList<>();
        for(Message i:input_list){
            out_list.add(new MessageResponseModel(i));
        }
        return out_list;
    }
    public List<MessageResponseModel> updateView(){
        List<Message> temp_list = this.room.GetMessages(3, messageIndex);
        List out_list = extractInfo(temp_list);
        presenter.updateView(out_list);
        messageIndex -= 3;
        return out_list;
    }
    @Override
    public void initializeView(){
        //InitializeViewInterface();--this is supposed th initialize the window with text fields and the like.
        //List temp_list = room.GetMessages(3);
        //UpdateViewPresenterInterface.updateView(temp_list);
    }
}
