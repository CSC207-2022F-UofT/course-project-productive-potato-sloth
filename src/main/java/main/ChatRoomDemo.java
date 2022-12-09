package main;

import UI.MainUI;
import controllers.ChatRoomControllers.SendMessageController;
import controllers.ChatRoomControllers.UpdateViewPresenter;
import entities.Task;
import entities.User;
import services.CurrentUserService;
import useCases.ChatRoom.ChatRoomInteractor;

/**
 * This is the main class for demonstrating the ChatRoom feature and only the ChatRoom feature. It
 * creates a dummy User with username "Soyuz Nerushimy", a dummy task "Generic assignment" and a complete ChatRoom
 * feature based on the two. The User should be able to send messages and scroll through messages.
 *
 * If there already exists a User passed into this class, then it uses the passed user and a dummy Task.
 */
public class ChatRoomDemo {
    CurrentUserService service;
    public ChatRoomDemo(CurrentUserService service){
        this.service = service;
    }
    public void initialize() {
        User user1 = this.service.getCurrentUser();
        if (user1 == null) {
            user1 = new User();
            user1.setUsername("Soyuz Nerushimy");
            this.service.setCurrentUser(user1);
        }
        Task task1 = new Task("Generic assignment", user1);
        ChatRoomInteractor interactor = new ChatRoomInteractor(task1.getChatRoom());
        interactor.setService(this.service);
        SendMessageController sender = new SendMessageController(interactor);
        MainUI UI = new MainUI(sender);
        UpdateViewPresenter presenter = new UpdateViewPresenter();
        presenter.setUI(UI);
        interactor.setPresenter(presenter);
    }
}
