package controllers.ChatRoomControllers;

import useCases.ChatRoom.ChatRoomInteractorInterface;

public class SendMessageController implements SendMessageInterface{
    ChatRoomInteractorInterface interactor;
    public SendMessageController(ChatRoomInteractorInterface interactor){
        this.interactor = interactor;
    }
    public void sendMessageController(String message){
        this.interactor.sendMessage(message);
    }
}
