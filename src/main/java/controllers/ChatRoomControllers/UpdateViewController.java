package controllers.ChatRoomControllers;
import useCases.ChatRoom.ChatRoomInteractorInterface;

public class UpdateViewController {
    ChatRoomInteractorInterface interactor;
    public UpdateViewController(ChatRoomInteractorInterface interactor){
        this.interactor = interactor;
    }
    public void UpdateViewController(){
        this.interactor.updateView();
    }

    public void UpdateViewController(boolean direction){
        this.interactor.updateView(direction);
    }
}
