package main;

import UI.MainUI;
import controllers.ChatRoomControllers.SendMessageController;
import controllers.ChatRoomControllers.UpdateViewPresenter;
import entities.Task;
import entities.User;
import services.CurrentUserService;
import usecases.ChatRoom.ChatRoomInteractor;

public class main {
    public static void main(String[] args) {
        User user1 = new User();
        user1.setUsername("Soyuz Nerushimy");
        CurrentUserService service = new CurrentUserService();
        service.setCurrentUser(user1);
        Task task1 = new Task("Generic assignment", user1);
        ChatRoomInteractor interactor = new ChatRoomInteractor(task1.getChatRoom());
        interactor.setService(service);
        SendMessageController sender = new SendMessageController(interactor);
        MainUI UI = new MainUI(interactor, sender);
        UpdateViewPresenter presenter = new UpdateViewPresenter();
        presenter.setUI(UI);
        interactor.setPresenter(presenter);
    }
}
