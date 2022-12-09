package controllers.ChatRoomControllers;
import usecases.ChatRoom.ChatRoomInteractorInterface;

public class UpdateViewController {
    /**
     * This class is used to call the interactor and facilitate the UI scrolling through existing messages.
     */
    ChatRoomInteractorInterface interactor;
    public UpdateViewController(ChatRoomInteractorInterface interactor){
        this.interactor = interactor;
    }

    /**
     * the UpdateView method call with no parameters is used to refresh (scroll down to the bottom) of
     * all messages whenever the current user sends a message.
     */
    public void UpdateViewController(){
        this.interactor.updateView();
    }

    /**
     * This method scrolls the list of messages either up or down.
     * @param direction: boolean--True: scroll to older messages, False: scroll to newer messages
     */
    public void UpdateViewController(boolean direction){
        this.interactor.updateView(direction);
    }
}
