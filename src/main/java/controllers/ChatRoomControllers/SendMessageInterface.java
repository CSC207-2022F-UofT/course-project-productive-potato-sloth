package controllers.ChatRoomControllers;


import useCases.ChatRoom.ChatRoomInteractorInterface;

public interface SendMessageInterface {
    ChatRoomInteractorInterface getInteractor();
    void sendMessageController(String message);
}
