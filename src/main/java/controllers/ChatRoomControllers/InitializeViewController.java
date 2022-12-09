package controllers.ChatRoomControllers;
import entities.ChatRoom;
import entities.Task;
import services.CurrentUserService;
import entities.User;
import useCases.ChatRoom.ChatRoomInteractor;
import useCases.ChatRoom.ChatRoomInteractorInterface;

/**
 * This class is intended to begin the initialization process of the ChatRoom-interactor-UI system
 * from a button. Further description below (line by line). Since it is only going to be called by the UI
 * I did not add an interface for this class.
 */
public class InitializeViewController {
    /**
     * This method takes in a String (name of Task) and a CurrentUserService to initialize the interactor of the
     * ChatRoom and call the interactor's initialization method.
     * @param marker: the name of the Task. The Task must be contained within the current User.
     * @param service: a CurrentUserService that has the CurrentUser set to a User;
     */
    public void InitializeView(String marker, CurrentUserService service) {
        //use the CurrentUserService to get the current user
        User current_user = service.getCurrentUser();
        Task current_task = null;
        for (Task i : current_user.getTasks()) {
            if (i.getName().equals(marker)) {
                current_task = i;
            }
        }
        ChatRoom room = current_task.getChatRoom();
        //call interactor with current task's chatRoom; I wrote a new method within Task to do this.
        ChatRoomInteractorInterface interactor = new ChatRoomInteractor(room);
        interactor.setService(service);
        interactor.initializeView();
        //then, call the initializeView method of the interactor, which initializes all the presenters.
        //The presenter initializes the UI.
    }
}
