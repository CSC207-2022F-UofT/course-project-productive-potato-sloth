package controllers.ChatRoomControllers;

import UI.MainUI;
import useCases.ChatRoom.ChatRoomInteractorInterface;

public class InitializeViewPresenter implements InitializeViewInterface{
    ChatRoomInteractorInterface interactor;
    public InitializeViewPresenter(ChatRoomInteractorInterface interactor){
        this.interactor = interactor;
    }

    /**
     * This class initializes the UI and links it to the presenters and by extension, the interactor.
     * @param messenger: a SendMessageController that has a reference to the Interactor.
     * @return the UpdateViewPresenter that has a reference to the UI.
     */
    @Override
    public UpdateViewPresenterInterface initializeView(SendMessageController messenger){
        UpdateViewPresenterInterface updatePresenter = new UpdateViewPresenter();
        MainUI UI = new MainUI(messenger);
        updatePresenter.setUI(UI);
        return updatePresenter;
    }
}
