package useCases;
import entities.ChatRoom;
import entities.User;

public interface ChatRoomInteractorInterface {

    public void initializeView();

    public void sendMessage(String message, User user);
}
