package useCases.ChatRoom;

import controllers.ChatRoomControllers.InitializeViewInterface;
import controllers.ChatRoomControllers.InitializeViewPresenter;
import controllers.ChatRoomControllers.SendMessageController;
import controllers.ChatRoomControllers.UpdateViewPresenterInterface;
import entities.User;
import entities.ChatRoom;
import entities.Message;
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
    }
    public void setPresenter(UpdateViewPresenterInterface presenter){
        this.presenter = presenter;
    }

    public UpdateViewPresenterInterface getPresenter(){
        return this.presenter;
    }

    /**
     * this method returns the messageIndex for testing purposes.
     * @return the current messageIndex.
     */
    @Override
    public int getMessageIndex(){
        return this.messageIndex;
    }
    @Override
    public void sendMessage(String message, User user){
        Message temp_message = new Message(message, user);
        this.room.AddMessage(temp_message);
        List<Message> temp_list = this.room.GetMessages(3, 0);
        List out_list = extractInfo(temp_list);
        if(this.presenter != null) {
            this.presenter.updateView(out_list);
        }
        this.messageIndex = 0;
        updateView();
    }

    /**
     * Since Entities cannot be directly passed into Presenters, below is a helper
    class that takes in a List of Messages and returns a List, in which the first element is the list
    of Strings contained in the input messages the second is the list of usernames, and the third is
    a list of timestamps.
     */
    private List<MessageResponseModel> extractInfo(List<Message> input_list){
        List<MessageResponseModel> out_list = new ArrayList<>();
        for(Message i:input_list){
            out_list.add(new MessageResponseModel(i));
        }
        return out_list;
    }

    /**
     * UpdateView: overloaded method. Takes in an optional boolean to return either the current 3 messages,
     * the previous 3 messages or the next 3 messages. In this case, the method with no boolean parameter
     * returns the current 3 messages as dictated by the MessageIndex.
     * @return
     */
    public List<MessageResponseModel> updateView(){
        List<Message> temp_list = this.room.GetMessages(3, messageIndex);
        List<MessageResponseModel> out_list = extractInfo(temp_list);
        if(this.presenter != null) {
            presenter.updateView(out_list);
        }
        return out_list;
    }

    /**
     * See above. This overloading implements the "scrolling" function by returning either the previous or next 3
     * Messages, based on the parameter direction.
     * @param direction: boolean; True means scroll to older messages; False means scroll to newer messages.
     * @return List of 3 Messages
     */
    public List<MessageResponseModel> updateView(boolean direction){
        if(direction == true){
            messageIndex += 3;
            if(messageIndex > this.room.GetMessages().size()){
                messageIndex = this.room.GetMessages().size();
            }
        }
        else{
            messageIndex -= 3;
            if(messageIndex < 0){
                messageIndex = 0;
            }
        }
        List<Message> temp_list = this.room.GetMessages(3, messageIndex);
        List<MessageResponseModel> out_list = extractInfo(temp_list);
        if(this.presenter != null) {
            presenter.updateView(out_list);
        }
        return out_list;
    }
    @Override
    public void initializeView(){
        InitializeViewInterface initializer = new InitializeViewPresenter((ChatRoomInteractorInterface) this);
        setPresenter(initializer.initializeView(new SendMessageController((ChatRoomInteractorInterface) this)));
        List<MessageResponseModel> temp_list = extractInfo(this.room.GetMessages(3, 0));
        this.presenter.updateView(temp_list);
    }
}
