package controllers.ChatRoomControllers;
import entities.ChatRoom;
import entities.Task;
import services.CurrentUserService;
import entities.User;
import usecases.ChatRoom.ChatRoomInteractor;

/**
 * This class is intended to begin the initialization process of the ChatRoom-interactor-UI system
 * from a button. Further description below (line by line). Since it is only going to be called by the UI
 * I did not add an interface for this class.
 */
public class InitializeViewController {
    public void InitializeView(char marker, CurrentUserService service){
        //use the CurrentUserService to get the current user
        User current_user = service.getCurrentUser();
        Task current_task = current_user.getTasks().get((int)marker - 1);
        ChatRoom room = current_task.getChatRoom();
        //call interactor with current task's chatRoom; I wrote a new method within Task to do this.
        ChatRoomInteractor interactor = new ChatRoomInteractor(room);
        interactor.setService(service);
        interactor.initializeView();
        //then, call the initializeView method of the interactor, which initializes all the presenters.
        //The presenter initializes the UI.
    }
}
