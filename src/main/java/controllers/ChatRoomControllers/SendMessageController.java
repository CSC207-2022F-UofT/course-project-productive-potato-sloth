package controllers.ChatRoomControllers;
import entities.User;
import useCases.ChatRoom.ChatRoomInteractorInterface;

public class SendMessageController implements SendMessageInterface{
    ChatRoomInteractorInterface interactor;
    public SendMessageController(ChatRoomInteractorInterface interactor){
        this.interactor = interactor;
    }
    public void sendMessageController(String message, User user){
        this.interactor.sendMessage(message, user);
    }
}
