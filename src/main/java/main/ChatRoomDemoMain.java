package main;

import services.CurrentUserService;

public class ChatRoomDemoMain {
    public static void main(String[] args) {
        CurrentUserService service = new CurrentUserService();
        ChatRoomDemo demo = new ChatRoomDemo(service);
        demo.initialize();
    }
}
