package main;

import UI.MainUI;
import controllers.ChatRoomControllers.InitializeViewController;
import controllers.ChatRoomControllers.SendMessageController;
import controllers.ChatRoomControllers.UpdateViewController;
import controllers.ChatRoomControllers.UpdateViewPresenter;
import entities.Task;
import entities.User;
import services.CurrentUserService;
import useCases.ChatRoom.ChatRoomInteractor;
import useCases.ChatRoom.ChatRoomInteractorInterface;

public class main {
    public static void main(String[] args) {
        User user1 = new User();
        CurrentUserService service = new CurrentUserService();
        service.setCurrentUser(user1);
        Task task1 = new Task("Generic assignment", user1);
        ChatRoomInteractor interactor = new ChatRoomInteractor(task1.getChatRoom());
        SendMessageController sender = new SendMessageController(interactor);
        MainUI UI = new MainUI(interactor, sender);
        //UpdateViewPresenter presenter = new UpdateViewPresenter();
    }
}
