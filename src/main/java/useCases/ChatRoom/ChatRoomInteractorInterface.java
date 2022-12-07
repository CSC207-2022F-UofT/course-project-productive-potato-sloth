package useCases.ChatRoom;
import entities.ChatRoom;
import entities.User;
import useCases.responseModels.MessageResponseModel;

import java.util.List;

public interface ChatRoomInteractorInterface {

    public void initializeView();
    public List<MessageResponseModel> updateView();
    public List<MessageResponseModel> updateView(boolean direction);
    public int getMessageIndex();

    public void sendMessage(String message);
    public void sendMessage(String message, User user);
}
