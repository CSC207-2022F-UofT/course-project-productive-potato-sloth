package controllers.ChatRoomControllers;

import useCases.ChatRoom.ChatRoomInteractorInterface;

/**
 * The only  purpose of this controller class is to call the interactor and pass along the message String.
 * The interactor will initialize a new Message entity with the String as content.
 */
public class SendMessageController implements SendMessageInterface{
    ChatRoomInteractorInterface interactor;
    public SendMessageController(ChatRoomInteractorInterface interactor){
        this.interactor = interactor;
    }

    /**
     * Passes a String from UI (which calls this method from an ActionListener) to the interactor.
     * @param message: String, content of the message being sent
     */
    public void sendMessageController(String message){
        this.interactor.sendMessage(message);
    }
}
