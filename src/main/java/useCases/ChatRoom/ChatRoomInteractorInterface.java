package useCases.ChatRoom;
import controllers.ChatRoomControllers.UpdateViewPresenterInterface;
import entities.ChatRoom;
import entities.User;
import services.CurrentUserService;
import useCases.responseModels.MessageResponseModel;

import java.util.List;

public interface ChatRoomInteractorInterface {

    public void initializeView();
    public void setService(CurrentUserService service);
    public void setPresenter(UpdateViewPresenterInterface presenter);
    public List<MessageResponseModel> updateView();
    public List<MessageResponseModel> updateView(boolean direction);
    public int getMessageIndex();

    public void sendMessage(String message);
    public void sendMessage(String message, User user);
}
