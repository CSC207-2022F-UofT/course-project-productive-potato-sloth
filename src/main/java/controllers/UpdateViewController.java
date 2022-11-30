package controllers;
import entities.User;
import useCases.ChatRoomInteractor;

public class UpdateViewController {
    ChatRoomInteractor interactor;
    public UpdateViewController(ChatRoomInteractor interactor){
        this.interactor = interactor;
    }
    public void UpdateViewController(){
        this.interactor.updateView();
    }
}
