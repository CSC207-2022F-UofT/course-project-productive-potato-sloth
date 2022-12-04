package controllers.ChatRoomControllers;
import entities.ChatRoom;
import entities.Task;
import services.CurrentUserService;
import entities.User;
import useCases.ChatRoom.ChatRoomInteractor;

public class InitializeViewController {
    public void InitializeViewController(char marker){
        //use the CurrentUserService to get the current user
        CurrentUserService service = new CurrentUserService();
        User current_user = service.getCurrentUser();
        Task current_task = current_user.getTasks().get((int)marker - 1);
        ChatRoom room = current_task.getChatRoom();
        //call interactor with current task's chatRoom; I wrote a new method within Task to do this.
        //I don't know if calling Entities within a Controller breaks clean architecture or not.
        ChatRoomInteractor interactor = new ChatRoomInteractor(room);
        UpdateViewController viewController = new UpdateViewController(interactor);
        SendMessageController messageController = new SendMessageController(interactor);
        interactor.initializeView();
        //then, call the initializeView method of the interactor, which initializes all the presenters.
        //The presenter initializes the UI.
    }
}
