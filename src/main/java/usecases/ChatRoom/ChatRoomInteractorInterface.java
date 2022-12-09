package usecases.ChatRoom;
import controllers.ChatRoomControllers.UpdateViewPresenterInterface;
import entities.User;
import services.CurrentUserService;
import usecases.responseModels.MessageResponseModel;

import java.util.List;

public interface ChatRoomInteractorInterface {
    /**
     * This is the interface for the interactor.
     */
    public void initializeView();
    public void setService(CurrentUserService service);
    public void setPresenter(UpdateViewPresenterInterface presenter);
    public List<MessageResponseModel> updateView();
    public List<MessageResponseModel> updateView(boolean direction);
    public int getMessageIndex();

    public void sendMessage(String message);
    public void sendMessage(String message, User user);
}
