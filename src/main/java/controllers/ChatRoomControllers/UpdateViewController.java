package controllers.ChatRoomControllers;
import useCases.ChatRoom.ChatRoomInteractor;

public class UpdateViewController {
    ChatRoomInteractor interactor;
    public UpdateViewController(ChatRoomInteractor interactor){
        this.interactor = interactor;
    }
    public void UpdateViewController(){
        this.interactor.updateView();
    }
}
