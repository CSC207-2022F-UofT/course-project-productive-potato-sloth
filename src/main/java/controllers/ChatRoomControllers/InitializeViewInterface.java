package controllers.ChatRoomControllers;

/**
 * Note this is the interface of the InitializeViewPresenter, not the controller.
 */
public interface InitializeViewInterface {
    UpdateViewPresenterInterface initializeView(SendMessageController messenger);
}
