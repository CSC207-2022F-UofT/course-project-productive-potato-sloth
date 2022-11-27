package controllers;
import entities.User;
import useCases.ChatRoomInteractor;

public class SendMessageController {
    ChatRoomInteractor interactor;
    public SendMessageController(ChatRoomInteractor interactor){
        this.interactor = interactor;
    }
    public void sendMessageController(String message, User user){
        this.interactor.sendMessage(message, user);
    }
}
