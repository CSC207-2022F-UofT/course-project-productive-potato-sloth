package controllers;
import entities.User;
import useCases.ChatRoomInteractor;

public class UpdateViewController {
    ChatRoomInteractor interactor;
    public UpdateViewController(ChatRoomInteractor interactor){
        this.interactor = interactor;
    }
    public void UpdateViewController(String message, User user){
        this.interactor.sendMessage(message, user);
    }
}
