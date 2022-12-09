package useCases;

import entities.*;

public class ChatRoomInteractor {
    ChatRoom room;

    public ChatRoomInteractor(ChatRoom room) {
        this.room = room;
    }

    public void sendMessage(String message/*, User user*/) {
        Message temp_message = new Message(message/*, user*/);
        this.room.AddMessage(temp_message);
        /*ChatRoomPresenterInterface.updateView();
         * --this line both saves to a .txt file and updates the view according to the file. It may be split into 2
         * separate methods later.*/
    }
}
