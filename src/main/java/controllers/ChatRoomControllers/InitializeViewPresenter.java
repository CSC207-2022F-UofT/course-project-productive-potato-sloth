package controllers.ChatRoomControllers;

import UI.MainUI;
import useCases.ChatRoom.ChatRoomInteractorInterface;

public class InitializeViewPresenter implements InitializeViewInterface{
    ChatRoomInteractorInterface interactor;
    public InitializeViewPresenter(ChatRoomInteractorInterface interactor){
        this.interactor = interactor;
    }
    @Override
    public UpdateViewPresenterInterface initializeView(SendMessageController messenger){
        UpdateViewPresenterInterface updatePresenter = new UpdateViewPresenter();
        MainUI UI = new MainUI(this.interactor, messenger);
        updatePresenter.setUI(UI);
        UI.setVisible(true);
        return updatePresenter;
    }
}
